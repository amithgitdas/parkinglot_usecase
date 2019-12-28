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
		String[] inputArr = input.split(" ");
		switch (inputArr[0]) {
		case ParkingLotConstants.PARK_CAR:
			parkCar(inputArr);
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
