package com.example.doctor.appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.doctor.appointment.entity.Contact;
import com.example.doctor.appointment.service.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contactus")
	public String showContactForm(Model model) {
		
		model.addAttribute("contact",new Contact());
		return "contact";
	}
	
	@PostMapping
	public String saveContact(@ModelAttribute("contact")Contact contact) {
		contactService.saveContact(contact);
		return "redirect:";
	}
	
	

}
