package com.mojir.restful_core.interfaces;

/**
 * Entities should implement this interface.
 * @author Navid
 *
 */
//TODO: I'm limiting the id to int here. I should think for a different solution.
// ID can be an Object not limited to int
public interface IEntity {
	public void setId(int id);
	public int getId();
}
