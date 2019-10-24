package com.example.doctor.appointment.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "schedules")
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
	
	@OneToMany(mappedBy = "schedule")
	private List<AppointmentDetail> appointmentDetails;

	public List<AppointmentDetail> getAppointmentDetails() {
		return appointmentDetails;
	}

	public void setAppointmentDetails(List<AppointmentDetail> appointmentDetails) {
		this.appointmentDetails = appointmentDetails;
	}

	public Schedule(int id, Doctor doctor, List<AppointmentDetail> appointmentDetails, String day, String fromTime,
			String toTime, Date date) {
		super();
		this.id = id;
		this.doctor = doctor;
		this.appointmentDetails = appointmentDetails;
		this.day = day;
		this.fromTime = fromTime;
		this.toTime = toTime;
		this.date = date;
	}

	@Column(name = "day")
	private String day;

	@Column(name = "start_Time")
	private String fromTime;

	@Column(name = "end_Time")
	private String toTime;
	
	@Column(name = "date")
	private Date date;
	
	

	public Schedule() {

	}

	public Schedule(int id, Doctor doctor, String day, String fromTime, String toTime, Date date) {
		super();
		this.id = id;
		this.doctor = doctor;
		this.day = day;
		this.fromTime = fromTime;
		this.toTime = toTime;
		this.date = date;
	}

	public Schedule(Doctor doctor, String day, String fromTime, String toTime, Date date) {
		super();
		this.doctor = doctor;
		this.day = day;
		this.fromTime = fromTime;
		this.toTime = toTime;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	
	

	
}
