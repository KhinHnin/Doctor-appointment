package com.example.doctor.appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.doctor.appointment.entity.Doctor;
import com.example.doctor.appointment.entity.Schedule;
import com.example.doctor.appointment.service.DoctorService;
import com.example.doctor.appointment.service.ScheduleService;

@Controller
public class HomeController {
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private ScheduleService scheduleService;
	
	
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/docPf")
	public String showSchedules(Model model) {
		List<Schedule> Schedules=scheduleService.getSchedules();
		List<Doctor> doctors=doctorService.getDoctors();
		model.addAttribute("doctor",doctors);
		model.addAttribute("schedules",Schedules);
		return "doctor_profile";
	}
	
	
}
