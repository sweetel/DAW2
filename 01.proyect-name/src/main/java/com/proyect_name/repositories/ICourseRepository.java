package com.proyect_name.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyect_name.models.Course;

@Repository
public interface ICourseRepository extends CrudRepository<Course, Integer>{
}
