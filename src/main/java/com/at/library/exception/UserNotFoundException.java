package com.at.library.exception;

public class UserNotFoundException extends Exception{

	private static final long serialVersionUID = 1895174310604982845L;
	private static final String msg = "El usuario no existe";
	
	public UserNotFoundException(){
		super(msg);
	}

}