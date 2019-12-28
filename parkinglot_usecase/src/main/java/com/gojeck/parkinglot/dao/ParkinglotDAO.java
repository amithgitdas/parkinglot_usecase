/**
 * 
 */
package com.gojeck.parkinglot.dao;

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
}
