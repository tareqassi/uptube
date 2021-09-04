package com.assignments.uptube.errors.exceptions;

public class ResourceDoesNotExistException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5464644651929026468L;

	public ResourceDoesNotExistException(String message) {
		super(message);
	}
}
