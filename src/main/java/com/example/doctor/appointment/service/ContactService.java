package com.example.doctor.appointment.service;

import java.util.List;

import com.example.doctor.appointment.entity.Contact;

public interface ContactService {
	
	public void saveContact(Contact contact);
	public List<Contact> getContacts();
	public void deleteContact(Integer id);

}
