package com.favores.service;

import com.favores.model.Favor;

public interface IFavorService {

    // Listar todos los favores
    Iterable<Favor> list();

    // Buscar un favor por su ID
    Favor findById(Long id);

    // Crear un nuevo favor
    Favor create(Favor favor);

    // Actualizar un favor existente
    Favor update(Long id, Favor favorUpdate);

    // Eliminar un favor
    Favor remove(Long id);
}
