package com.assignments.uptube.errors;

import java.io.Serializable;

public class ApiError implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 6049781946308948951L;
	private String timestamp;
	private String path;
	private String error;
	private int message;
	private int status;

	public ApiError() {
		super();
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getMessage() {
		return message;
	}

	public void setMessage(int message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
