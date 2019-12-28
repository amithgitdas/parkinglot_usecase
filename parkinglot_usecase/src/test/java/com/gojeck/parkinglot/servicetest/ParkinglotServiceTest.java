package com.gojeck.parkinglot.servicetest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojeck.parkinglot.exceptions.ParkingLotNotAvilableException;
import com.gojeck.parkinglot.model.CarModel;
import com.gojeck.parkinglot.service.ParkinglotService;
import com.gojeck.parkinglot.serviceimplementation.ParkinglotSeriveImplemenation;

public class ParkinglotServiceTest {

	private int parkingLevel;
	private ParkinglotService parkingService = new ParkinglotSeriveImplemenation();
	private CarModel whiteCar= new CarModel("KA-01-HH-9999", "White");

	@Before
	public void init() {
		parkingLevel = 1;
	}

	@After
	public void cleanUp() {
		System.setOut(null);
	}

	@Test
	public void AssignSlotForCar_Service() throws ParkingLotNotAvilableException {
		parkingService.createParkingLot(parkingLevel);
		String ouput = parkingService.parkCar(whiteCar);
		assertEquals("Allocated Slot Number: 1", ouput);

	}

}
