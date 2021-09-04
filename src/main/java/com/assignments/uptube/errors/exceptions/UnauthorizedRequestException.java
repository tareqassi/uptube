package com.assignments.uptube.errors.exceptions;

public class UnauthorizedRequestException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5981140696893396934L;

	public UnauthorizedRequestException(String message) {
		super(message);
	}

}
