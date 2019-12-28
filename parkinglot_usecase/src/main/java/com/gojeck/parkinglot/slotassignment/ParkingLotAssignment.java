/**
 * 
 */
package com.gojeck.parkinglot.slotassignment;

import java.util.Scanner;

import com.gojeck.parkinglot.constants.ParkingLotConstants;
import com.gojeck.parkinglot.model.CarModel;
import com.gojeck.parkinglot.service.ParkinglotService;
import com.gojeck.parkinglot.serviceimplementation.ParkinglotSeriveImplemenation;
import com.gojeck.parkinglot.utils.ParkinglotUtils;

/**
 * @author AMITH DAS
 *
 */
public class ParkingLotAssignment {

	/**
	 * @param args
	 */
	static ParkinglotService parkingService = new ParkinglotSeriveImplemenation();
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int noOfParkingSlots = 0;
		while (true) {
			try {
				System.out.println("create_parking_lot : ");
				noOfParkingSlots = scn.nextInt();
				break;
			} catch (Exception e) {
				scn.next();
				System.out.println("Please input correct number.");
			}
		}
		parkingService.createParkingLot(noOfParkingSlots);
		System.out.println("Created a parking lot with " + noOfParkingSlots + " slots");
		scn.nextLine();
		do {
			parkingSlotAssignment(scn.nextLine());
		} while (true);
	}

	private static void parkingSlotAssignment(String input) {
		String[] carArr = input.split(" ");
		switch (carArr[0]) {
		case ParkingLotConstants.PARK_CAR:
			parkCar(carArr);
			break;
		case ParkingLotConstants.SLOT_NUMBER_FOR_CARREG_NUMBER:
			if (ParkinglotUtils.checkInput(carArr, 2)) {
				String slotNoStatusOfRegNo = parkingService.getSlotNumFromRegNo(carArr[1]);
				System.out.println(slotNoStatusOfRegNo);
			}
			break;

		case ParkingLotConstants.CAR_SLOT_NUM_BASED_ON_COLOR:
			if (ParkinglotUtils.checkInput(carArr, 2)) {
				String allSlotNumber = parkingService.findCarSlotNumberForGivenColor(carArr[1]);
				System.out.println(allSlotNumber);
			}
			break;
			
		case ParkingLotConstants.CAR_REG_NO_BASED_ON_COLOR: 
			if (ParkinglotUtils.checkInput(carArr, 2)) {
				String allDetails = parkingService.getCarRegNumbersBasedOnColur(carArr[1]);
				System.out.println(allDetails);
			}
			break;
		}
	}

	public static void parkCar(String[] carDtls) {
		int len = 3;
		if (ParkinglotUtils.checkInput(carDtls, len)) {
			CarModel car = new CarModel(carDtls[1], carDtls[2]);
			String parkVehicleStatus = parkingService.parkCar(car);
			System.out.println(parkVehicleStatus);
		}
	}

}
