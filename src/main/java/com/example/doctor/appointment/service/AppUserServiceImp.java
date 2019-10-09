package com.example.doctor.appointment.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.doctor.appointment.entity.AppUser;
import com.example.doctor.appointment.entity.Role;
import com.example.doctor.appointment.repository.RoleRepository;
import com.example.doctor.appointment.repository.UserRepository;

@Service
public class AppUserServiceImp implements AppUserService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public void createAppUser(AppUser user) {
		
		Role adminRole=roleRepository.getOne(2);
		
		user.addRole(adminRole);
		
		String pass=user.getPassword();
		String encodedPass=passwordEncoder.encode(pass);
		
		user.setPassword(encodedPass);
		
		
		userRepository.save(user);
	}
	@Override
	@Transactional
	public AppUser loadUserByUsername(String name) {
		return userRepository.findByUsername(name);
	}
	
	@Override
	public Long getCount() {
		return userRepository.count();
	}
	@Override
	public List<AppUser> getUsers() {
		return userRepository.findAll();
	}

}
