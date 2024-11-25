package com.proyect_name.models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String dni;
	private String name;
	private String lastName;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Course> courses;
	
	

	public Student() {
		super();
	}

	public Student(String dni, String name, String lastName) {
		super();
		this.dni = dni;
		this.name = name;
		this.lastName = lastName;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
		course.setStudent(this);
	}
	
	public Set<Course> getCourses() {
		return courses;
	}
	
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
		
	}
}
