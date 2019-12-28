/**
 * 
 */
package com.gojeck.parkinglot.daotest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojeck.parkinglot.dao.ParkinglotDAO;
import com.gojeck.parkinglot.dao.implementation.ParkinglotDAOImplementation;
import com.gojeck.parkinglot.exceptions.ParkingLotNotAvilableException;
import com.gojeck.parkinglot.model.CarModel;

/**
 * @author AMITH DAS
 *
 */
public class ParkinglotDaoTest {
	private int parkingLevel;
	private ParkinglotDAO parkingDAO = new ParkinglotDAOImplementation();
	private String carRegNum = "KA-01-HH-9999";
	private String white = "White";
	private String black = "Black";

	@Before
	public void init() {
		parkingLevel = 6;
	}

	@After
	public void cleanUp() {
		System.setOut(null);
	}

	@Test
	public void createCarParkingLot() {
		parkingDAO.createParkinglots(parkingLevel);
	}

	@Test
	public void AssignSlotForCar() throws ParkingLotNotAvilableException {
		parkingDAO.createParkinglots(parkingLevel);
		CarModel car = new CarModel(carRegNum, white);
		int ouput = parkingDAO.parkCar(car);
		assertEquals(1, ouput);

	}

	@Test
	public void getAssignedSlotOfCar() throws ParkingLotNotAvilableException {
		parkingDAO.createParkinglots(parkingLevel);
		CarModel car = new CarModel(carRegNum, white);
		parkingDAO.parkCar(car);
		int ouput = parkingDAO.getSlotNumFromRegNo(carRegNum);
		assertEquals(1, ouput);

	}

}
