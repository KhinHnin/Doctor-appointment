package com.example.doctor.appointment.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doctor.appointment.entity.AppointmentDetail;
import com.example.doctor.appointment.entity.Schedule;
import com.example.doctor.appointment.repository.AppointmentDetailRepository;

@Service
public class AppointmentDetailServiceImp implements AppointmentDetailService {
	@Autowired
	private AppointmentDetailRepository appointmentDetailRepository;
	
	@Override
	@Transactional
	public void saveAppointment(AppointmentDetail appointment) {
		appointmentDetailRepository.save(appointment);
		
	}

	@Override
	public List<AppointmentDetail> getAppointmentsBySchedule(Schedule schedule) {
		
		return appointmentDetailRepository.getAppointmentsBySchedule(schedule);
	}

	@Override
	public List<AppointmentDetail> getAppointments() {
		
		return appointmentDetailRepository.findAll();
	}

	@Override
	public AppointmentDetail getAppointmentById(Integer id) {
		
		return appointmentDetailRepository.getOne(id);
	}

	@Override
	public void deleteAppointment(Integer id) {
		appointmentDetailRepository.deleteById(id);
	}



}
