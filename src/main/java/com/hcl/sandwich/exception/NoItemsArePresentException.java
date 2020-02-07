package com.hcl.sandwich.exception;

public class NoItemsArePresentException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private final String message;
	
	public NoItemsArePresentException(String message) {
		super(message);
		this.message=message;
	}
}
