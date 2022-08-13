package com.example.med.helper;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DoctorHelper {
	private static final Set<String> CITIES =
		    Collections.unmodifiableSet(
		        new HashSet<>(Arrays.asList("Delhi", "Noida", "Faridabad")));
	private static final Set<String> SPECIALITIES =
		    Collections.unmodifiableSet(
		        new HashSet<>(Arrays.asList("Orthopedic", "Gynecology", "Dermatology", "ENT specialist")));
	
	public static boolean isValidCity(String city) {
		return CITIES.contains(city);
	}	
	
	public static boolean isValidSpeciality(String speciality) {
		return SPECIALITIES.contains(speciality);
	}	
	
	
	
}
