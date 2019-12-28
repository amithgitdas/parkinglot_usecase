package com.gojeck.parkinglot.servicetest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

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
	private String carRegNum="KA-01-HH-9999";
	private String white="White";
	

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
	
	@Test
	public void getAssignedSlotOfCar() throws ParkingLotNotAvilableException {
		parkingService.createParkingLot(parkingLevel);
		CarModel car = new CarModel(carRegNum, white);
		parkingService.parkCar(car);
		String ouput = parkingService.getSlotNumFromRegNo(carRegNum);
		assertEquals(Integer.toString(1), ouput);

	}
	
	@Test
	public void getSlotNumbersBasedColorSerivce() throws ParkingLotNotAvilableException {
		parkingService.createParkingLot(parkingLevel);
		CarModel car = new CarModel(carRegNum, white);
		parkingService.parkCar(car);
		String ouput = parkingService.findCarSlotNumberForGivenColor(white);
		assertEquals("1", ouput);

	}
	
	@Test
	public void getRegNumbersBasedColorSerivce() throws ParkingLotNotAvilableException {
		parkingService.createParkingLot(parkingLevel);
		CarModel car = new CarModel(carRegNum, white);
		parkingService.parkCar(car);
		String ouput = parkingService.getCarRegNumbersBasedOnColur(white);
		assertEquals(carRegNum, ouput);

	}
	
	@Test
	public void leaveCar() throws ParkingLotNotAvilableException {
		parkingService.createParkingLot(parkingLevel+1);
		CarModel car = new CarModel(carRegNum, white);
		parkingService.parkCar(car);
		parkingService.parkCar(car);
		String ouput = parkingService.leaveCar(2);
		assertEquals("Slot 2 is free", ouput);

	}

}
