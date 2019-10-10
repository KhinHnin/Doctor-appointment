package com.example.doctor.appointment.service;

import java.util.List;

import com.example.doctor.appointment.entity.Department;

public interface DepartmentService {

	public void saveDepartment(Department department);
	public List<Department> getDepartments();
}
