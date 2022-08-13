package com.example.med.helper;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PatientHelper {
	private static final Set<String> SYMPTOMS =
		    Collections.unmodifiableSet(
		        new HashSet<>(Arrays.asList("Arthritis", "Backpain", "Tissue injuries",
		        		"Dysmenorrhea",
		        		"Skin infection", "skin burn", 
		        		"Ear pain"
		        		)));
	private static Map<String, String> SPECIALITY_REQUIRED;
	  
    static
    {
    	SPECIALITY_REQUIRED = new HashMap<>();
    	SPECIALITY_REQUIRED.put("Arthritis", "Orthopedic");
    	SPECIALITY_REQUIRED.put("Backpain", "Orthopedic");
    	SPECIALITY_REQUIRED.put("Tissue injuries", "Orthopedic");
    	SPECIALITY_REQUIRED.put("Dysmenorrhea", "Gynecology");
    	SPECIALITY_REQUIRED.put("Skin infection", "Dermatology");
    	SPECIALITY_REQUIRED.put("Skin burn", "Dermatology");
    	SPECIALITY_REQUIRED.put("Ear pain", "ENT");
    }

    public static boolean isValidSymptom(String symptom) {
		return SYMPTOMS.contains(symptom);
	}
	
    public static String getSpecialityRequired(String symptom) {
    	return SPECIALITY_REQUIRED.get(symptom);
    }
}
