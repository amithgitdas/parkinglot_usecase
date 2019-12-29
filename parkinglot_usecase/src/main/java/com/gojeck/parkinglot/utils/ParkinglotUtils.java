package com.gojeck.parkinglot.utils;

import java.util.List;

/**
 * The Class ParkinglotUtils.
 */
public class ParkinglotUtils {
	
	/**
	 * Check input.
	 *
	 * @param carDtls the car dtls
	 * @param len the len
	 * @return true, if successful
	 */
	public static boolean checkInput(String[] carDtls, int len) {
		if (carDtls == null || carDtls.length < len) {
			System.out.println("Input is not in proper format enter instructions to check the format");
			return false;
		}
		return true;
	}

	/**
	 * Validate in put.
	 *
	 * @param numVal the num val
	 * @return true, if successful
	 */
	public static boolean validateInPut(String numVal) {
		try {
			Integer.parseInt(numVal);
			return true;
		} catch (Exception e) {
			System.out.println("Input is not in proper format enter instructions to check the format");
			return false;
		}
	}

	/**
	 * Convert list to string.
	 *
	 * @param list the list
	 * @return the string
	 */
	public static String convertListToString(List<?> list) {
		return list.toString().replace("[", "").replace("]", "");
	}
	
	/**
	 * Prints the instructions.
	 */
	public static void printInstructions() {
		System.out.println("\n          Vechile Parking Command Help");
		System.out.println("--------------------------------------");
		System.out.println("park <RegistrationNo> <Color>");
		System.out.println("status");
		System.out.println("leave <Parking lot Number>");
		System.out.println("registration_numbers_for_cars_with_colour <color>");
		System.out.println("slot_numbers_for_cars_with_colour <color>");
		System.out.println("slot_number_for_registration_number <Registration Number>");
		System.out.println("exit\n");
	}
}
