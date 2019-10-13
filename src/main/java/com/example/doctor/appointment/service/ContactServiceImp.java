package com.example.doctor.appointment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doctor.appointment.entity.Contact;
import com.example.doctor.appointment.repository.ContactRepository;

@Service
public class ContactServiceImp implements ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public void saveContact(Contact contact) {
		contactRepository.save(contact);
		
		
	}

	@Override
	public List<Contact> getContacts() {
		
		return contactRepository.findAll();
	}

	@Override
	public void deleteContact(Integer id) {
		contactRepository.deleteById(id);
		
	}

}
