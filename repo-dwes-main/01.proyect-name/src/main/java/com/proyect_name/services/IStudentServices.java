package com.proyect_name.services;

import com.proyect_name.models.Course;
import com.proyect_name.models.Student;

public interface IStudentServices {
	Iterable<Student> list();
	Student findby(String dni);
	Student create(Student student);
	Student update(String dni, Student student);
	Student remove(String dni);
	Student addCourse(Integer studentId, Course course);
}
