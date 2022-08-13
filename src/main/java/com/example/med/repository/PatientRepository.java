package com.example.med.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.med.model.Patient;


public interface PatientRepository extends JpaRepository<Patient, Long>{

}
