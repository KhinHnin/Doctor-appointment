package com.example.doctor.appointment.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.doctor.appointment.entity.AppointmentDetail;
import com.example.doctor.appointment.entity.Department;
import com.example.doctor.appointment.entity.Doctor;
import com.example.doctor.appointment.entity.Schedule;
import com.example.doctor.appointment.service.AppointmentDetailService;
import com.example.doctor.appointment.service.DepartmentService;
import com.example.doctor.appointment.service.DoctorService;
import com.example.doctor.appointment.service.ScheduleService;

@Controller
public class BookAppointmentController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private AppointmentDetailService appointmentDetailService;
	
	@GetMapping("/DoctorAppointment")
	public String showAppointmentDetail(@RequestParam("id")Integer doct_id, Model model) {
		
		List<Doctor> doctorList=doctorService.getDoctors();
		model.addAttribute("doctors",doctorList);
		List<Department> departmentList=departmentService.getDepartments();
		model.addAttribute("departments",departmentList);
		Doctor Doc=doctorService.getDoctor(doct_id);
		model.addAttribute("doc",Doc);
		
		return "Book Appointment/appointment_detail";
	}
	
	@GetMapping("/makeAppointment")
	public String showPatienDetail(@RequestParam("doctorId")Integer doct_id,@RequestParam("date")Date appointment_date,Model model) {
		
		List<Schedule> schedulelist=scheduleService.getSchedulesByDr_Date(doct_id,appointment_date);
		List<Schedule> scheduleList=new ArrayList<Schedule>();
		
		for(Schedule schedule:schedulelist) {
			List<AppointmentDetail> Appointments=schedule.getAppointmentDetails();
			int appointmentCount=Appointments.size();
			if(appointmentCount<3) {
				scheduleList.add(schedule);
			}
			
		}
		model.addAttribute("schedules",scheduleList);
		
		//To filter schedules
		/*SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
		String appointmentDate=simpleDateformat.format(appointment_date);
		model.addAttribute("appoint_Date",appointmentDate);
		model.addAttribute("appointment_Date",appointment_date);
		System.out.println(appointmentDate);*/	
		model.addAttribute("appointment",new AppointmentDetail());
		////
		return "Book Appointment/patient_Detail";
	}
	
	@PostMapping("/DoctorAppointment")
	public String saveAppointment(@RequestParam("scheduleId")Integer id,@ModelAttribute("appointment") @Valid AppointmentDetail appointment,BindingResult binding,RedirectAttributes redirectAttributes) {
		Schedule schedule=scheduleService.getSchedule(id);
		appointment.setSchedule(schedule);
		Doctor doctor=schedule.getDoctor();
		int doct_id=doctor.getId();
		Date date=schedule.getDate();
		
		if(binding.hasErrors()) {
			redirectAttributes.addAttribute("doctorId", doct_id);
			redirectAttributes.addAttribute("date", date);
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.appointment", binding);
			return "redirect:/makeAppointment";
		}
		
		String ph_no=appointment.getPhone_no();
		StringBuilder builder = new StringBuilder(ph_no); 
		builder.deleteCharAt(0);
		appointment.setPhone_no("+95"+builder);
	
		appointmentDetailService.saveAppointment(appointment);
		
		redirectAttributes.addAttribute("appointmentId", appointment.getId());
		return "redirect:/DoctorAppointment/Confirmation";
	}
	
	@GetMapping("DoctorAppointment/Confirmation")
	public String showConfirmationPage(@RequestParam("appointmentId")Integer id,Model model) {
		AppointmentDetail Appointment=appointmentDetailService.getAppointmentById(id);
		model.addAttribute("appointment",Appointment);
		return "Book Appointment/confirmation";
	}
	
}
