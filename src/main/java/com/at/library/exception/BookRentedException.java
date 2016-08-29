package com.at.library.exception;

public class BookRentedException extends Exception{

	private static final long serialVersionUID = 7950094138801923657L;
	private static final String msg = "El libro no existe";
	
	public BookRentedException(){
		super(msg);
	}

}