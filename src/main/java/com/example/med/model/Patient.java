package com.example.med.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name="patients")
public class Patient {
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Size(min = 3, message = "{validation.name.size.too_short}")	
	public String getName() {
		return name;
	}
	@Size(min = 3, message = "{validation.name.size.too_short}")	
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public String getSymptom() {
		return symptom;
	}
	public String getCity() {
		return city;
	}
	@Size(min = 3, message = "{validation.name.size.too_short}")
	private String name;
	@Size(max = 20)
	private String city;
	@Email
	private String email;
	@Size(min = 10)
	private String phoneNo;
	private String symptom;
	
}
