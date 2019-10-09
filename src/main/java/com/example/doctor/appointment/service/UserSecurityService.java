package com.example.doctor.appointment.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.doctor.appointment.entity.AppUser;
import com.example.doctor.appointment.repository.UserRepository;


@Service
public class UserSecurityService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser=userRepository.findByUsername(username);
		
//		if(appUser!=null) {
//			List<GrantedAuthority> authorities=new ArrayList<>();
//			List<Role> roles=appUser.getRoles();
//			for(Role role:roles) {
//				GrantedAuthority authority=new SimpleGrantedAuthority("ROLE_"+role.getRole());
//				authorities.add(authority);
//			}
//			User user=new User(appUser.getUsername(),appUser.getPassword(),authorities);
//			return user;
//		}else {
//			throw new UsernameNotFoundException(username);
//		}
		
		if(appUser!=null) {
			return appUser;
		}else {
			throw new UsernameNotFoundException("User not found");
		}
	}

}
