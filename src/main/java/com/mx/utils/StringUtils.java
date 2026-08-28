package com.mx.utils;

public class StringUtils {

	public static String trimString(String string) {
		
		if (string == null) {
			return null;
		}
		
		String stringProcessed = string.trim();
		return stringProcessed;
	}
	
}
