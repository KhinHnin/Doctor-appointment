package com.example.doctor.appointment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService; 
	

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

  
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
			/*http.authorizeRequests()
			.antMatchers("/admin/**").authenticated()
			.anyRequest().permitAll();*/
		
		http.csrf().disable();
		
		
		http.authorizeRequests()
		//    .anyRequest().permitAll();
			 .antMatchers("/css/**","/js/**","/images/**","/favicon.ico").permitAll()
		     .antMatchers("/admin/**").hasRole("ADMIN")
		     .anyRequest().permitAll()
		     .and()
		     .formLogin()
		     .loginPage("/showLogin")
		     .loginProcessingUrl("/processLogin")
		     .and()
		     .exceptionHandling().accessDeniedPage("/403");		
		
	}
	 
}
