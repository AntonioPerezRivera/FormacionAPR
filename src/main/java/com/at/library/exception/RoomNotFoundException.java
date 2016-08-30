package com.at.library.exception;

public class RoomNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 389902159943190501L;
	private static final String msg = "La habitacion no existe";
	
	public RoomNotFoundException(){
		super(msg);
	}

}