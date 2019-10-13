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

import com.example.doctor.appointment.entity.Doctor;
import com.example.doctor.appointment.entity.Schedule;
import com.example.doctor.appointment.service.DoctorService;
import com.example.doctor.appointment.service.ScheduleService;

@Controller
@RequestMapping("/admin/schedules")
public class ScheduleController {
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private ScheduleService scheduleService;
	
	@GetMapping
	public String showSchedules(Model model) {
		List<Schedule> Schedules=scheduleService.getSchedules();
		model.addAttribute("schedules",Schedules);
		return "admin/schedules";
	}
	
	@GetMapping("/new")
	public String addScheduleForm(Model model) {
		List<Doctor> doctors=doctorService.getDoctors();
		model.addAttribute("schedule",new Schedule() );
		model.addAttribute("doctors",doctors);
		return "admin/add_schedule_form";
	}
	
	@PostMapping
	public String addSchedule(@RequestParam("doctor_Id")Integer doctor_id,@ModelAttribute("schedule")Schedule schedule) {
		Doctor doctor=doctorService.getDoctor(doctor_id);
		schedule.setDoctor(doctor);
		scheduleService.saveSchedule(schedule);
		return "redirect:schedules";
	}
	
	@GetMapping("editSchedule")
	public String showEditScheduleForm(@RequestParam("id")Integer schedule_id,Model model) {
		Schedule sche=scheduleService.getSchedule(schedule_id);
		List<Doctor> Doctors=doctorService.getDoctors();
		model.addAttribute("schedule",sche);
		model.addAttribute("doctors",Doctors);
		return "admin/edit_schedule_form";
	}
	
	@GetMapping("deleteSchedule")
	public String deleteSchedule(@RequestParam("id")Integer sche_id) {
		scheduleService.deleteScheduleById(sche_id);
		return "redirect:";
	}
}
