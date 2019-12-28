/**
 * 
 */
package com.gojeck.parkinglot.daotest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojeck.parkinglot.dao.ParkinglotDAO;
import com.gojeck.parkinglot.dao.implementation.ParkinglotDAOImplementation;

/**
 * @author AMITH DAS
 *
 */
public class ParkinglotDaoTest {
	private int parkingLevel;
	private ParkinglotDAO parkingDAO = new ParkinglotDAOImplementation();

	@Before
	public void init() {
		parkingLevel = 6;
	}

	@After
	public void cleanUp() {
		System.setOut(null);
	}

	@Test
	public void createParkingLotsUsingNoOfParking() {
		parkingDAO.createParkinglots(parkingLevel);
	}

}
