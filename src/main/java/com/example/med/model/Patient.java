package com.example.med.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="patients")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public String getSymptom() {
		return symptom;
	}
	public String getCity() {
		return city;
	}
	private String name;
	private String city;
	private String email;
	private String phoneNo;
	private String symptom;
	
}
