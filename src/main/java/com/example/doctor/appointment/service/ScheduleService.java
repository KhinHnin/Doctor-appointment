package com.example.doctor.appointment.service;


<<<<<<< HEAD
=======
import java.util.Date;
>>>>>>> 36640e1dece7d0ad98c02e71e2e48483e4404823
import java.util.List;

import com.example.doctor.appointment.entity.Doctor;
import com.example.doctor.appointment.entity.Schedule;

public interface ScheduleService {
	public void saveSchedule(Schedule schedule);

	public List<Schedule> getSchedules();

	public Schedule getSchedule(Integer schedule_id);

	public void deleteScheduleById(Integer sche_id);

	public List<Schedule> getSchedulesByDoctor(Doctor doc);

	public List<Schedule> getSchedulesByDr_Date(Integer doct_id, java.util.Date appointment_date);
}
