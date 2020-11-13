package com.mojir.restful_core.exceptions;

import javax.ws.rs.core.Response.Status;

import com.mojir.restful_core.dtos.ErrorDto;
import com.mojir.restful_core.enums.ErrorEnum;

@SuppressWarnings("serial")
public class EntityNotFoundException extends WebServiceException {

	public EntityNotFoundException(String message, Throwable cause) {
		super(new ErrorDto(message, ErrorEnum.ENTITY_NOT_FOUND), cause);
	}

	@Override
	public Status getStatus() {
		return Status.NOT_FOUND;
	}

}
