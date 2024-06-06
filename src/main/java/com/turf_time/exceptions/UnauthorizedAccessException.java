package com.turf_time.exceptions;

public class UnauthorizedAccessException extends RuntimeException {

	public UnauthorizedAccessException(String message) {
        super(message);
    }
}
