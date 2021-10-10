package com.cg.fds.exception;

	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.ControllerAdvice;
	import org.springframework.web.bind.annotation.ExceptionHandler;

	import com.cg.fds.entity.LoginErrorResponse;

	@ControllerAdvice
	public class LoginExceptionHandler {
		@ExceptionHandler
		public ResponseEntity<LoginErrorResponse> handleException(LoginNotFoundException exception) {
			LoginErrorResponse error = new LoginErrorResponse();
			
			error.setStatus(HttpStatus.UNAUTHORIZED.value());
			error.setMessage(exception.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);  //404 Not found
		}

		@ExceptionHandler
		public ResponseEntity<LoginErrorResponse> handleException(LoginFoundException exception) {
			LoginErrorResponse error = new LoginErrorResponse();
			
			error.setStatus(HttpStatus.FOUND.value());
			error.setMessage(exception.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(error, HttpStatus.FOUND); // 302 Found  
		}
	}


