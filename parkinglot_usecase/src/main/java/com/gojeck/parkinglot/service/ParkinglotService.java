/**
 * 
 */
package com.gojeck.parkinglot.service;

import java.util.Map.Entry;
import java.util.Set;

import com.gojeck.parkinglot.exceptions.ParkingLotNotAvilableException;
import com.gojeck.parkinglot.model.CarModel;

/**
 * The Interface ParkinglotService.
 *
 * @author AMITH DAS
 */
public interface ParkinglotService {

	/**
	 * Creates the parking lot.
	 *
	 * @param numSlots the num slots
	 */
	public void createParkingLot(int numSlots);

	/**
	 * Park car.
	 *
	 * @param car the car
	 * @return the string
	 */
	String parkCar(CarModel car);

	/**
	 * Gets the slot num from reg no.
	 *
	 * @param regNum the reg num
	 * @return the slot num from reg no
	 */
	String getSlotNumFromRegNo(String regNum);
	
	/**
	 * Find car slot number for given color.
	 *
	 * @param color the color
	 * @return the string
	 */
	String findCarSlotNumberForGivenColor(String color);
	
	/**
	 * Gets the car reg numbers based on colur.
	 *
	 * @param color the color
	 * @return the car reg numbers based on colur
	 */
	String getCarRegNumbersBasedOnColur(String color);
	
	/**
	 * Leave car.
	 *
	 * @param slotNumber the slot number
	 * @return the string
	 * @throws ParkingLotNotAvilableException the parking lot not avilable exception
	 */
	String leaveCar(Integer slotNumber) throws ParkingLotNotAvilableException;
	
	/**
	 * Car park status.
	 *
	 * @return the sets the
	 */
	Set<Entry<Integer, CarModel>> carParkStatus();
}
