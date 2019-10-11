package com.example.doctor.appointment.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doctor.appointment.entity.Days;
import com.example.doctor.appointment.repository.DayRepository;

@Service
public class DaysServiceImp implements DaysService{
	@Autowired
	private DayRepository dayRepository;

	@Override
	@Transactional
	public List<Days> getDays() {
		return dayRepository.findAll();
	}

	@Override
	@Transactional
	public Days getDay(Integer day_id) {
		return dayRepository.getOne(day_id);
	}

	
}
