/**
 * 
 */
package com.gojeck.parkinglot.service;

import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import com.gojeck.parkinglot.exceptions.ParkingLotNotAvilableException;
import com.gojeck.parkinglot.model.CarModel;

/**
 * @author AMITH DAS
 *
 */
public interface ParkinglotService {

	public void createParkingLot(int numSlots);

	String parkCar(CarModel car);

	String getSlotNumFromRegNo(String regNum);
	
	String findCarSlotNumberForGivenColor(String color);
	
	String getCarRegNumbersBasedOnColur(String color);
	
	String leaveCar(Integer slotNumber) throws ParkingLotNotAvilableException;
	
	Set<Entry<Integer, CarModel>> carParkStatus();
}
