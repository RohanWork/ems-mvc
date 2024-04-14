package com.mvcdb.exception;

public class CustomMessage extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CustomMessage(String message) {
		super(message);
	}

}
