package com.example.med.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor) {
		return new ResponseEntity<Doctor>(doctorService.saveDoctor(doctor), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable("id") Long doctorId) {
		doctorService.removeDoctor(doctorId);
		return new ResponseEntity<String>("Succesfully Doctor data got deleted", HttpStatus.OK);
	}

}
