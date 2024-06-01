package com.turf_time.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
	
	String resourceName;
	String fieldName;
	String fieldValue;
	
	public UserAlreadyExistsException(String resourceName, String fieldName, String fieldValue) {
		super(String.format("%s with %s : %s already exists !", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}


	  
}
