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
	
	@GetMapping
	public String showDoctorList(Model model) {
		List<Doctor> Doctors=doctorService.getDoctors();
		model.addAttribute("doctors",Doctors);
		//model.addAttribute("doctor",new Doctor());
		return "admin/doctor";
	}
	
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
		return "redirect:doctors";
	}	
	
	@GetMapping("/edit")
	public String editDoctor(@RequestParam("id")Integer doc_id,Model model) {
		Doctor doc=doctorService.getDoctor(doc_id);
		List<Department> Departments=departmentService.getDepartments();
		model.addAttribute("doctor",doc);	
		model.addAttribute("departments",Departments);
		return "admin/editdoctor";
	}
	
	@GetMapping("/delete")
	public String deleteDoctor(@RequestParam("id")Integer doc_id) {
		doctorService.deleteDoctor(doc_id);
		return "redirect:";
	}

}
