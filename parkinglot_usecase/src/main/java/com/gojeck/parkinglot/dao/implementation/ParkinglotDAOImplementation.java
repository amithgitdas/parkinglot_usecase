package com.gojeck.parkinglot.dao.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import com.gojeck.parkinglot.dao.ParkinglotDAO;
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

}
