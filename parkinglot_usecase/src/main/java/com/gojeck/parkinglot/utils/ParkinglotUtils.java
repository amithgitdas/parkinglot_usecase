package com.gojeck.parkinglot.utils;

import java.util.List;

public class ParkinglotUtils {
	public static boolean checkInput(String[] carDtls, int len) {
		if (carDtls == null || carDtls.length < len) {
			System.out.println("Input is not in proper format enter instructions to check teh format");
			return false;
		}
		return true;
	}

	public static boolean validateInPut(String numVal) {
		try {
			Integer.parseInt(numVal);
			return true;
		} catch (Exception e) {
			System.out.println("Input is not in proper format enter instructions to check teh format");
			return false;
		}
	}

	public static String convertListToString(List<?> list) {
		return list.toString().replace("[", "").replace("]", "");
	}
}
