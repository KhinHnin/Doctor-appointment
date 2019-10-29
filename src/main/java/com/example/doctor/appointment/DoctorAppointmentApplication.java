package com.example.doctor.appointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DoctorAppointmentApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(DoctorAppointmentApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(DoctorAppointmentApplication.class);
	}
	
}
