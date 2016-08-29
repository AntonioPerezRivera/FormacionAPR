package com.at.library.exception;

public class UserNotFoundException extends Exception{

	private static final long serialVersionUID = 7051781505032187500L;
	
	private static final String msg = "El usuario no existe";
	
	public UserNotFoundException(){
		super(msg);
	}

}