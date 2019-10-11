package com.example.doctor.appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.doctor.appointment.entity.Days;
import com.example.doctor.appointment.entity.Doctor;
import com.example.doctor.appointment.service.DaysService;
import com.example.doctor.appointment.service.DoctorService;

@Controller
public class ScheduleController {
	
	@Autowired
	private DaysService daysService;
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("/admin/schedules")
	public String showSchedules() {
		return "admin/schedules";
	}
	
	@GetMapping("/admin/schedules/new")
	public String addScheduleForm(Model model) {
		List<Days> days=daysService.getDays();
		List<Doctor> doctors=doctorService.getDoctors();
		//model.addAttribute("schedule",new Schedule );
		model.addAttribute("days",days);
		model.addAttribute("doctors",doctors);
		return "admin/add_schedule_form";
	}
	
	@PostMapping
	public String addSchedule(@RequestParam("day_id")Integer day_id) {
		Days day=daysService.getDay(day_id);
		//book.setCategory(category);@ModelAttribute("schedule")Schedule schedule
		//bookService.saveBook(book);
		return "redirect:schedules";
	}
}
