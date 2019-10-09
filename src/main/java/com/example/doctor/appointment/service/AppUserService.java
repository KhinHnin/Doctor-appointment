package com.example.doctor.appointment.service;

import java.util.List;

import com.example.doctor.appointment.entity.AppUser;

public interface AppUserService {

	public void createAppUser(AppUser appUser);

	public AppUser loadUserByUsername(String name);

	public List<AppUser> getUsers();

	public Long getCount();

}
