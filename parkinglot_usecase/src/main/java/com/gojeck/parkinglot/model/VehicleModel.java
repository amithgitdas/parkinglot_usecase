/**
 * 
 */
package com.gojeck.parkinglot.model;

/**
 * @author AMITH DAS
 *
 */
public class VehicleModel {
	private String registrationNo = null;
	private String color = null;

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public VehicleModel(String registrationNo, String color) {
		this.registrationNo = registrationNo;
		this.color = color;
	}
}
