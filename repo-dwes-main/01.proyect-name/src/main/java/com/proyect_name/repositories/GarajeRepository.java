package com.proyect_name.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarajeRepository extends CrudRepository<Garaje, Long> {

}

