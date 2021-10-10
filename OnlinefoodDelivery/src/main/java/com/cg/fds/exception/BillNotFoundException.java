package com.cg.fds.exception;

public class BillNotFoundException extends RuntimeException {
	
	public BillNotFoundException() {
		super();
	}	


	public BillNotFoundException(String message) {
		super(message);
	}

	public BillNotFoundException(Throwable cause) {
		super(cause);
		
	}

	 	
}