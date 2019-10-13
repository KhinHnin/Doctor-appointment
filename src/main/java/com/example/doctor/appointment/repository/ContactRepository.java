package com.example.doctor.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.doctor.appointment.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact ,Integer> {

}
