/**
 * 
 */
package com.gojeck.parkinglot.slotassignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.gojeck.parkinglot.constants.ParkingLotConstants;
import com.gojeck.parkinglot.exceptions.ParkingLotNotAvilableException;
import com.gojeck.parkinglot.model.CarModel;
import com.gojeck.parkinglot.service.ParkinglotService;
import com.gojeck.parkinglot.serviceimplementation.ParkinglotSeriveImplemenation;
import com.gojeck.parkinglot.utils.ParkinglotUtils;

/**
 * The Class ParkingLotAssignment.
 *
 * @author AMITH DAS
 */
public class ParkingLotAssignment {

	/**
	 * The parking service.
	 *
	 */
	static ParkinglotService parkingService = new ParkinglotSeriveImplemenation();
	
	/** The scn. */
	static Scanner scn = new Scanner(System.in);

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws NumberFormatException the number format exception
	 * @throws ParkingLotNotAvilableException the parking lot not avilable exception
	 */
	public static void main(String[] args) throws NumberFormatException, ParkingLotNotAvilableException {
		BufferedReader bufferReader = null;
		String instructLine = null;
		switch (args.length) {
		case 0: {
			if ("exit".equalsIgnoreCase(instructLine)) {
				break;
			} else {
				while (true) {
					parkingSlotAssignment(scn.nextLine());
				}
			}
		}
		case 1:
		{

			File inputFile = new File(args[0]);
			try {
				bufferReader = new BufferedReader(new FileReader(inputFile));
				while ((instructLine = bufferReader.readLine()) != null) {
					instructLine = instructLine.trim();

					parkingSlotAssignment(instructLine);
				}
			} catch (Exception e) {
				throw new ParkingLotNotAvilableException("INVALID FILE PATH", e);
			}
			break;
		}
		default:
			System.out.println("Invalid input. Usage: java -jar <jar_path> <input_file_path>");
		}

	}

	/**
	 * Parking slot assignment.
	 *
	 * @param input the input
	 * @throws NumberFormatException the number format exception
	 * @throws ParkingLotNotAvilableException the parking lot not avilable exception
	 */
	public static void parkingSlotAssignment(String input)
			throws NumberFormatException, ParkingLotNotAvilableException {
		String[] carArr = input.split(" ");
		switch (carArr[0]) {
		case ParkingLotConstants.CREATE_PARKING_LOT:
			parkingService.createParkingLot(Integer.parseInt(carArr[1]));
			System.out.println("Created a parking lot with " + Integer.parseInt(carArr[1]) + " slots");
			break;

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

		case ParkingLotConstants.LEAVE_CAR:
			if (ParkinglotUtils.checkInput(carArr, 2) && ParkinglotUtils.validateInPut(carArr[1])) {
				String leaveParkingStatus = parkingService.leaveCar(Integer.parseInt(carArr[1]));
				System.out.println(leaveParkingStatus);
			}
			break;

		case ParkingLotConstants.CAR_PARK_STATUS:
			printParkingStatus();
			break;

		case ParkingLotConstants.INSTRUCTIONS:
			ParkinglotUtils.printInstructions();
			break;
		case ParkingLotConstants.EXIT_PROGRAM:
			System.out.println("Application Closed.");
			System.exit(0);
			break;

		default:
			System.out.println("Entered values incorrect! Please enter instructions for all commands");
			break;
		}

	}

	/**
	 * Park car.
	 *
	 * @param carDtls the car dtls
	 */
	public static void parkCar(String[] carDtls) {
		int len = 3;
		if (ParkinglotUtils.checkInput(carDtls, len)) {
			CarModel car = new CarModel(carDtls[1], carDtls[2]);
			String parkVehicleStatus = parkingService.parkCar(car);
			System.out.println(parkVehicleStatus);
		}
	}

	/**
	 * Prints the parking status.
	 */
	public static void printParkingStatus() {
		Set<Entry<Integer, CarModel>> parkingDetails = parkingService.carParkStatus();
		System.out.println("Slot No." + "  " + " Registration No " + "\t" + " Colour");
		for (Entry<Integer, CarModel> park : parkingDetails) {
			if (park.getValue() != null)
				System.out.println(park.getKey() + "\t    " + park.getValue().getRegistrationNo() + "\t\t  "
						+ park.getValue().getColor());
		}
	}

}
