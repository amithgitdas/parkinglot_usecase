package com.gojeck.parkinglot.exceptions;

public class ParkingLotNotAvilableException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParkingLotNotAvilableException() {
		super();
	}

	public ParkingLotNotAvilableException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParkingLotNotAvilableException(String message) {
		super(message);
	}
}
