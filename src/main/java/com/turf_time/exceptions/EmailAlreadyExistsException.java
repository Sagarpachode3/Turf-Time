package com.turf_time.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {

	public EmailAlreadyExistsException(String message) {
		super(message);
	}
}
