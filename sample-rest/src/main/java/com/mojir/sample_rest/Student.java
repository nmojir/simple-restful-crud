package com.mojir.sample_rest;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mojir.restful_core.interfaces.IEntity;

/**
 * Sample entity.
 * @author Navid
 *
 */
@Entity
public class Student implements IEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
