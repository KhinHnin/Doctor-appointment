package com.example.doctor.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.doctor.appointment.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {

}
