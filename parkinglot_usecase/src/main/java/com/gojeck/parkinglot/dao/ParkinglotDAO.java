/**
 * 
 */
package com.gojeck.parkinglot.dao;

import java.util.List;

import com.gojeck.parkinglot.exceptions.ParkingLotNotAvilableException;
import com.gojeck.parkinglot.model.CarModel;

/**
 * @author AMITH DAS
 *
 */
public interface ParkinglotDAO {
	void createParkinglots(Integer parkinglots);

	Integer parkCar(CarModel car) throws ParkingLotNotAvilableException;

	Integer getSlotNumFromRegNo(String regNum);

	List<Integer> findCarSlotNumberForGivenColor(String color);
	
	List<String> getCarRegNumbersBasedOnColur(String color);
}
