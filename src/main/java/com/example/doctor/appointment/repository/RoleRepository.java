package com.example.doctor.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doctor.appointment.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
