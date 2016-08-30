package com.at.library.exception;

public class ZoneNotFoundException extends Exception{

	private static final long serialVersionUID = 6128440320310076034L;
	private static final String msg = "La zona no existe";
	
	public ZoneNotFoundException(){
		super(msg);
	}

}