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
	private DepartmentService departService;
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping
	public String showDoctorList(Model model) {
		List<Doctor> doctors = doctorService.getDoctor();
		model.addAttribute("doctors", doctors);
		return "admin/doctor-list";
	}
	
	@PostMapping
	public String addDoctors(@RequestParam("departmentId")Integer id,@ModelAttribute("doctor")Doctor doctor) {
		Department depart = departService.getDepartments(id);
		doctor.setDepartment(depart);
		doctorService.saveDoctor(doctor);
		return "redirect:/admin/doctors";
		
	}
	
	@GetMapping("/new")
	public String newDoctor(Model model) {
		List<Department> departments = departService.getDepartments();
		model.addAttribute("department",departments);
		model.addAttribute("doctors",new Doctor());
		return "admin/new-doctors";
	}
	
	@GetMapping("/edit")
	public String ShowdoctorForm(@RequestParam("id")Long id,Model model) {
		
		Doctor doctor = doctorService.getDoctor(id);
		List<Department> departments = departService.getDepartments();
		model.addAttribute("doctors",doctor);
		model.addAttribute("department",departments);
		return "admin/edit-doctors";
	}
	
	@GetMapping("/delete")
	   public  String  deleteDoctor(@RequestParam("id")Long id) {
		doctorService.deleteDoctor(id);
		return "redirect:";
	   }
	

}
