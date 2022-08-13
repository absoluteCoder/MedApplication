package com.example.med.service.impl;

import org.springframework.stereotype.Service;

import com.example.med.service.PatientService;
import com.example.med.model.Doctor;
import com.example.med.model.Patient;
import com.example.med.repository.DoctorRepository;
import com.example.med.repository.PatientRepository;
import com.example.med.exception.ResourceNotFoundException;
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
		if(doctorsNotPresentInCity(patientCity)) {
			throw new ResourceNotFoundException("We are expanding service", "Id", patientId);
		}
		String patientSymptom = patient.getSymptom();
		List<Doctor> doctors = this.doctorRepository.findAllByCity(patientCity);
		for(Doctor doctor: doctors) {
			if(SymptomIsMatched(doctor.getSpeciality(), patientSymptom)) {
				return doctor;
			}
		}
		throw new ResourceNotFoundException("Doctors are not avaiable for this symptom", "Id", patientId);
	}
	
	private boolean SymptomIsMatched(String doctorSpeciality, String patientSymptom) {
		// check by using predefined hash-map etc. 
		return doctorSpeciality == patientSymptom;
	}
	private boolean doctorsNotPresentInCity(String patientCity) {
		// check using hash-set etc.
		return false;
	}
}
