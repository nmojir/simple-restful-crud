package com.mojir.restful_core.enums;

import com.mojir.restful_core.interfaces.IErrorEnum;

//TODO: error enum should be defined or extended by the user of this library.
/**
 * The errors which are returned to user in the error field of ErrorDto
 * @author Navid
 *
 */
public enum ErrorEnum implements IErrorEnum {
	INTERNAL_ERROR(101),
	ENTITY_NOT_FOUND(102);

	ErrorEnum(int code) {
		this.code = code;
	}
	
	private int code;
	
	@Override
	public String getString() {
		return this.name();
	}

	@Override
	public int getCode() {
		return this.code;
	}
}
