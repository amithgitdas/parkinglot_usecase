/**
 * 
 */
package com.gojeck.parkinglot.daotest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

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

	@Test
	public void getSlotNumbersBasedColor() throws ParkingLotNotAvilableException {
		parkingDAO.createParkinglots(parkingLevel);
		CarModel car = new CarModel(carRegNum, white);
		parkingDAO.parkCar(car);
		List<Integer> ouput = parkingDAO.findCarSlotNumberForGivenColor(white);
		List<Integer> expected = new ArrayList<>();
		expected.add(1);
		assertEquals(expected, ouput);

	}
	
	@Test
	public void getRegNumbersBasedColor() throws ParkingLotNotAvilableException {
		parkingDAO.createParkinglots(parkingLevel);
		CarModel car = new CarModel(carRegNum, white);
		parkingDAO.parkCar(car);
		List<String> ouput = parkingDAO.getCarRegNumbersBasedOnColur(white);
		List<String> expected = new ArrayList<>();
		expected.add(carRegNum);
		assertEquals(expected, ouput);

	}
	
	@Test
	public void leaveCar() throws ParkingLotNotAvilableException {
		parkingDAO.createParkinglots(parkingLevel+1);
		CarModel car = new CarModel(carRegNum, white);
		parkingDAO.parkCar(car);
		parkingDAO.parkCar(car);
		String ouput = parkingDAO.leaveCar(2);
		assert((ouput.length() >=0));

	}
	
	@Test
	public void carParkingStatus() throws ParkingLotNotAvilableException {
		parkingDAO.createParkinglots(parkingLevel+1);
		CarModel car = new CarModel(carRegNum, white);
		parkingDAO.parkCar(car);
		parkingDAO.parkCar(car);
		Set<Entry<Integer, CarModel>> ouput = parkingDAO.carParkStatus();
		assertEquals(7, ouput.size());

	}

}
