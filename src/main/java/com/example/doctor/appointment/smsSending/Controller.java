package com.example.doctor.appointment.smsSending;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.doctor.appointment.entity.AppointmentDetail;
import com.example.doctor.appointment.service.AppointmentDetailService;

@RestController
public class Controller {
	
	private final Service service;
	
	@Autowired
	private AppointmentDetailService appointmentDetailService;
	
	@Autowired
	public Controller(Service service) {
		this.service = service;
	}
	
	@GetMapping("DoctorAppointment/SmsConfirmation")
	public void sendSms(@RequestParam("id")Integer appointmentId,Model model) {
		SmsRequest smsRequest = new SmsRequest();
		AppointmentDetail appointment=appointmentDetailService.getAppointmentById(appointmentId);
		smsRequest.setPhoneNumber(appointment.getPhone_no());
		String message="Doctor-Name: "+appointment.getSchedule().getDoctor().getName()+"\nDate : "+appointment.getSchedule().getDate()+"\nTime : "+appointment.getSchedule().getFromTime()+"-"+appointment.getSchedule().getToTime();
		smsRequest.setMessage(message);
		service.sendSms(smsRequest);
	}
	
}
