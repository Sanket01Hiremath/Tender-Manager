package com.example.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> anyExcHandler( Exception e, WebRequest wr ){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMsg(e.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	//3rd No Handler found Exception Handler
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> myNoHandlerFoundExcHandler( NoHandlerFoundException ne ,WebRequest wr ){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMsg(ne.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	//4rth Method Arguments Invalid Exception Handler
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> methodArgInvalidExcHandler( MethodArgumentNotValidException me ){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMsg(me.getMessage());
		err.setDetails(me.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
}
