package com.example.doctor.appointment.service;

import java.util.List;

import com.example.doctor.appointment.entity.Doctor;

public interface DoctorService {
	
	public void saveDoctor(Doctor doctor);

	public List<Doctor> getDoctors();

	public Doctor getDoctor(Integer doctor_id);

	public void deleteDoctor(Integer doc_id);

}
