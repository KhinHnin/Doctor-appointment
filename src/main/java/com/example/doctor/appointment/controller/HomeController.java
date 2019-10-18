package com.example.doctor.appointment.controller;

import java.awt.print.Book;
import java.util.List;
import java.util.Locale.Category;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.doctor.appointment.entity.Department;
import com.example.doctor.appointment.entity.Doctor;
import com.example.doctor.appointment.entity.Schedule;
import com.example.doctor.appointment.service.DepartmentService;
import com.example.doctor.appointment.service.DoctorService;
import com.example.doctor.appointment.service.ScheduleService;

@Controller
public class HomeController {
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private DepartmentService departmentService;
	
	
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/docPf")
	public String showSchedules(@RequestParam("id")Integer id,Model model) {
		List<Schedule> Schedules=scheduleService.getSchedules();
		Doctor doctors=doctorService.getDoctor(id);
		model.addAttribute("doctor",doctors);
		model.addAttribute("schedules",Schedules);
		return "doctor_profile";
	}
	

	@GetMapping("/findDoctor")
	public String showDoctors(HttpServletRequest request,Model model) {
		List<Department> departmentList=departmentService.getDepartments();
		model.addAttribute("departments",departmentList);
		String dpStr=request.getParameter("dp");
		if(dpStr==null) {

			List<Doctor> doctors=doctorService.getDoctors();
		model.addAttribute("doc",doctors);
		}else {
			Integer dpId=Integer.parseInt(dpStr);
			Department department=departmentService.getDepartment(dpId);
            List<Doctor> doctors=doctorService.getDoctorsByDepartment(department);
			model.addAttribute("d",doctors);
		}
		
		return "finding_doctor";
	}
	
	
	
}
