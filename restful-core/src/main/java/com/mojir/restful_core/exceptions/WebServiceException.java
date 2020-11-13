package com.mojir.restful_core.exceptions;

import javax.ws.rs.core.Response.Status;

import com.mojir.restful_core.dtos.ErrorDto;

/**
 * The base class of exceptions which are supposed to be sent to clients. 
 * See {@code WebServiceExceptionMapper}
 * @author Navid
 *
 */
@SuppressWarnings("serial")
public abstract class WebServiceException extends Exception {
	public WebServiceException(ErrorDto error, Throwable cause)
	{
		super(error.getMessage(), cause);
		this.error = error;
	}
	
	private ErrorDto error;
	
	
	public ErrorDto getError() {
		return error;
	}



	/**
	 * 
	 * @return status of http response, for example 400 and 500 family of errors
	 */
	public abstract Status getStatus();
}
