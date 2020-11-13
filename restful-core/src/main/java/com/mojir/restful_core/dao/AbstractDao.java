package com.mojir.restful_core.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mojir.restful_core.dtos.Paging;
import com.mojir.restful_core.dtos.ResultsCapsule;
import com.mojir.restful_core.dtos.Sorting;
import com.mojir.restful_core.dtos.WhereClause;

/**
 * This is an abstract dao class which has CRUD and search operations ready.
 * @author Navid
 *
 * @param <T>
 */
public abstract class AbstractDao <T> {
	protected Class<T> entityClass;

	public AbstractDao() {
	}

	public AbstractDao(Class<T> entityClass) 
	{
		this.entityClass = entityClass;
	}

	protected abstract EntityManager getEntityManager();

	public void insert(T entity) 
	{
		getEntityManager().persist(entity);
		getEntityManager().flush();
	}

	public void delete(T entity) 
	{
		entity = getEntityManager().merge(entity);
		getEntityManager().remove(entity);
		getEntityManager().flush();
	}

	@SuppressWarnings("rawtypes")
	public List findByParam(String queryName, String parameterValue) 
	{
		Query query = getEntityManager().createNamedQuery(queryName);
		query.setParameter(1, parameterValue);

		return query.getResultList();
	}

	public T find(Object id) 
	{
		return getEntityManager().find(this.entityClass, id);
	}
	
	@SuppressWarnings({ "unchecked" })
	public T find(Object id, Class<?> c) 
	{
		return (T) getEntityManager().find(c, id);
	}

	@SuppressWarnings("unchecked")
	public T getReference(Object id, Class<?> c) 
	{
		return (T) getEntityManager().getReference(c, id);
	}
	
	@SuppressWarnings("unchecked")
	public ResultsCapsule<T> findAll(Paging paging, Sorting sorting, List<WhereClause> filters) 
	{
		String queryString = "SELECT p from " + entityClass.getSimpleName() + " p ";
		String whereQuery = generateWhereQuery(filters);
		
		queryString += (whereQuery == null) ? "" : whereQuery;
		
		String sortingQuery = "";
		if (sorting != null && sorting.getSortField() != null)
			sortingQuery = generateSortingQuery(sorting, "p");
		
		queryString += sortingQuery;
		
		Query query = getEntityManager().createQuery(queryString);
		addPaging(query, paging);
		
		String sizeQueryString = generateSizeWhereQuery(whereQuery, "p");
		Query sizeQuery = getEntityManager().createQuery(sizeQueryString);

		setParameterOnQuery(query, filters);
		setParameterOnQuery(sizeQuery, filters);

		long size = (Long) sizeQuery.getSingleResult();
		return new ResultsCapsule<>(size, (List<T>) query.getResultList());
	}

	protected String generateSizeWhereQuery(String whereQuery, String prefix) 
	{
		String respStr = "SELECT COUNT (" + prefix + ") from " + entityClass.getSimpleName() + " " + prefix + " ";
		respStr += (whereQuery == null) ? "" : whereQuery;
		return respStr;

	}

	/**
	 * If one field used in order by("sortField" in "Sorting" object has been set),use this method.
	 * @param sorting
	 * @param prefix
	 * @return String sortingQuery
	 */
	protected String generateSortingQuery(Sorting sorting, String prefix) 
	{
		String sortingQuery = "";		
		if (sorting != null)
		{
			String sortingOrder = sorting.isAscending() ? "ASC" : "DESC";
			if (sorting.getSortField() != null)
				sortingQuery += " order by " + prefix + "." + sorting.getSortField()
						+ " " + sortingOrder + " NULLS LAST ";
		}
		return sortingQuery;
	}

	
	protected void addPaging(Query query, Paging paging) 
	{
		if(paging != null)
		{
			if (paging.getPageSize() != -1) {
				query.setMaxResults(paging.getPageSize());
			}
			query.setFirstResult(paging.getCurrentPage() * paging.getPageSize());
		}
		
	}

	public T update(T entity) 
	{
		T t = getEntityManager().merge(entity);
		getEntityManager().flush();
		return t;
	}

	public void detach(T entity) 
	{
		getEntityManager().detach(entity);
		getEntityManager().flush();
	}

	public void refresh(T entity) 
	{
		getEntityManager().refresh(entity);
		getEntityManager().flush();
	}
	
	protected String generateWhereQuery(List<WhereClause> filters)
	{		
		StringBuilder whereQuery = new StringBuilder();
		
		if (filters != null && !filters.isEmpty()) 
		{
			whereQuery.append(" where 1=1 ");
			
			for (WhereClause whereClause : filters) 
			{
				if (whereClause.isParametric())
				{
					if(whereClause.getOperator().equalsIgnoreCase("in"))//adding support of IN operator
					{
						whereQuery.append(" AND p." + whereClause.getField() + " "
								+ whereClause.getOperator() + " (:" + whereClause.getParameterName() + ")");
					}
					else
					{
						whereQuery.append((" AND p." + whereClause.getField() + " "
								+ whereClause.getOperator() + " :" + whereClause
								.getParameterName()));
					}
				}
				else
					whereQuery.append(" AND p." + whereClause.getField());
			}
		}
		return whereQuery.toString();
	}
	
	protected void setParameterOnQuery(Query query, List<WhereClause> filters)
	{
		if (filters != null && !filters.isEmpty())
		{
			for (WhereClause whereClause : filters)
			{
				if (whereClause.isParametric())
				{
					query.setParameter(whereClause.getParameterName(),
							whereClause.getValue());				
				}
			}
		}
	}

}
