package com.example.med.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import lombok.Data;

@Data
@Entity
@Table(name="doctors")
public class Doctor {
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Size(min = 3, message = "{validation.name.size.too_short}")
	public String getName() {
		return name;
	}
	@Size(min = 3, message = "{validation.name.size.too_short}")
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getSpeciality() {
		return speciality;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Size(max = 20)
	private String city;
	@Size(min = 3, message = "{validation.name.size.too_short}")
	private String name;
	@Email
	private String email;
	@Size(min = 10)
	private String phoneNo;
	private String speciality;
}
