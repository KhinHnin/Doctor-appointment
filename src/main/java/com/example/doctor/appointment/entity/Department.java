

package com.example.doctor.appointment.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="departments")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name="name")
	private String name;
<<<<<<< HEAD
	@Column(name = "image")
	private String image;
=======
	@OneToMany(mappedBy = "department")	
    private	List<Doctor> doctors;
>>>>>>> 36640e1dece7d0ad98c02e71e2e48483e4404823
	
	public Department(int id, String name, String image) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Department(String name) {
		super();
		this.name = name;
	}
	
	public Department() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
