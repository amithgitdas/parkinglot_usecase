package com.gojeck.parkinglot.slotassignmenttest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotSlotAssignmentTest {

	private int parkingLevel;

	@Before
	public void init() {
		parkingLevel = 1;
	}

	@After
	public void cleanUp() {
		System.setOut(null);
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

}
