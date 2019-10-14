package com.example.doctor.appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.doctor.appointment.entity.Contact;
import com.example.doctor.appointment.repository.DepartmentRepository;
import com.example.doctor.appointment.repository.DoctorRepository;
import com.example.doctor.appointment.service.ContactService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private ContactService contactService;

	@GetMapping
	public String showAdmin(Model model) {
		long departCount=departmentRepository.count();
		long doctorCount=doctorRepository.count();
		
		model.addAttribute("departCount",departCount);
		model.addAttribute("doctorCount",doctorCount);
		return "admin/admin";
	}
	@GetMapping("/contactList")
	public String showContact(Model model) {
		List<Contact> contact=contactService.getContacts();
		model.addAttribute("contacts",contact);
        return "admin/contact_list";
}
	
	@GetMapping("/contactList/delete")
	public String deleteDoctor(@RequestParam("id")Integer con_id) {
		contactService.deleteContact(con_id);
		return "redirect:";
	}
}
