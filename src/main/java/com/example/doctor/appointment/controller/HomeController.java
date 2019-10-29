package com.example.doctor.appointment.controller;

import java.util.List;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.doctor.appointment.entity.AppointmentDetail;
import com.example.doctor.appointment.entity.Department;
import com.example.doctor.appointment.entity.Doctor;
import com.example.doctor.appointment.entity.Schedule;
import com.example.doctor.appointment.service.AppointmentDetailService;
import com.example.doctor.appointment.service.DepartmentService;
import com.example.doctor.appointment.service.DoctorService;
import com.example.doctor.appointment.service.ScheduleService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private DepartmentService departmentService;
	

	@Autowired
	private AppointmentDetailService appointmentDetailService;
	
	@GetMapping
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/docPf")
	public String showSchedules(@RequestParam("id")Integer id,Model model) {
		Doctor doctors=doctorService.getDoctor(id);
		model.addAttribute("doctor",doctors);
		
		//AppointmentCount Detail
		List<Schedule> schedulelist=new ArrayList<Schedule>();
		List<Schedule> scheduleList=scheduleService.getSchedules();
		for(Schedule schedule:scheduleList) {
			List<AppointmentDetail> Appointments=appointmentDetailService.getAppointmentsBySchedule(schedule);
			if(Appointments.size()<3) {
				schedulelist.add(schedule);
			}
		}
		
		//if(schedulelist.size()!=0) {
			model.addAttribute("schedules",schedulelist);
			return "doctor_profile";
		//}else {
			
		//}
	}
	
	@GetMapping("/departments")
	public String showDepartments(Model model) {
		
		List<Department> department=departmentService.getDepartments();
		model.addAttribute("departments",department);
		return "view_departments";
	}


	@GetMapping("/findDoctor")
	public String showDoctors(HttpServletRequest request,Model model) {
		List<Schedule> Schedules=scheduleService.getSchedules();
		model.addAttribute("schedules",Schedules);
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
}


//if((dpStr==null)&(docStr==null)) {
//List<Doctor> doctors=doctorService.getDoctors();
//model.addAttribute("dr",doctors);
//}else
//{
//
//Integer docId=Integer.parseInt(docStr);
//Doctor doctor=doctorService.getDoctor(docId);
//
//model.addAttribute("dr",doctor);
//}

	
