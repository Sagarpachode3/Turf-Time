package com.turf_time.exceptions;

public class TurfAlreadyExistsException extends RuntimeException {

	public TurfAlreadyExistsException(String message) {
		super("Turf with simillar details is available.");
		
	}

}
