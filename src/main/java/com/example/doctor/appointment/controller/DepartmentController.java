package com.example.doctor.appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.doctor.appointment.entity.Department;
import com.example.doctor.appointment.service.DepartmentService;

@Controller
@RequestMapping("/admin/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping
	public String saveDepartments(@ModelAttribute("department")Department department) {
		 departmentService.saveDepartment(department);
		 return "redirect:/admin/departments";
	}

//	@GetMapping
//	public String showDepartment(Model model) {
//		List<Department> dp=departmentService.getDepartments();
//		Model addAttribute = model.addAttribute("categories", dp);
//		model.addAttribute("department",new Department());
//		
//		return "admin/departments";
//	}
	
	@GetMapping
	public String showDepartment(Model model) {
		List<Department> dp=departmentService.getDepartments();
		model.addAttribute("departments",dp);
		model.addAttribute("department",new Department());
		return "admin/departments";
	}
}
