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
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name= "qualification")
	private String qualification;
	@Column(name= "image")
	private String image;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	
	private Department department;

	public Doctor(int id, String name, String qualification, String image, Department department) {
		super();
		this.id = id;
		this.name = name;
	
		this.qualification = qualification;
		this.image = image;
		this.department = department;
	}

	public Doctor(String name, String speciality, String qualification, String image, Department department) {
		super();
		this.name = name;
		
		this.qualification = qualification;
		this.image = image;
		this.department = department;
	}

	public Doctor() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	

}
