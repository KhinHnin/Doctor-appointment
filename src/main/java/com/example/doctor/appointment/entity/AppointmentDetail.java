package com.example.doctor.appointment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="appointments")
public class AppointmentDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "schedule_id")
	private Schedule schedule;
	
	@Column(name="patient_name")
	@NotNull
	@Size(min=3,max=25,message="Name size must be between 3 and 25")
	private String patient_name;
	
	@Column(name="gender")
	@NotNull(message="Gender must not be blank")
	private String gender;
	
	@Column(name="age")
	@NotNull
	private int age;
	
	@Column(name="phone_no")
	//@Pattern(regexp = "(\\+95|0)[0-9]{9}")
	@Size(min=11,message="Invalid Phone Number**(Phone number size is 11)")
	private String phone_no;

	public AppointmentDetail() {
		super();
	}

	public AppointmentDetail(int id, Schedule schedule, @NotNull @Size(min = 3, max = 25) String patient_name,
			@NotNull String gender, @NotNull @Size(min = 1, max = 2) int age,
			@Pattern(regexp = "(\\+95|0)[0-9]{9}") @Size(min = 13, message = "Invalid Phone Number**") String phone_no) {
		super();
		this.id = id;
		this.schedule = schedule;
		this.patient_name = patient_name;
		this.gender = gender;
		this.age = age;
		this.phone_no = phone_no;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	
	
}
