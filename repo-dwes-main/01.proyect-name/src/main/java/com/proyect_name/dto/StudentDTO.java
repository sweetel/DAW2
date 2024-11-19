package com.proyect_name.dto;

import java.util.ArrayList;
import java.util.List;

import com.proyect_name.models.Course;
import com.proyect_name.models.Student;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class StudentDTO {
	
	    private Integer id;
		private String dni;
		private String name;
		private String lastName;
		private List<CourseDTO> courses;
		
		public StudentDTO() {
			super();
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
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

		public List<CourseDTO> getCourses() {
			return courses;
		}

		public void setCourses(List<CourseDTO> courses) {
			this.courses = courses;
		}
		
		public static StudentDTO from (Student student) {
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setId(student.getId());
			studentDTO.setDni(student.getDni());;
			studentDTO.setName(student.getName());
			studentDTO.setLastName(student.getLastName());
			List<CourseDTO> courses = new ArrayList<CourseDTO>();
			for(Course c : student.getCourses()) {
				CourseDTO courseDTO = CourseDTO.from(c);
				courses.add(courseDTO);
			}
			
			studentDTO.setCourses(courses);
			return studentDTO;
		}
}
