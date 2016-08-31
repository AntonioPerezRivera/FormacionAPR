package com.at.library.exception;

public class UserBannedException extends Exception{

	private static final long serialVersionUID = 389902159943190501L;
	private static final String msg = "El usuario no puede alquilar";
	
	public UserBannedException(){
		super(msg);
	}

}