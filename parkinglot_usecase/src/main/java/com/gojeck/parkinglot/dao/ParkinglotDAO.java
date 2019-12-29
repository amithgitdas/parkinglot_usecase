/**
 * 
 */
package com.gojeck.parkinglot.dao;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.gojeck.parkinglot.exceptions.ParkingLotNotAvilableException;
import com.gojeck.parkinglot.model.CarModel;

/**
 * The Interface ParkinglotDAO.
 *
 * @author AMITH DAS
 */
public interface ParkinglotDAO {
	
	/**
	 *To create parking lot with specified lots
	 *
	 * @param parkinglots the parkinglots
	 */
	void createParkinglots(Integer parkinglots);

	/**
	 * Park car in the avilable slot
	 *
	 * @param car the car
	 * @return the integer
	 * @throws ParkingLotNotAvilableException the parking lot not avilable exception
	 */
	Integer parkCar(CarModel car) throws ParkingLotNotAvilableException;

	/**
	 * Gets the slot num from registration no.
	 *
	 * @param regNum the reg num
	 * @return the slot num from reg no
	 */
	Integer getSlotNumFromRegNo(String regNum);

	/**
	 * Find car slot number for given color.
	 *
	 * @param color the color
	 * @return the list
	 */
	List<Integer> findCarSlotNumberForGivenColor(String color);
	
	/**
	 * Gets the car registration numbers based on colour.
	 *
	 * @param color the color
	 * @return the car reg numbers based on colur
	 */
	List<String> getCarRegNumbersBasedOnColur(String color);
	
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
