package com.gojeck.parkinglot.serviceimplementation;

import com.gojeck.parkinglot.dao.ParkinglotDAO;
import com.gojeck.parkinglot.dao.implementation.ParkinglotDAOImplementation;
import com.gojeck.parkinglot.exceptions.ParkingLotNotAvilableException;
import com.gojeck.parkinglot.model.CarModel;
import com.gojeck.parkinglot.service.ParkinglotService;

public class ParkinglotSeriveImplemenation implements ParkinglotService {
	private ParkinglotDAO parkingLotDAO = new ParkinglotDAOImplementation();

	@Override
	public void createParkingLot(int numSlots) {
		parkingLotDAO.createParkinglots(numSlots);
	}

	@Override
	public String parkCar(CarModel car) {
		Integer slotNo;
		try {
			slotNo = parkingLotDAO.parkCar(car);
			return "Allocated Slot Number: " + slotNo;
		} catch (ParkingLotNotAvilableException e) {
			return "Sorry, car parking lot is full";
		}
	}

}
