package com.cg.fds.exception;

	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.ControllerAdvice;
	import org.springframework.web.bind.annotation.ExceptionHandler;

	import com.cg.fds.entity.BillErrorResponse;

	@ControllerAdvice
	public class BillExceptionHandler {
		@ExceptionHandler
		public ResponseEntity<BillErrorResponse> handleException(BillNotFoundException exception) {
			BillErrorResponse error = new BillErrorResponse();
			
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessage(exception.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
		}

		@ExceptionHandler
		public ResponseEntity<BillErrorResponse> handleException(BillFoundException exception) {
			BillErrorResponse error = new BillErrorResponse();
			
			error.setStatus(HttpStatus.FOUND.value());
			error.setMessage(exception.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(error, HttpStatus.FOUND); // 302 Found  
		}
	}

