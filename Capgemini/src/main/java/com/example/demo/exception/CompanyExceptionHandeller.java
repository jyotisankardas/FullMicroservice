package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CompanyExceptionHandeller {
	
	@ExceptionHandler(CompanyException.class)
	public ResponseEntity<String> handlecompnynotsaved(CompanyException ex){
		
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CompanyNotfoundException.class)
	public ResponseEntity<String> handleCompanynotfound(CompanyNotfoundException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
