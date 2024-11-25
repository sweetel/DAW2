package com.proyect_name.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyect_name.dto.StudentDTO;
import com.proyect_name.models.Student;
import com.proyect_name.services.IStudentServices;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private IStudentServices studentServices;
	
	@GetMapping("/list")
	
	public ResponseEntity<?> list() {
		try {
			Iterable<Student> listStudents = this.studentServices.list();
			return ResponseEntity.ok(listStudents);
		}
		catch(Exception ex) {
			return ResponseEntity.internalServerError()
					.body("error al obtener todos los elementos");
		}
	}
	
	@GetMapping("/by")
	public ResponseEntity<?> bydni(@RequestParam String dni) {
		try {
			Student student = this.studentServices.findby(dni);
			if(student == null) {
				return ResponseEntity.badRequest()
						.body("Not found");
			}
			
			StudentDTO studentDTO = StudentDTO.from(student);
			
			return ResponseEntity.ok(studentDTO);
		}
		catch(Exception ex) {
			return ResponseEntity.internalServerError()
					.body("error al buscar por dni");
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Student newStudent) {
		try {
			Student student = studentServices.create(newStudent);
			
			return ResponseEntity.ok(student);
		}
		catch(Exception ex) {
			return ResponseEntity.internalServerError()
					.body("error al crear");
		}
	}
	
	@PutMapping("/update/{dni}")
	public ResponseEntity<?> update(@PathVariable String dni,
			@RequestBody Student updateStudent) {
		try {
			Student student = this.studentServices.update(dni, updateStudent);
			if(student == null) {
				return ResponseEntity.badRequest()
						.body("Not found");
			}
			
			return ResponseEntity.ok(student);
		}
		catch(Exception ex) {
			return ResponseEntity.internalServerError()
					.body("error al actualizar");
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam String dni) {
		try {
			Student student = this.studentServices.remove(dni);
			
			return ResponseEntity.ok(student);
		}
		catch(Exception ex) {
			return ResponseEntity.internalServerError()
					.body("error al eliminar");
		}
	}
}
