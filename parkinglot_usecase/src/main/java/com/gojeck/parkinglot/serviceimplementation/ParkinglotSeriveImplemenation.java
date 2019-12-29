package com.gojeck.parkinglot.serviceimplementation;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.gojeck.parkinglot.dao.ParkinglotDAO;
import com.gojeck.parkinglot.dao.implementation.ParkinglotDAOImplementation;
import com.gojeck.parkinglot.exceptions.ParkingLotNotAvilableException;
import com.gojeck.parkinglot.model.CarModel;
import com.gojeck.parkinglot.service.ParkinglotService;
import com.gojeck.parkinglot.utils.ParkinglotUtils;

/**
 * The Class ParkinglotSeriveImplemenation.
 */
public class ParkinglotSeriveImplemenation implements ParkinglotService {
	
	/** The parking lot DAO. */
	private ParkinglotDAO parkingLotDAO = new ParkinglotDAOImplementation();

	/* 
	 * @see com.gojeck.parkinglot.service.ParkinglotService#createParkingLot(int)
	 */
	@Override
	public void createParkingLot(int numSlots) {
		parkingLotDAO.createParkinglots(numSlots);
	}

	/* 
	 * @see com.gojeck.parkinglot.service.ParkinglotService#parkCar(com.gojeck.parkinglot.model.CarModel)
	 */
	@Override
	public String parkCar(CarModel car) {
		Integer slotNo;
		try {
			slotNo = parkingLotDAO.parkCar(car);
			return "Allocated Slot Number: " + slotNo;
		} catch (ParkingLotNotAvilableException e) {
			return "Sorry, parking lot is full";
		}
	}

	/* 
	 * @see com.gojeck.parkinglot.service.ParkinglotService#getSlotNumFromRegNo(java.lang.String)
	 */
	@Override
	public String getSlotNumFromRegNo(String regNum) {
		int slotNum = parkingLotDAO.getSlotNumFromRegNo(regNum);
		return (slotNum == 0) ? "Not Found" : Integer.toString(slotNum);
	}

	/* 
	 * @see com.gojeck.parkinglot.service.ParkinglotService#findCarSlotNumberForGivenColor(java.lang.String)
	 */
	@Override
	public String findCarSlotNumberForGivenColor(String color) {
		List<Integer> carSlot = parkingLotDAO.findCarSlotNumberForGivenColor(color);
		return ParkinglotUtils.convertListToString(carSlot);
	}

	/* 
	 * @see com.gojeck.parkinglot.service.ParkinglotService#getCarRegNumbersBasedOnColur(java.lang.String)
	 */
	@Override
	public String getCarRegNumbersBasedOnColur(String color) {
		List<String> carRegNumber = parkingLotDAO.getCarRegNumbersBasedOnColur(color);
		return ParkinglotUtils.convertListToString(carRegNumber);
	}

	/* 
	 * @see com.gojeck.parkinglot.service.ParkinglotService#leaveCar(java.lang.Integer)
	 */
	@Override
	public String leaveCar(Integer slotNum) throws ParkingLotNotAvilableException {
		return parkingLotDAO.leaveCar(slotNum);
	}

	/* 
	 * @see com.gojeck.parkinglot.service.ParkinglotService#carParkStatus()
	 */
	@Override
	public Set<Entry<Integer, CarModel>> carParkStatus() {
		return parkingLotDAO.carParkStatus();
	}

}
