package com.cg.fds.exception;

public class InvalidCredentialsException extends Exception {

		//private static final long serialVersionUID = 1L;

	public InvalidCredentialsException() {
		super();
		
	}

	public InvalidCredentialsException(String message) {
		super(message);
		
	}

	public InvalidCredentialsException(Throwable cause) {
		super(cause);
			}

}
