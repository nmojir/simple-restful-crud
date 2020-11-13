package com.mojir.restful_core.dtos;

import com.mojir.restful_core.interfaces.IErrorEnum;

/**
 * The error object returned by the service
 * @author Navid
 *
 */
public class ErrorDto{
	private int code;
	private String message;
	private String error;
	
	
	
	public ErrorDto() {
		super();
	}
	public ErrorDto(String message, IErrorEnum error) {
		super();
		this.code = error.getCode();
		this.message = message;
		this.error = error.getString();
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
	
	
	
	
	
}
