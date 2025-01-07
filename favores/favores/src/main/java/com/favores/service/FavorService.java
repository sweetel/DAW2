package com.favores.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.favores.model.Favor;
import com.favores.repository.IFavorRepository;

@Service
public class FavorService implements IFavorService {

    @Autowired
    private IFavorRepository favorRepository;

    // Listar todos los favores
    public Iterable<Favor> list() {
        return this.favorRepository.findAll();
    }

    // Buscar un favor por su ID
    public Favor findById(Long id) {
        Optional<Favor> favor = this.favorRepository.findById(id);
        return favor.orElse(null);
    }

    // Crear un nuevo favor
    public Favor create(Favor favor) {
        return this.favorRepository.save(favor);
    }

    // Actualizar un favor existente
    public Favor update(Long id, Favor favorUpdate) {
        Optional<Favor> favorOptional = this.favorRepository.findById(id);

        if (favorOptional.isEmpty()) {
            return null;
        }

        Favor favor = favorOptional.get();
        favor.setTitular(favorUpdate.getTitular());
        favor.setCategoria(favorUpdate.getCategoria());
        favor.setAutor(favorUpdate.getAutor());
        favor.setImagen(favorUpdate.getImagen());
        favor.setTexto(favorUpdate.getTexto());
        // Otros campos que se necesiten actualizar

        return this.favorRepository.save(favor);
    }

    // Eliminar un favor
    public Favor remove(Long id) {
        Optional<Favor> favorOptional = this.favorRepository.findById(id);

        if (favorOptional.isEmpty()) {
            return null;
        }

        Favor favor = favorOptional.get();
        this.favorRepository.delete(favor);

        return favor;
    }
}
