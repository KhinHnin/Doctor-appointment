package com.example.doctor.appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.doctor.appointment.entity.Department;
import com.example.doctor.appointment.entity.Doctor;
import com.example.doctor.appointment.service.DepartmentService;
import com.example.doctor.appointment.service.DoctorService;

@Controller
@RequestMapping("/admin/doctors")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/adddoctors")
	public String showDoctorsForm(Model model) {
		List<Department> departments=departmentService.getDepartments();
		model.addAttribute("doctor",new Doctor());
		model.addAttribute("dp",departments);
		return"admin/doctor-form";
	}
	
	@PostMapping
	public String saveDoctor(@RequestParam("departmentId")Integer id,@ModelAttribute("doctor")Doctor doctor) {
		Department department=departmentService.getDepartment(id);
		doctor.setDepartment(department);
		doctorService.saveDoctor(doctor);
		return "admin/admin";
	}
	
	

}
