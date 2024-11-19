package com.proyect_name.repositories;

import org.springframework.data.repository.CrudRepository;

import com.proyect_name.models.Student;

public interface IStudentRepository extends CrudRepository<Student, Integer> {
	Student findByDni(String dni);
}
