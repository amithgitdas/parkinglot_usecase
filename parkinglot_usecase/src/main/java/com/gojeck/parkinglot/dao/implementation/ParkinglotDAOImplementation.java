package com.gojeck.parkinglot.dao.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import com.gojeck.parkinglot.dao.ParkinglotDAO;
import com.gojeck.parkinglot.exceptions.ParkingLotNotAvilableException;
import com.gojeck.parkinglot.model.CarModel;

public class ParkinglotDAOImplementation implements ParkinglotDAO {

	public static Map<Integer, CarModel> parkingLotMap = new HashMap<>();
	public static TreeSet<Integer> availableLots = new TreeSet<>();

	@Override
	public void createParkinglots(Integer parkinglots) {
		for (int i = 0; i < parkinglots; i++) {
			parkingLotMap.put(i + 1, null);
			availableLots.add(i + 1);
		}
	}

	@Override
	public Integer parkCar(CarModel car) throws ParkingLotNotAvilableException {
		if (availableLots.isEmpty()) {
			throw new ParkingLotNotAvilableException("Sorry, car parking lot is full");
		} else {
			final int freeSlot = availableLots.pollFirst();
			parkingLotMap.put(freeSlot, car);
			return freeSlot;
		}
	}

	@Override
	public Integer getSlotNumFromRegNo(String regNum) {
		int slotNum = 0;
		for (Map.Entry<Integer, CarModel> parkingEntry : parkingLotMap.entrySet()) {
			if (parkingEntry.getValue() != null
					&& parkingEntry.getValue().getRegistrationNo().equalsIgnoreCase(regNum)) {
				slotNum = parkingEntry.getKey();
				break;
			}
		}
		return slotNum;
	}

	@Override
	public List<Integer> findCarSlotNumberForGivenColor(String color) {
		List<Integer> carSlot = new ArrayList<>();
		for (Map.Entry<Integer, CarModel> parkingEntry : parkingLotMap.entrySet()) {
			if (parkingEntry.getValue() != null && parkingEntry.getValue().getColor().equalsIgnoreCase(color)) {
				carSlot.add(parkingEntry.getKey());
			}
		}
		return carSlot;
	}

	@Override
	public List<String> getCarRegNumbersBasedOnColur(String color) {
		List<String> carRegNo = new ArrayList<>();
		for (Map.Entry<Integer, CarModel> parkingEntry : parkingLotMap.entrySet()) {
			if (parkingEntry.getValue() != null && parkingEntry.getValue().getColor().equalsIgnoreCase(color)) {
				carRegNo.add(parkingEntry.getValue().getRegistrationNo());
			}
		}
		return carRegNo;
	}

	@Override
	public String leaveCar(Integer slotNUm) throws ParkingLotNotAvilableException {
		for (Map.Entry<Integer, CarModel> entry : parkingLotMap.entrySet()) {
			if (entry.getKey() == slotNUm) {
				parkingLotMap.put(entry.getKey(), null);
				availableLots.add(slotNUm);
				return "Slot number " + slotNUm + " is free";
			}
		}
		throw new ParkingLotNotAvilableException(slotNUm + " Slot not found!");
	}

	@Override
	public Set<Entry<Integer, CarModel>> carParkStatus() {
		return parkingLotMap.entrySet();
	}

}
