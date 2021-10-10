package com.cg.fds.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.fds.entity.OrderErrorResponse;

@ControllerAdvice
public class OrderExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<OrderErrorResponse> handleException(OrderDetailsNotFoundException exception) {
    OrderErrorResponse error = new OrderErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}

	@ExceptionHandler
	public ResponseEntity<OrderErrorResponse> handleException(OrderDetailsFoundException exception) {
		OrderErrorResponse error = new OrderErrorResponse();
		
		error.setStatus(HttpStatus.FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.FOUND); // 302 Found  
	}
}