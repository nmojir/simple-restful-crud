package com.mojir.restful_core.impls;


import javax.ws.rs.core.Response;

import com.mojir.restful_core.dao.AbstractDao;
import com.mojir.restful_core.dtos.Paging;
import com.mojir.restful_core.dtos.ResultsCapsule;
import com.mojir.restful_core.dtos.SearchRequestDto;
import com.mojir.restful_core.dtos.Sorting;
import com.mojir.restful_core.exceptions.EntityNotFoundException;
import com.mojir.restful_core.exceptions.WebServiceException;
import com.mojir.restful_core.interfaces.ICrudService;
import com.mojir.restful_core.interfaces.IEntity;

/**
 * A generic abstract implementation of ICrudService interface.
 * @author Navid
 *
 * @param <T> Type of the entity
 * @param <SearchReqType> Search request dto for the given entity
 */
public abstract class AbstractCrudService <T extends IEntity, SearchReqType extends SearchRequestDto> 
	implements ICrudService<T, SearchReqType>
{
	public abstract AbstractDao<T> getDao();
	
	public T create(T entity) throws WebServiceException {
		getDao().insert(entity);
		return entity;
	}

	public ResultsCapsule<T> search(SearchReqType req) throws WebServiceException {
		return getDao().findAll(
				req.getPaging(), 
				req.getSorting(), 
				req.getFiltersWhereClauses()
			);
	}
	
	public T retrieve(int id) throws WebServiceException {
		return findEntity(id);
	}

	public T update(int id, T entity) throws WebServiceException {
		T foundEntity = findEntity(id);
		foundEntity = entity;
		foundEntity.setId(id);
		return getDao().update(foundEntity);
	}

	public Response delete(int id) throws WebServiceException {
		T entity = findEntity(id);
		getDao().delete(entity);
		return Response.ok().build();
	}
	
	private T findEntity(int id) throws EntityNotFoundException
	{
		T foundEntity = getDao().find(id);
		if(foundEntity == null)
			throw new EntityNotFoundException("The requested entity with id <" + id + "> was not found.", null);
		return foundEntity;
	}

	@Override
	public ResultsCapsule<T> list(int pageSize, int currentPage, String sortField, boolean ascending)
			throws WebServiceException {
		return getDao().findAll(
				new Paging(pageSize, currentPage), 
				new Sorting(sortField, ascending), 
				null
			);
	}
	
	
	
}
