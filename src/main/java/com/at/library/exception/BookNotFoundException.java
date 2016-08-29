package com.at.library.exception;

public class BookNotFoundException extends Exception{

	private static final long serialVersionUID = 7051781505032187500L;
	
	private static final String msg = "El libro no existe";
	
	public BookNotFoundException(){
		super(msg);
	}

}