package com.onlinepharmacy.exception;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionDetails> handleResourceNotFoundException(ResourceNotFoundException e, WebRequest request) {
		
		ExceptionDetails  ed = new ExceptionDetails();
		
		ed.setMessage(e.getMessage());
		ed.setUrl(request.getDescription(false));
		
		return new ResponseEntity<ExceptionDetails>(ed, HttpStatus.NOT_FOUND);	
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(NullObjectException.class)
	public ResponseEntity<ExceptionDetails> handleNullObjectException(NullObjectException e, WebRequest request) {
		
		ExceptionDetails  ed = new ExceptionDetails();
		ed.setMessage(e.getMessage());
		ed.setUrl(request.getDescription(false));
		return new ResponseEntity<ExceptionDetails>(ed, HttpStatus.BAD_REQUEST);	
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionDetails> handleOtherExceptions(Exception e, WebRequest request) {
		
		ExceptionDetails  ed = new ExceptionDetails();
		ed.setMessage(e.getMessage());
		ed.setUrl(request.getDescription(false));
		return new ResponseEntity<ExceptionDetails>(ed, HttpStatus.NOT_FOUND);	
	}
	
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println("Inside handleMethodArgumentNotValid");
		Map<String, String> errors = new HashMap<>();
		BindingResult result = ex.getBindingResult();
		result.getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError)error).getField();
			String errorMsg = error.getDefaultMessage();
			errors.put(fieldName, errorMsg);
		});
		return new ResponseEntity<Object>(errors,status.BAD_REQUEST);
	}
	
	
	
	

}
