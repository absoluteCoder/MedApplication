package com.example.med.service;

import com.example.med.model.Patient;
import com.example.med.model.Doctor;

public interface PatientService {
	
	Patient savePatient(Patient patient);
	void removePatient(Long patientId);
	Doctor suggestDoctor(Long patientId);
}
