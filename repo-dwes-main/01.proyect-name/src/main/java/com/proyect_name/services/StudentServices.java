package com.proyect_name.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyect_name.models.Course;
import com.proyect_name.models.Student;
import com.proyect_name.repositories.IStudentRepository;

@Service
public class StudentServices implements IStudentServices {

	@Autowired
	private IStudentRepository studentRepository;

	@Override
	public Iterable<Student> list() {
		Iterable<Student> list = this.studentRepository.findAll();
		return list;
	}

	@Override
	public Student findby(String dni) {
		Student student = this.studentRepository.findByDni(dni);
		return student;
	}

	@Override
	public Student create(Student student) {
		this.studentRepository.save(student);
		return student;
	}

	@Override
	public Student update(String dni, Student studentUpdate) {
		Student student = this.studentRepository.findByDni(dni);

		if(student == null) {
			return null;
		}

		student.setName(studentUpdate.getName());
		student.setLastName(studentUpdate.getLastName());
		
		this.studentRepository.save(student);
		
		return student;
	}
	
	@Override
	public Student remove(String dni) {
		Student student = this.studentRepository.findByDni(dni);

		if(student == null) {
			return null;
		}

		this.studentRepository.delete(student);
		
		return student;
	}

	@Override
	public Student addCourse(Integer studentId, Course course) {
		Optional<Student> studentOptional = this.studentRepository.findById(studentId);

		if(studentOptional.isEmpty()) {
			return null;
		}
		Student student = studentOptional.get();

		student.addCourse(course);
		
		this.studentRepository.save(student);
		
		return student;
	}
}
