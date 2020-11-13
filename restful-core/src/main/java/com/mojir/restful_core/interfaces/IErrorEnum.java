package com.mojir.restful_core.interfaces;

/**
 * The enumeration of the errors should implement this interface.
 * @author Navid
 *
 */
public interface IErrorEnum {
	/**
	 * @return the string representation of the error code.
	 * For example INTERNAL_ERROR or NOT_FOUND
	 */
	public String getString();
	
	public int getCode();
}
