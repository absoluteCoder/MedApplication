package com.example.med.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.med.model.Patient;
import com.example.med.exception.ResourceNotFoundException;
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
	public ResponseEntity<Object> savePatient(@RequestBody Patient patient) {
		try {
			return new ResponseEntity<Object>(patientService.savePatient(patient), HttpStatus.CREATED);
		}
		catch (ResourceNotFoundException exe){
			return new ResponseEntity<Object>(exe.getMessage(), HttpStatus.BAD_REQUEST);  
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePatient(@PathVariable("id") Long patientId) {
		try {
			patientService.removePatient(patientId);
			return new ResponseEntity<String>("Succesfully Patient data got deleted", HttpStatus.OK);
		}
		catch (ResourceNotFoundException exe){
			return new ResponseEntity<String>(exe.getMessage(), HttpStatus.BAD_REQUEST);  
		}
	}

	@GetMapping("/getSuggestedDoctor/{id}")
	public ResponseEntity<Object> getSuggestedDoctor(@PathVariable("id") Long patientId) {
		try {
			return new ResponseEntity<Object>(patientService.suggestDoctor(patientId), HttpStatus.OK);
		}
		catch (ResourceNotFoundException exe){
			return new ResponseEntity<Object>(exe.getMessage(), HttpStatus.BAD_REQUEST);  
		}

	}
}
