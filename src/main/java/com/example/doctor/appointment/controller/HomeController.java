package com.example.doctor.appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.doctor.appointment.entity.Department;
import com.example.doctor.appointment.service.DepartmentService;

@Controller
public class HomeController {
	
	@Autowired
	DepartmentService departmentService;
	
	@GetMapping("/")
	public String showHome(Model model) {
		List<Department> Departments=departmentService.getDepartments();
		model.addAttribute("departments",Departments);
		return "home";
	}
}
