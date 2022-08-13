package com.example.med.controller;


import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.med.exception.ResourceNotFoundException;
import com.example.med.model.Doctor;
import com.example.med.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	private DoctorService doctorService;

	public DoctorController(DoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> saveDoctor(@Valid @RequestBody Doctor doctor) {
		try {
			return new ResponseEntity<Object>(doctorService.saveDoctor(doctor), HttpStatus.CREATED);			
		}
		catch (ResourceNotFoundException exe){
			return new ResponseEntity<Object>(exe.getMessage(), HttpStatus.BAD_REQUEST);  
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable("id") Long doctorId) {		
		try {
			doctorService.removeDoctor(doctorId);
			return new ResponseEntity<String>("Succesfully Doctor data got deleted", HttpStatus.OK);
		}
		catch (ResourceNotFoundException exe){
			return new ResponseEntity<String>(exe.getMessage(), HttpStatus.BAD_REQUEST);  
		}

	}
}
