package com.parkinglot.dao.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import com.parkinglot.dao.ParkinglotDAO;
import com.parkinglot.exceptions.ParkingLotNotAvilableException;
import com.parkinglot.model.CarModel;

/**
 * The Class ParkinglotDAOImplementation.
 */
public class ParkinglotDAOImplementation implements ParkinglotDAO {

	/** The parking lot map. */
	public static Map<Integer, CarModel> parkingLotMap = new HashMap<>();
	
	/** The available lots. */
	public static TreeSet<Integer> availableLots = new TreeSet<>();

	/* 
	 * @see com.gojeck.parkinglot.dao.ParkinglotDAO#createParkinglots(java.lang.Integer)
	 */
	@Override
	public void createParkinglots(Integer parkinglots) {
		for (int i = 0; i < parkinglots; i++) {
			parkingLotMap.put(i + 1, null);
			availableLots.add(i + 1);
		}
	}

	/* 
	 * @see com.gojeck.parkinglot.dao.ParkinglotDAO#parkCar(com.gojeck.parkinglot.model.CarModel)
	 */
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

	/* 
	 * @see com.gojeck.parkinglot.dao.ParkinglotDAO#getSlotNumFromRegNo(java.lang.String)
	 */
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

	/* 
	 * @see com.gojeck.parkinglot.dao.ParkinglotDAO#findCarSlotNumberForGivenColor(java.lang.String)
	 */
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

	/* 
	 * @see com.gojeck.parkinglot.dao.ParkinglotDAO#getCarRegNumbersBasedOnColur(java.lang.String)
	 */
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

	/* 
	 * @see com.gojeck.parkinglot.dao.ParkinglotDAO#leaveCar(java.lang.Integer)
	 */
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

	/* 
	 * @see com.gojeck.parkinglot.dao.ParkinglotDAO#carParkStatus()
	 */
	@Override
	public Set<Entry<Integer, CarModel>> carParkStatus() {
		return parkingLotMap.entrySet();
	}

}
