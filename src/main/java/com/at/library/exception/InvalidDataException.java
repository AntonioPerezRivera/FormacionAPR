package com.at.library.exception;

public class InvalidDataException extends Exception{

	private static final long serialVersionUID = 7051781505032187500L;
	
	private static final String msg = "Los datos introducidos no son validos";
	
	public InvalidDataException(){
		super(msg);
	}

}
