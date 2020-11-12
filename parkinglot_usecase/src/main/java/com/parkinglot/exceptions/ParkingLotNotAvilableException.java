package com.parkinglot.exceptions;

/**
 * The Class ParkingLotNotAvilableException.
 */
public class ParkingLotNotAvilableException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new parking lot not avilable exception.
	 */
	public ParkingLotNotAvilableException() {
		super();
	}

	/**
	 * Instantiates a new parking lot not avilable exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public ParkingLotNotAvilableException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new parking lot not avilable exception.
	 *
	 * @param message the message
	 */
	public ParkingLotNotAvilableException(String message) {
		super(message);
	}
}
