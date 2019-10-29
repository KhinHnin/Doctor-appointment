package com.example.doctor.appointment.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.doctor.appointment.entity.Doctor;
import com.example.doctor.appointment.entity.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{

	List<Schedule> getScheduleByDoctor(Doctor doc);
	

	@Query("SELECT schedule FROM Schedule schedule WHERE schedule.doctor.id = ?1 and schedule.date = ?2")
	List<Schedule> getSchedulesByDr_Date(Integer doct_id, String appointment_date);

}
