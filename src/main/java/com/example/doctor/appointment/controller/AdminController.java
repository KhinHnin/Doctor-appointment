package com.example.doctor.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.doctor.appointment.service.DoctorService;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping
	public String showAdminPage(Model model) {
		return "admin/admin";
	}
}
