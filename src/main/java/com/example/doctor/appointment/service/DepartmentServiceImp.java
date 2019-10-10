package com.example.doctor.appointment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doctor.appointment.entity.Department;
import com.example.doctor.appointment.repository.DepartmentRepository;

@Service
public class DepartmentServiceImp implements DepartmentService{

	
	@Autowired
        private DepartmentRepository departmentRepository;
	
	@Override
	public void saveDepartment(Department department) {
		departmentRepository.save(department);
		
	}

	@Override
	public List<Department> getDepartments() {
		
		return departmentRepository.findAll();
	}

}
