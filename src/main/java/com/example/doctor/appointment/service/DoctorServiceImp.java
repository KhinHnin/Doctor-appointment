package com.example.doctor.appointment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doctor.appointment.entity.Doctor;
import com.example.doctor.appointment.repository.DoctorRepository;

@Service
public class DoctorServiceImp implements DoctorService{

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Override
	public void saveDoctor(Doctor doctor) {
		
		doctorRepository.save(doctor);
	}

	@Override
	public List<Doctor> getDoctors() {
		
		return doctorRepository.findAll();
	}

}
