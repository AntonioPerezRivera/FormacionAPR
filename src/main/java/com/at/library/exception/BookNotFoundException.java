package com.at.library.exception;

public class BookNotFoundException extends Exception{

	private static final long serialVersionUID = -4398196398958177337L;
	private static final String msg = "El libro no existe";
	
	public BookNotFoundException(){
		super(msg);
	}

}