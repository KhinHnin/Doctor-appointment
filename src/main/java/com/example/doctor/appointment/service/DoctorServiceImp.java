package com.example.doctor.appointment.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doctor.appointment.entity.Doctor;
import com.example.doctor.appointment.repository.DoctorRepository;

@Service
public class DoctorServiceImp implements DoctorService{

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Override
	@Transactional
	public void saveDoctor(Doctor doctor) {
		
		doctorRepository.save(doctor);
	}

	@Override
	@Transactional
	public List<Doctor> getDoctors() {
		
		return doctorRepository.findAll();
	}

	@Override
	@Transactional
	public Doctor getDoctor(Integer doctor_id) {
		return doctorRepository.getOne(doctor_id);
	}

	@Override
	public void deleteDoctor(Integer doc_id) {
		doctorRepository.deleteById(doc_id);
		
	}

}
