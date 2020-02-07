package com.hcl.sandwich.exception;

public class DataNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public DataNotFoundException(String message)
	{
	  super(message);	
	}
}
