package com.cg.fds.exception;

	
	public class OrderDetailsNotFoundException extends RuntimeException {
		
		public OrderDetailsNotFoundException() {
			super();
			
		}

		public OrderDetailsNotFoundException(String message) {
			super(message);
			
		}

		public OrderDetailsNotFoundException(Throwable cause) {
			super(cause);
			
		}

	}


