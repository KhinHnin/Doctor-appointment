package com.example.doctor.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.doctor.appointment.entity.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {

	AppUser findByUsername(String name);

}
