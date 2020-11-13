package com.mojir.sample_rest;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

import com.mojir.restful_core.dao.AbstractDao;
import com.mojir.restful_core.impls.AbstractCrudService;

/**
 * The concrete implementation of the CRUD service.
 * Here we must define entity and search request types. (<Student, StudentSearchReqDto>)
 * Also we need to return the required dao.
 * Another custom web services can be implemented here.
 * Note: I've used EJB for dependency injection here. You can do it differently!
 * @author Navid
 *
 */
@Stateless
@Path("/students")
public class StudentService extends AbstractCrudService<Student, StudentSearchReqDto> {

	@EJB
	StudentDao dao;
	
	@Override
	public AbstractDao<Student> getDao() {
		return dao;
	}
	
	
	

}
