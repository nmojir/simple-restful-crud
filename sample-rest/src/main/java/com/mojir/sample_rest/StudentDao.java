package com.mojir.sample_rest;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mojir.restful_core.dao.AbstractDao;
import com.mojir.sample_rest.Student;

/**
 * Sample DAO. 
 * I've used EJB for dependency injection here. You can do it differently!
 * @author Navid
 *
 */
@Stateless
public class StudentDao extends AbstractDao<Student> {

	@PersistenceContext(name = "SAMPLE-DAO")
	private EntityManager entityManager;
	
	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	public StudentDao() {
		super(Student.class);
	}
	
	

}
