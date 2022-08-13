package com.example.med.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.med.model.Doctor;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	List<Doctor> findAllByCity(String city);
}
