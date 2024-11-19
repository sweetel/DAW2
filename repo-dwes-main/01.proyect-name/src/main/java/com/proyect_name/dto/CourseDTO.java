package com.proyect_name.dto;

import java.util.List;

import com.proyect_name.models.Course;

public class CourseDTO {
	private Integer id;
	private String name;

	public CourseDTO() {
		super();
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

	public static CourseDTO from(Course course) {
		CourseDTO courseDTO = new CourseDTO();

		courseDTO.setId(course.getId());
		courseDTO.setName(course.getName());

		return courseDTO;
	}

}
