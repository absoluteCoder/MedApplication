package com.example.med.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.med.model.Patient;
import com.example.med.model.Doctor;
import com.example.med.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	private PatientService patientService;

	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
		return new ResponseEntity<Patient>(patientService.savePatient(patient), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deletePatient(@PathVariable("id") Long patientId) {
		patientService.removePatient(patientId);
		return new ResponseEntity<String>("Succesfully Patient data got deleted", HttpStatus.OK);
	}

	@GetMapping("/getSuggestedDoctor/{id}")
	public ResponseEntity<Doctor> getSuggestedDoctor(@PathVariable("id") Long patientId) {
		return new ResponseEntity<Doctor>(patientService.suggestDoctor(patientId), HttpStatus.OK);
	}
}
