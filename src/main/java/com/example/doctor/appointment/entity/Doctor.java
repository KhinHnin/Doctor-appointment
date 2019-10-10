package com.example.doctor.appointment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "doctors")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="doctorname")
	private String doctorname;
	
	@Column(name="specialties")
	private String specialites;
	
	@Column(name="qualifications")
	private String qualification;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;

	
	public Doctor() {
		
	}

	public Doctor(String doctorname, String specialites, String qualification) {
		
		this.doctorname = doctorname;
		this.specialites = specialites;
		this.qualification = qualification;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getSpecialites() {
		return specialites;
	}

	public void setSpecialites(String specialites) {
		this.specialites = specialites;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	

	
	
	
	
	
	

}
