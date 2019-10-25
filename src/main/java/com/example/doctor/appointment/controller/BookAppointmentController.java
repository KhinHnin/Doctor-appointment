package com.example.doctor.appointment.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
	
	List<Schedule> scheduleList=new ArrayList<Schedule>();
	/*@GetMapping
	public String bookAppointment(@RequestParam("id")Integer doct_id, Model model) {
	
		List<Doctor> doctorList=doctorService.getDoctors();
		model.addAttribute("doctors",doctorList);
		List<Department> departmentList=departmentService.getDepartments();
		model.addAttribute("departments",departmentList);
		Doctor Doc=doctorService.getDoctor(doct_id);
		model.addAttribute("doc",Doc);
		
		//AppointmentCount Validation
		List<Schedule> scheduleList=scheduleService.getSchedules();
		/*for(Schedule schedule:scheduleList) {
			List<AppointmentDetail> Appointments=appointmentDetailService.getAppointmentsBySchedule(schedule);
			if(Appointments.size()<3) {
				schedulelist.add(schedule);
			}
		}
		if(schedulelist.size()==0) {
			System.out.println(schedulelist.size());
			return "schedule_empty";
		}else {
			model.addAttribute("schedules",scheduleList);
		//////
		
		model.addAttribute("appointment",new AppointmentDetail());
		return "Book Appointment/appointment_detail";
	}*/
	
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
		
		Doctor Doc=doctorService.getDoctor(doct_id);
		model.addAttribute("doc",Doc);
		List<Schedule> schedulelist=scheduleService.getSchedulesByDoctor(Doc);
		
		for(Schedule schedule:schedulelist) {
			List<AppointmentDetail> Appointments=appointmentDetailService.getAppointmentsBySchedule(schedule);
			int appointmentCount=Appointments.size();
			if(appointmentCount<3) {
				
				scheduleList.add(schedule);
			}
		}
		model.addAttribute("schedules",scheduleList);
		
		//To filter schedules
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
		String appointmentDate=simpleDateformat.format(appointment_date);
		model.addAttribute("appoint_Date",appointmentDate);
		model.addAttribute("appointment_Date",appointment_date);
		model.addAttribute("appointment",new AppointmentDetail());
		System.out.println(appointmentDate);	
		
		////
		return "Book Appointment/patient_Detail";
	}
	
	@PostMapping("/DoctorAppointment")
	public String saveAppointment(@RequestParam("scheduleId")Integer id,@ModelAttribute("appointment") @Valid AppointmentDetail appointment,BindingResult result,RedirectAttributes redirAttr,Model model) {
		Schedule schedule=scheduleService.getSchedule(id);
		appointment.setSchedule(schedule);
		Doctor doc=schedule.getDoctor();
		int doc_id=doc.getId();
	    Date date=schedule.getDate();

		if(result.hasErrors()) {
			redirAttr.addAttribute("doctorId",doc_id);
			redirAttr.addAttribute("date",date);
			List<ObjectError> errors=result.getAllErrors();
			redirAttr.addFlashAttribute("errors",errors);
			return "redirect:/makeAppointment";
			
		}
		
		
		appointmentDetailService.saveAppointment(appointment);
		return "redirect:";
	}
}
