package com.example.doctor.appointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.doctor.appointment.entity.Department;
import com.example.doctor.appointment.entity.Doctor;
import com.example.doctor.appointment.entity.Schedule;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

	List<Doctor> findAllByDepartment(Department department);

	
}
