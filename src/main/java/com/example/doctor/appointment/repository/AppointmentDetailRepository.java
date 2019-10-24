package com.example.doctor.appointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doctor.appointment.entity.AppointmentDetail;
import com.example.doctor.appointment.entity.Schedule;

public interface AppointmentDetailRepository extends JpaRepository<AppointmentDetail,Integer>{

	List<AppointmentDetail> getAppointmentsBySchedule(Schedule schedule);

}
