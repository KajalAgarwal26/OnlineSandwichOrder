package com.hcl.sandwich.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoItemsArePresentException.class)
    public ResponseEntity<ErrorResponse> noItemsArePresentException(NoItemsArePresentException ex) {
        
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setMessgage(ex.getMessage());
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorResponse.setDateAndTime(LocalDateTime.now());
		
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
	
}