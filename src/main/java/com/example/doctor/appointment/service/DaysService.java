package com.example.doctor.appointment.service;

import java.util.List;

import com.example.doctor.appointment.entity.Days;

public interface DaysService {
	
	public List<Days> getDays();

	public Days getDay(Integer day_id);

}
