package com.gojeck.parkinglot.serviceimplementation;

import com.gojeck.parkinglot.dao.ParkinglotDAO;
import com.gojeck.parkinglot.dao.implementation.ParkinglotDAOImplementation;
import com.gojeck.parkinglot.service.ParkinglotService;

public class ParkinglotSeriveImplemenation implements ParkinglotService {
	private ParkinglotDAO parkingLotDAO = new ParkinglotDAOImplementation();

	@Override
	public void createParkingLot(int numSlots) {
		parkingLotDAO.createParkinglots(numSlots);
	}

}
