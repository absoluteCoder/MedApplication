package com.example.med.service.impl;

import org.springframework.stereotype.Service;
import com.example.med.model.Doctor;
import com.example.med.service.DoctorService;
import com.example.med.repository.DoctorRepository;
import com.example.med.exception.ResourceNotFoundException;

@Service
public class DoctorServiceImpl implements DoctorService {

	private DoctorRepository doctorRepository;
	
	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}

	
	@Override
	public Doctor saveDoctor(Doctor doctor) {
		return this.doctorRepository.save(doctor);
	}

	@Override
	public void removeDoctor(Long doctorId) {
		this.doctorRepository.findById(doctorId).orElseThrow(
				() -> new ResourceNotFoundException("Doctor", "Id", doctorId));
		this.doctorRepository.deleteById(doctorId);
	}

}
