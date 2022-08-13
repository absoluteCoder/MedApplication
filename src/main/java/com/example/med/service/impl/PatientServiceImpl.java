package com.example.med.service.impl;

import org.springframework.stereotype.Service;

import com.example.med.service.PatientService;
import com.example.med.model.Doctor;
import com.example.med.model.Patient;
import com.example.med.repository.DoctorRepository;
import com.example.med.repository.PatientRepository;
import com.example.med.exception.ResourceNotFoundException;
import com.example.med.helper.PatientHelper;
import com.example.med.helper.DoctorHelper;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{

	private PatientRepository patientRepository;
	private DoctorRepository doctorRepository;
	
	PatientServiceImpl(PatientRepository patientRepository, DoctorRepository doctorRepository){
		super();
		this.patientRepository = patientRepository;
		this.doctorRepository = doctorRepository;
	}

	@Override
	public Patient savePatient(Patient patient) {
		if(!PatientHelper.isValidSymptom(patient.getSymptom())) {
			throw new ResourceNotFoundException("Symptoms are not valid.", "symtoms", patient.getSymptom());
		}
		return this.patientRepository.save(patient);
	}

	@Override
	public void removePatient(Long patientId) {
		this.patientRepository.findById(patientId).orElseThrow(() -> 
			new ResourceNotFoundException("Patient", "Id", patientId));
		this.patientRepository.deleteById(patientId);
	}

	@Override
	public Doctor suggestDoctor(Long patientId){
		Patient patient = this.patientRepository.findById(patientId).orElseThrow(() -> 
				new ResourceNotFoundException("Patient", "Id", patientId));
		String patientCity = patient.getCity();
		if(!DoctorHelper.isValidCity(patientCity)) {
			throw new ResourceNotFoundException("We are still waiting to expand to your location", "Id", patientId);
		}
		String specialityRequired = PatientHelper.getSpecialityRequired(patient.getSymptom());
		
		List<Doctor> doctors = this.doctorRepository.findAllByCity(patientCity);
		for(Doctor doctor: doctors) {
			if(doctor.getSpeciality().equals(specialityRequired)) {
				return doctor;
			}
		}
		throw new ResourceNotFoundException("There isn’t any doctor present at your location for your symptom", "Id", patientId);
	}
}
