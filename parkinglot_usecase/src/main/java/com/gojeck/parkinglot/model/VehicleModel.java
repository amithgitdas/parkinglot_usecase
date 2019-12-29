/**
 * 
 */
package com.gojeck.parkinglot.model;

/**
 * The Class VehicleModel.
 *
 * @author AMITH DAS
 */
public class VehicleModel {
	
	/** The registration no. */
	private String registrationNo = null;
	
	/** The color. */
	private String color = null;

	/**
	 * Gets the registration no.
	 *
	 * @return the registration no
	 */
	public String getRegistrationNo() {
		return registrationNo;
	}

	/**
	 * Sets the registration no.
	 *
	 * @param registrationNo the new registration no
	 */
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Sets the color.
	 *
	 * @param color the new color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Instantiates a new vehicle model.
	 *
	 * @param registrationNo the registration no
	 * @param color the color
	 */
	public VehicleModel(String registrationNo, String color) {
		this.registrationNo = registrationNo;
		this.color = color;
	}
}
