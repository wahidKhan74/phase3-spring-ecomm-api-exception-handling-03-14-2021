package com.simplilearn.webservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {
	
	@ExceptionHandler(value=ProductNotFoundException.class)
	public ResponseEntity<Object> exception(ProductNotFoundException exception){
		return new ResponseEntity<Object>("Product Not Found !",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=InvalidProductException.class)
	public ResponseEntity<Object> exception2(InvalidProductException exception){
		return new ResponseEntity<Object>("Invalid Product, Compulsory Parameters are missing !",HttpStatus.BAD_REQUEST);
	}
}
