package com.example.doctor.appointment.service;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doctor.appointment.entity.Doctor;


public interface DoctorService{

	public void saveDoctor(Doctor doctor);
	
	public List<Doctor> getDoctor();
	
	public Doctor getDoctor(Long id);

	public void deleteDoctor(Long id);

	
//	public List<Doctor> getDoctorByDepartment(Department department);

}
