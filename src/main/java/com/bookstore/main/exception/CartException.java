package com.bookstore.main.exception;

import lombok.Data;

@Data
public class CartException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	private int statusCode;
	private String statusMessage;
	
	public CartException() {
		
	}
	
	public CartException(int statusCode, String statusMessage) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}
}
