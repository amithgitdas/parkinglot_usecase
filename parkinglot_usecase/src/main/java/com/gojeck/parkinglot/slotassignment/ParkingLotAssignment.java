/**
 * 
 */
package com.gojeck.parkinglot.slotassignment;

import java.util.Scanner;

import com.gojeck.parkinglot.service.ParkinglotService;
import com.gojeck.parkinglot.serviceimplementation.ParkinglotSeriveImplemenation;

/**
 * @author AMITH DAS
 *
 */
public class ParkingLotAssignment {

	/**
	 * @param args
	 */
	static ParkinglotService parkingService = new ParkinglotSeriveImplemenation();
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int noOfParkingSlots = 0;
		while (true) {
			try {
				System.out.println("create_parking_lot : ");
				noOfParkingSlots = in.nextInt();
				break;
			} catch (Exception e) {
				in.next();
				System.out.println("Please input correct number.");
			}
		}
		parkingService.createParkingLot(noOfParkingSlots);
		System.out.println("Created a parking lot with " + noOfParkingSlots + " slots");

	}

}
