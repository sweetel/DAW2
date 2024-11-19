package com.proyect_name.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect_name.models.Course;
import com.proyect_name.models.Student;
import com.proyect_name.services.IStudentServices;

@RestController
@RequestMapping("/student/course")
public class StudentCourseController {

	@Autowired
	private IStudentServices studentServices;

	@PostMapping("/create/{studentId}")
	public ResponseEntity<?> create(@PathVariable Integer studentId, @RequestBody Course course) {
		try {
			Student student = studentServices.addCourse(studentId, course);
			
			return ResponseEntity.ok(student);
		}
		catch(Exception ex) {
			return ResponseEntity.internalServerError()
					.body("error al crear");
		}
	}
}
