package com.gojeck.parkinglot.servicetest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.parkinglot.exceptions.ParkingLotNotAvilableException;
import com.parkinglot.model.CarModel;
import com.parkinglot.service.ParkinglotService;
import com.parkinglot.serviceimplementation.ParkinglotSeriveImplemenation;

// TODO: Auto-generated Javadoc
/**
 * The Class ParkinglotServiceTest.
 */
public class ParkinglotServiceTest {

	/** The parking level. */
	private int parkingLevel;
	
	/** The parking service. */
	private ParkinglotService parkingService = new ParkinglotSeriveImplemenation();
	
	/** The white car. */
	private CarModel whiteCar= new CarModel("KA-01-HH-9999", "White");
	
	/** The car reg num. */
	private String carRegNum="KA-01-HH-9999";
	
	/** The white. */
	private String white="White";
	

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		parkingLevel = 1;
	}

	/**
	 * Clean up.
	 */
	@After
	public void cleanUp() {
		System.setOut(null);
	}

	/**
	 * Assign slot for car service.
	 *
	 * @throws ParkingLotNotAvilableException the parking lot not avilable exception
	 */
	@Test
	public void AssignSlotForCar_Service() throws ParkingLotNotAvilableException {
		parkingService.createParkingLot(parkingLevel);
		String ouput = parkingService.parkCar(whiteCar);
		assertEquals("Allocated Slot Number: 1", ouput);

	}
	
	/**
	 * Gets the assigned slot of car.
	 *
	 * @return the assigned slot of car
	 * @throws ParkingLotNotAvilableException the parking lot not avilable exception
	 */
	@Test
	public void getAssignedSlotOfCar() throws ParkingLotNotAvilableException {
		parkingService.createParkingLot(parkingLevel);
		CarModel car = new CarModel(carRegNum, white);
		parkingService.parkCar(car);
		String ouput = parkingService.getSlotNumFromRegNo(carRegNum);
		assertEquals(Integer.toString(1), ouput);

	}
	
	/**
	 * Gets the slot numbers based color serivce.
	 *
	 * @return the slot numbers based color serivce
	 * @throws ParkingLotNotAvilableException the parking lot not avilable exception
	 */
	@Test
	public void getSlotNumbersBasedColorSerivce() throws ParkingLotNotAvilableException {
		parkingService.createParkingLot(parkingLevel);
		CarModel car = new CarModel(carRegNum, white);
		parkingService.parkCar(car);
		String ouput = parkingService.findCarSlotNumberForGivenColor(white);
		assert(!ouput.isEmpty());

	}
	
	/**
	 * Gets the reg numbers based color serivce.
	 *
	 * @return the reg numbers based color serivce
	 * @throws ParkingLotNotAvilableException the parking lot not avilable exception
	 */
	@Test
	public void getRegNumbersBasedColorSerivce() throws ParkingLotNotAvilableException {
		parkingService.createParkingLot(parkingLevel);
		CarModel car = new CarModel(carRegNum, white);
		parkingService.parkCar(car);
		String ouput = parkingService.getCarRegNumbersBasedOnColur(white);
		assertEquals(carRegNum, ouput);

	}
	
	/**
	 * Leave car.
	 *
	 * @throws ParkingLotNotAvilableException the parking lot not avilable exception
	 */
	@Test
	public void leaveCar() throws ParkingLotNotAvilableException {
		parkingService.createParkingLot(parkingLevel+1);
		CarModel car = new CarModel(carRegNum, white);
		parkingService.parkCar(car);
		parkingService.parkCar(car);
		String ouput = parkingService.leaveCar(2);
		assert((ouput.length() >=0));

	}
	
	/**
	 * Car parking status.
	 *
	 * @throws ParkingLotNotAvilableException the parking lot not avilable exception
	 */
	@Test
	public void carParkingStatus() throws ParkingLotNotAvilableException {
		parkingService.createParkingLot(parkingLevel+1);
		CarModel car = new CarModel(carRegNum, white);
		parkingService.parkCar(car);
		parkingService.parkCar(car);
		Set<Entry<Integer, CarModel>> ouput = parkingService.carParkStatus();
		assert(!ouput.isEmpty());

	}

}
