package com.example.doctor.appointment.repository;

<<<<<<< HEAD
=======

>>>>>>> 36640e1dece7d0ad98c02e71e2e48483e4404823
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
	List<Schedule> getSchedulesByDr_Date(Integer doct_id, Date appointment_date);

}
