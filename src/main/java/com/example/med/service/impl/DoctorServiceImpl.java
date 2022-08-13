package com.example.med.service.impl;

import org.springframework.stereotype.Service;
import com.example.med.model.Doctor;
import com.example.med.service.DoctorService;
import com.example.med.repository.DoctorRepository;
import com.example.med.exception.ResourceNotFoundException;
import com.example.med.helper.DoctorHelper;

@Service
public class DoctorServiceImpl implements DoctorService {

	private DoctorRepository doctorRepository;
	
	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}

	
	@Override
	public Doctor saveDoctor(Doctor doctor) {
		if(!DoctorHelper.isValidCity(doctor.getCity()) ) {
			throw new ResourceNotFoundException("Doctor's city is not valid", "city", doctor.getCity());
		}
		if(!DoctorHelper.isValidSpeciality(doctor.getSpeciality()) ) {
			throw new ResourceNotFoundException("Doctor's speciality is not valid", "Speciality", doctor.getSpeciality());
		}
		return this.doctorRepository.save(doctor);
	}

	@Override
	public void removeDoctor(Long doctorId) {
		this.doctorRepository.findById(doctorId).orElseThrow(
				() -> new ResourceNotFoundException("Doctor", "Id", doctorId));
		this.doctorRepository.deleteById(doctorId);
	}

}
