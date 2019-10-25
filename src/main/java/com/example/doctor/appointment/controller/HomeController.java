package com.example.doctor.appointment.controller;


import java.util.List;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	
	@GetMapping("/docPf")
	public String showSchedules(Model model) {
		List<Schedule> Schedules=scheduleService.getSchedules();
		List<Doctor> doctors=doctorService.getDoctors();
		model.addAttribute("doctor",doctors);
		model.addAttribute("schedules",Schedules);
		return "doctor_profile";
	}
	
	@GetMapping("/departments")
	public String showDepartments(Model model) {
		
		List<Department> department=departmentService.getDepartments();
		model.addAttribute("departments",department);
		return "view_departments";
	}


	@GetMapping("/findDoctor")
	public String showDoctors(HttpServletRequest request,Model model) {
		List<Department> departmentList=departmentService.getDepartments();
		model.addAttribute("departments",departmentList);
		List<Doctor> doctorList=doctorService.getDoctors();
		model.addAttribute("dList",doctorList);
		
		String dpStr=request.getParameter("dp");
		String docStr=request.getParameter("doc");
		
		if((dpStr==null)&(docStr==null)) {

		List<Doctor> doctors=doctorService.getDoctors();
		model.addAttribute("dr",doctors);
		}else if(dpStr!=null){
		
			Integer dpId=Integer.parseInt(dpStr);
			Department department=departmentService.getDepartment(dpId);
            List<Doctor> doctors=doctorService.getDoctorsByDepartment(department);
			model.addAttribute("dr",doctors);
		
			
		}else {
		Integer docId=Integer.parseInt(docStr);
		Doctor doctor=doctorService.getDoctor(docId);
		
		model.addAttribute("dr",doctor);
	
		
		}
		return "finding_doctor";
	}
		
//		if((dpStr==null)&(docStr==null)) {
//			List<Doctor> doctors=doctorService.getDoctors();
//			model.addAttribute("dr",doctors);
//		}else
//		{
//			
//			Integer docId=Integer.parseInt(docStr);
//			Doctor doctor=doctorService.getDoctor(docId);
//			
//			model.addAttribute("dr",doctor);
//		}
		
		
		
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
}
	
