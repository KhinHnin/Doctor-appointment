package com.example.doctor.appointment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.doctor.appointment.entity.Doctor;
import com.example.doctor.appointment.repository.DoctorRepository;

@Service
public class DoctorServiceImplement implements DoctorService{

	@Autowired
	private DoctorRepository doctorRepo;

	@Override
	public void saveDoctor(Doctor doctor) {
		doctorRepo.save(doctor);
		
	}

	@Override
	public List<Doctor> getDoctor() {
	
		return doctorRepo.findAll();
	}

	@Override
	public Doctor getDoctor(Long id) {
		
		return doctorRepo.getOne(id);
	}

	@Override
	public void deleteDoctor(Long id) {
		doctorRepo.deleteById(id);
		
	}

	
	
}
