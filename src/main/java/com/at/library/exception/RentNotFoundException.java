package com.at.library.exception;

public class RentNotFoundException extends Exception{

	private static final long serialVersionUID = 1120312658402366808L;
	private static final String msg = "Los datos introducidos no son validos";
	
	public RentNotFoundException(){
		super(msg);
	}

}