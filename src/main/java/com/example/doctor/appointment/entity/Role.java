package com.example.doctor.appointment.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="role")
	private String role;
	
	@ManyToMany
	@JoinTable(name="users_roles",
	           joinColumns=@JoinColumn(name="role_id"),
	           inverseJoinColumns=@JoinColumn(name="user_id"))
	private List<AppUser> users;
	
	public Role(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public Role(String role) {
		super();
		this.role = role;
	}

	public Role() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
}
