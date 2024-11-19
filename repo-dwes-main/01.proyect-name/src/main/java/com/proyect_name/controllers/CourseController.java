package com.proyect_name.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.proyect_name.models.Course;
import com.proyect_name.services.ICourseService;

@RestController
public class CourseController {
	
	@Autowired
	private ICourseService courseService;
	
	@GetMapping("/course/{id}")
	public  ResponseEntity<?> byId(@PathVariable Integer id){
		try {
			Course course = this.courseService.byId(id);
			if(course == null) {
				return ResponseEntity.badRequest().body("no encontrado el id");
			}
		} catch(Exception e) {
			return ResponseEntity.internalServerError().body("Error al obtener id");
		}
		return null;
	}
}
