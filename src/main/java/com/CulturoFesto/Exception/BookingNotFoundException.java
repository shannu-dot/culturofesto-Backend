package com.CulturoFesto.Exception;

public class BookingNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public BookingNotFoundException() {
		
	}
	public BookingNotFoundException(String message) {
		super(message);
	}

}
