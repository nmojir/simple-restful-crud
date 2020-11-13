package com.mojir.restful_core.interfaces;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mojir.restful_core.dtos.ResultsCapsule;
import com.mojir.restful_core.dtos.SearchRequestDto;
import com.mojir.restful_core.exceptions.WebServiceException;

/**
 * The interface of the REST CRUD web services.
 * @author Navid
 *
 * @param <T> Type of the entity
 * @param <SearchReqType> Search request dto for the given entity
 */
public interface ICrudService <T extends IEntity, searchReqType extends SearchRequestDto>{
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public T create(T req) throws WebServiceException;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)	
	public ResultsCapsule<T> list(
			@QueryParam("pageSize") int pageSize,
			@QueryParam("currentPage") int currentPage,
			@QueryParam("sortField") String sortField,
			@QueryParam("ascending") boolean ascending	
		) throws WebServiceException;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/search")
	public ResultsCapsule<T> search(searchReqType req) throws WebServiceException;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)	
	@Path("/{id}")
	//TODO: int id??!!
	public T retrieve(@PathParam("id") int id) throws WebServiceException;
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public T update(@PathParam("id") int id, T entity) throws WebServiceException;
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) throws WebServiceException;
}
