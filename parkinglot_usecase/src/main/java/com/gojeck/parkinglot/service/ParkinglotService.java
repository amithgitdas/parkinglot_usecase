/**
 * 
 */
package com.gojeck.parkinglot.service;

import com.gojeck.parkinglot.model.CarModel;

/**
 * @author AMITH DAS
 *
 */
public interface ParkinglotService {

	public void createParkingLot(int numSlots);

	String parkCar(CarModel car);

	String getSlotNumFromRegNo(String regNum);
}
