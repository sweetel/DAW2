package com.example.example_auth.model.respositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.example_auth.model.entities.UserEntity;

public interface IUserRepository
	extends CrudRepository<UserEntity, Integer> {

	Optional<UserEntity> findByName(String name);
}
