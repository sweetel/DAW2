package com.cbs.proyecto1.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbs.proyecto1.dto.StudentDTO;
@RestController

public class StudenController {
	
	private List<StudentDTO> studentList;

	public StudenController() {
		studentList = new ArrayList<StudentDTO>();
		studentList.add(new StudentDTO("Pepe", "Roca"));
	}
	
	@GetMapping("/student/add")
	public List<StudentDTO> add() {
		studentList.add(new StudentDTO("alfonso", "perez"));
		return studentList;
	}
}
