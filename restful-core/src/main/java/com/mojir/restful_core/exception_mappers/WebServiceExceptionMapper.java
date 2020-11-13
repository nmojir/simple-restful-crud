package com.mojir.restful_core.exception_mappers;




import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojir.restful_core.exceptions.WebServiceException;

/**
 * Exception mapper which converts exceptions to a json response
 * @author Navid
 *
 */
@Provider
public class WebServiceExceptionMapper implements ExceptionMapper<WebServiceException> {

	private static final Logger log = LogManager.getLogger(WebServiceExceptionMapper.class);
	
	@Override
	public Response toResponse(WebServiceException exception) {
		log.error("A web service exception occured: trace: ", exception);
		return Response.status(exception.getStatus())
				.entity(exception.getError()).type(MediaType.APPLICATION_JSON).build();
	}
}