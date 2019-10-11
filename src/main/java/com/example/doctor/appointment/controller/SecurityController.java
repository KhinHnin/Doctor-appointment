package com.example.doctor.appointment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

	@GetMapping("/showLogin")
	public String showLogin() {
		return "login-form";
	}

	@GetMapping("/403")
	public String showAcessDenied() {
		return "403";
	}
}
