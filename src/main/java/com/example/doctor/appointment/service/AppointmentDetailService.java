package com.example.doctor.appointment.service;

import java.util.List;

import com.example.doctor.appointment.entity.AppointmentDetail;
import com.example.doctor.appointment.entity.Schedule;

public interface AppointmentDetailService {

	void saveAppointment(AppointmentDetail appointment);

	List<AppointmentDetail> getAppointmentsBySchedule(Schedule schedule);

	List<AppointmentDetail> getAppointments();

	AppointmentDetail getAppointmentById(Integer id);
}
