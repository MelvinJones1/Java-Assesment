package com.java.main.exception;


public class InvalidIdException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public static final long serialVersionUId = 1180219638563029139L;
	
	private String message ;
	
	public InvalidIdException(String msg) {
		message  = msg;
		
	}
	public String getMessage() {
 		return message;
 	} 

}
