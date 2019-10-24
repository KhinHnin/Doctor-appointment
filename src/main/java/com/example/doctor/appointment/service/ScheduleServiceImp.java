package com.example.doctor.appointment.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doctor.appointment.entity.Doctor;
import com.example.doctor.appointment.entity.Schedule;
import com.example.doctor.appointment.repository.ScheduleRepository;

@Service
public class ScheduleServiceImp implements ScheduleService{
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Override
	@Transactional
	public void saveSchedule(Schedule schedule) {
		scheduleRepository.save(schedule);
		
	}

	@Override
	@Transactional
	public List<Schedule> getSchedules() {
		return scheduleRepository.findAll();
	}

	@Override
	public Schedule getSchedule(Integer schedule_id) {
		Optional<Schedule> optional=scheduleRepository.findById(schedule_id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new RuntimeException("Schedule not found");
		}
	
	}

	@Override
	public void deleteScheduleById(Integer sche_id) {
		scheduleRepository.deleteById(sche_id);
	}

	@Override
	public List<Schedule> getSchedulesByDoctor(Doctor doc) {
		// TODO Auto-generated method stub
		return scheduleRepository.getScheduleByDoctor(doc);
	}
		
}


