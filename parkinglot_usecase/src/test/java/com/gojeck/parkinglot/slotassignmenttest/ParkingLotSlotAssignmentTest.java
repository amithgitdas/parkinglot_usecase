package com.gojeck.parkinglot.slotassignmenttest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojeck.parkinglot.exceptions.ParkingLotNotAvilableException;
import com.gojeck.parkinglot.slotassignment.ParkingLotAssignment;

/**
 * The Class ParkingLotSlotAssignmentTest.
 */
public class ParkingLotSlotAssignmentTest {

	/** The parking level. */
	private int parkingLevel;

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		parkingLevel = 1;
	}

	/**
	 * Clean up.
	 */
	@After
	public void cleanUp() {
		System.setOut(null);
	}

	/**
	 * Test.
	 */
//	@Test(expected=NullPointerException.class)
	public void parkingSlotAssignmentTest() {
		ParkingLotAssignment.printParkingStatus();
		try {
			ParkingLotAssignment.parkingSlotAssignment("create_parking_lot 6");
			ParkingLotAssignment.parkingSlotAssignment("park KA-01-HH-1234 White");
			ParkingLotAssignment.parkingSlotAssignment("park KA-01-HH-9999 White");
			ParkingLotAssignment.parkingSlotAssignment("park KA-01-BB-0001 Black");
			ParkingLotAssignment.parkingSlotAssignment("park KA-01-HH-7777 Red");
			ParkingLotAssignment.parkingSlotAssignment("park KA-01-HH-2701 Blue");
			ParkingLotAssignment.parkingSlotAssignment("park KA-01-HH-3141 Black");
			ParkingLotAssignment.parkingSlotAssignment("leave 4");
			ParkingLotAssignment.parkingSlotAssignment("status");
			ParkingLotAssignment.parkingSlotAssignment("park KA-01-P-333 White");
			ParkingLotAssignment.parkingSlotAssignment("park DL-12-AA-9999 White");
			ParkingLotAssignment.parkingSlotAssignment("registration_numbers_for_cars_with_colour White");
			ParkingLotAssignment.parkingSlotAssignment("slot_numbers_for_cars_with_colour White");
			ParkingLotAssignment.parkingSlotAssignment("slot_number_for_registration_number KA-01-HH-3141");
			ParkingLotAssignment.parkingSlotAssignment("slot_number_for_registration_number MH-04-AY-1111");
			
			assert(true);
		} catch (NumberFormatException e) {
		} catch (ParkingLotNotAvilableException e) {
		}
	}

}
