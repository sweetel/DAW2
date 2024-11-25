package com.proyect_name.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyect_name.models.Course;
import com.proyect_name.repositories.ICourseRepository;

@Service
public class CourseService implements ICourseService {
	
	@Autowired
	private ICourseRepository courseRepository;

	@Override
	public Course byId(Integer id) {

		Optional<Course> course = this.courseRepository.findById(id);
		if(course.isEmpty()) {
			return null;
		}
		return course.get();
	}
}
