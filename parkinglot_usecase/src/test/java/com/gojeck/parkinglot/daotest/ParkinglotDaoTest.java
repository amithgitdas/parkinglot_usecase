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

// TODO: Auto-generated Javadoc
/**
 * The Class ParkinglotDaoTest.
 *
 * @author AMITH DAS
 */
public class ParkinglotDaoTest {
	
	/** The parking level. */
	private int parkingLevel;
	
	/** The parking DAO. */
	private ParkinglotDAO parkingDAO = new ParkinglotDAOImplementation();
	
	/** The car reg num. */
	private String carRegNum = "KA-01-HH-9999";
	
	/** The white. */
	private String white = "White";
	
	/** The black. */
	private String black = "Black";

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		parkingLevel = 6;
	}

	/**
	 * Clean up.
	 */
	@After
	public void cleanUp() {
		System.setOut(null);
	}

	/**
	 * Creates the car parking lot.
	 */
	@Test
	public void createCarParkingLot() {
		parkingDAO.createParkinglots(parkingLevel);
	}

	/**
	 * Assign slot for car.
	 *
	 * @throws ParkingLotNotAvilableException the parking lot not avilable exception
	 */
	@Test
	public void AssignSlotForCar() throws ParkingLotNotAvilableException {
		parkingDAO.createParkinglots(parkingLevel);
		CarModel car = new CarModel(carRegNum, white);
		int ouput = parkingDAO.parkCar(car);
		assertEquals(1, ouput);

	}

	/**
	 * Gets the assigned slot of car.
	 *
	 * @return the assigned slot of car
	 * @throws ParkingLotNotAvilableException the parking lot not avilable exception
	 */
	@Test
	public void getAssignedSlotOfCar() throws ParkingLotNotAvilableException {
		parkingDAO.createParkinglots(parkingLevel);
		CarModel car = new CarModel(carRegNum, white);
		parkingDAO.parkCar(car);
		int ouput = parkingDAO.getSlotNumFromRegNo(carRegNum);
		assertEquals(1, ouput);

	}

	/**
	 * Gets the slot numbers based color.
	 *
	 * @return the slot numbers based color
	 * @throws ParkingLotNotAvilableException the parking lot not avilable exception
	 */
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
	
	/**
	 * Gets the reg numbers based color.
	 *
	 * @return the reg numbers based color
	 * @throws ParkingLotNotAvilableException the parking lot not avilable exception
	 */
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
	
	/**
	 * Leave car.
	 *
	 * @throws ParkingLotNotAvilableException the parking lot not avilable exception
	 */
	@Test
	public void leaveCar() throws ParkingLotNotAvilableException {
		parkingDAO.createParkinglots(parkingLevel+1);
		CarModel car = new CarModel(carRegNum, white);
		parkingDAO.parkCar(car);
		parkingDAO.parkCar(car);
		String ouput = parkingDAO.leaveCar(2);
		assert((ouput.length() >=0));

	}
	
	/**
	 * Car parking status.
	 *
	 * @throws ParkingLotNotAvilableException the parking lot not avilable exception
	 */
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
