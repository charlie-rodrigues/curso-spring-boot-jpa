package com.cursospringboot.cursospringboot.services.exceptions;

public class ResourseNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	
	public ResourseNotFoundException(Object id) {
		super("resource not found. "+id);
	}

}
