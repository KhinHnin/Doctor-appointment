package com.example.doctor.appointment.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
import com.example.doctor.appointment.smsSending.Service;
import com.example.doctor.appointment.smsSending.SmsRequest;

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
	
	@Autowired
	private Service service;
	
	@GetMapping("/DoctorAppointment")
	public String showAppointmentDetail(@RequestParam("id")Integer doct_id, Model model) {
		
		List<Doctor> doctorList=doctorService.getDoctors();
		model.addAttribute("doctors",doctorList);
		List<Department> departmentList=departmentService.getDepartments();
		model.addAttribute("departments",departmentList);
		Doctor Doc=doctorService.getDoctor(doct_id);
		model.addAttribute("doc",Doc);
		List<Schedule> scheduleList=scheduleService.getSchedules();
		List<Schedule> schedulelist=new ArrayList<Schedule>();
		for(Schedule schedule:scheduleList) {
			List<AppointmentDetail> appointments=schedule.getAppointmentDetails();
			if(appointments.size()<3) {
				schedulelist.add(schedule);
			}
		}
		model.addAttribute("schedules", schedulelist);
		
		return "Book Appointment/appointment_detail";
	}
	
	@GetMapping("/makeAppointment")
	public String showPatienDetail(@RequestParam("doctorId")Integer doct_id,@RequestParam("date")String appointment_date,Model model) {
		
		List<Schedule> schedulelist=scheduleService.getSchedulesByDr_Date(doct_id,appointment_date);
		List<Schedule> scheduleList=new ArrayList<Schedule>();
		
		for(Schedule schedule:schedulelist) {
			List<AppointmentDetail> Appointments=schedule.getAppointmentDetails();
			int appointmentCount=Appointments.size();
			if(appointmentCount<3) {
				scheduleList.add(schedule);
			}
			
		}
		
		if(scheduleList.size()!=0) {
			model.addAttribute("schedules",scheduleList);
			
			
			model.addAttribute("appointment",new AppointmentDetail());

			return "Book Appointment/patient_Detail";
		}else {
			return "empty_schedule";
		}
		
	}
		
	@PostMapping("/DoctorAppointment")
	public String saveAppointment(@RequestParam("scheduleId")Integer id,@ModelAttribute("appointment") @Valid AppointmentDetail appointment,BindingResult binding,RedirectAttributes redirectAttributes) {
		Schedule schedule=scheduleService.getSchedule(id);
		appointment.setSchedule(schedule);
		Doctor doctor=schedule.getDoctor();
		int doct_id=doctor.getId();
		String date=schedule.getDate();
		
		if(binding.hasErrors()) {
			redirectAttributes.addAttribute("doctorId", doct_id);
			redirectAttributes.addAttribute("date", date);
			redirectAttributes.addFlashAttribute("errors", binding.getAllErrors());
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
	
	@GetMapping("/CancelAppointment")
	public String cancelAppointment(@RequestParam("id")Integer appointment_id,@ModelAttribute("appointment")AppointmentDetail appointment,RedirectAttributes redirectAttributes) {
		appointmentDetailService.deleteAppointment(appointment_id);
		//redirectAttributes.addAttribute("id",appointment.getSchedule().getDoctor().getId());
		return  "redirect:";
	}
	
	@GetMapping("/SmsConfirmation")
	public String sendSms(@RequestParam("id")Integer appointmentId,Model model) {
		SmsRequest smsRequest = new SmsRequest();
		AppointmentDetail appointment=appointmentDetailService.getAppointmentById(appointmentId);
		Schedule schedule=appointment.getSchedule();
		int tokenNo = 0;
		List<AppointmentDetail> appointmentList=appointmentDetailService.getAppointmentsBySchedule(schedule);
		for(AppointmentDetail appoint:appointmentList) {
			if(appoint.getId()==appointment.getId())
			{
				tokenNo=appointmentList.indexOf(appoint);
				tokenNo+=1;
			}
		}
		smsRequest.setPhoneNumber(appointment.getPhone_no());
		String message="\nToken No:"+tokenNo+"\nAppointment ID:"+appointment.getId()+"\nDoctor-Name: "+appointment.getSchedule().getDoctor().getName()+"\nDate : "+appointment.getSchedule().getDate()+"\nTime : "+appointment.getSchedule().getFromTime()+"-"+appointment.getSchedule().getToTime();
		smsRequest.setMessage(message);
		service.sendSms(smsRequest);
		
		return "redirect:";
	}
	
}
