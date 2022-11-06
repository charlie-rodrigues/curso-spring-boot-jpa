package com.cursospringboot.cursospringboot.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cursospringboot.cursospringboot.services.exceptions.DataBaseException;
import com.cursospringboot.cursospringboot.services.exceptions.ResourseNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourseNotFoundException e, HttpServletRequest request) {
    String error = "resource not found!";
    HttpStatus status = HttpStatus.NOT_FOUND;
    StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),request.getRequestURI());
	return ResponseEntity.status(status).body(err);
	}
	
	
		@ExceptionHandler(DataBaseException.class)
		public ResponseEntity<StandardError> dataBase(DataBaseException e, HttpServletRequest request) {
	    String error = "Data base error!";
	    HttpStatus status = HttpStatus.BAD_REQUEST;
	    StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		}
	
	
}
