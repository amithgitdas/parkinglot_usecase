package com.gojeck.parkinglot.serviceimplementation;

import java.util.List;

import com.gojeck.parkinglot.dao.ParkinglotDAO;
import com.gojeck.parkinglot.dao.implementation.ParkinglotDAOImplementation;
import com.gojeck.parkinglot.exceptions.ParkingLotNotAvilableException;
import com.gojeck.parkinglot.model.CarModel;
import com.gojeck.parkinglot.service.ParkinglotService;
import com.gojeck.parkinglot.utils.ParkinglotUtils;

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

	@Override
	public String getSlotNumFromRegNo(String regNum) {
		int slotNum = parkingLotDAO.getSlotNumFromRegNo(regNum);
		return (slotNum == 0) ? "Not Found!" : Integer.toString(slotNum);
	}

	@Override
	public String findCarSlotNumberForGivenColor(String color) {
		List<Integer> carSlot = parkingLotDAO.findCarSlotNumberForGivenColor(color);
		return ParkinglotUtils.convertListToString(carSlot);
	}

}
