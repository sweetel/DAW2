package com.favores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.favores.model.Favor;

public interface IFavorRepository extends JpaRepository<Favor, Long> {
}
