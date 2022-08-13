package com.example.med.service;

import com.example.med.model.Doctor;

public interface DoctorService {

	Doctor saveDoctor(Doctor doctor);
	void removeDoctor(Long doctorId);
}
