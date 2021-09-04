package com.assignments.uptube.errors;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.assignments.uptube.errors.exceptions.BadRequestException;
import com.assignments.uptube.errors.exceptions.ResourceDoesNotExistException;
import com.assignments.uptube.errors.exceptions.ServerException;
import com.assignments.uptube.errors.exceptions.UnauthorizedRequestException;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	public static DateTimeFormatter ISO_DATE_TIME_FPRMATTER=DateTimeFormatter.ISO_LOCAL_DATE_TIME;

	@Autowired
	private HttpServletRequest request;

	@ExceptionHandler(UnauthorizedRequestException.class)
	protected ResponseEntity<ApiError> handle(UnauthorizedRequestException e) {
		ApiError error = getApiError(e.getMessage(), HttpStatus.UNAUTHORIZED);
		return new ResponseEntity<ApiError>(error, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(ServerException.class)
	protected ResponseEntity<ApiError> handle(ServerException e) {
		ApiError error = getApiError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<ApiError>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(BadRequestException.class)
	protected ResponseEntity<ApiError> handle(BadRequestException e) {
		ApiError error = getApiError(e.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<ApiError>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceDoesNotExistException.class)
	protected ResponseEntity<ApiError> handle(ResourceDoesNotExistException e) {
		ApiError error = getApiError(e.getMessage(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiError>(error, HttpStatus.NOT_FOUND);
	}

	
//	{
//	  "timestamp": "2021-05-23T22:22:04.180+00:00",
//	  "status": "HTTP_STATS",
//	  "error": "Bad Request",
//	  "message": "ERROR_CODE",
//	  "path": "/path"
//	}
	private ApiError getApiError(String message, HttpStatus status) {
		ApiError error = new ApiError();
		error.setTimestamp(LocalDateTime.now().format(ISO_DATE_TIME_FPRMATTER));
		error.setMessage(status.value());
		error.setStatus(status.value());
		error.setError(status.name());
		error.setPath(request.getRequestURI());
		return error;
	}

}
