package com.example.doctor.appointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doctor.appointment.entity.Doctor;


public interface DoctorRepository extends JpaRepository<Doctor, Long>{

	

}
