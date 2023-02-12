package com.crud.exception;

public class UserNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7365408637161384989L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
