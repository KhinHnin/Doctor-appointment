package com.example.doctor.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.doctor.appointment.entity.AppUser;
import com.example.doctor.appointment.service.AppUserService;

@Controller
public class SecurityController {
	@Autowired
	private AppUserService appUserService;
	
	@GetMapping("/showLogin")
	public String showLogin() {
		return "login-form";
	}
	
	@GetMapping("/403")
	public String showAcessDenied(){
		return "403";
	}
}
