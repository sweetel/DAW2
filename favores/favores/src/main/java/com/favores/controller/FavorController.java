package com.favores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.favores.model.Favor;
import com.favores.service.FavorService;

@RestController
@RequestMapping("/favores")
public class FavorController {

    @Autowired
    private FavorService favorService;

    // Obtener todos los favores
    @GetMapping
    public ResponseEntity<List<Favor>> list() {
        List<Favor> favores = (List<Favor>) favorService.list();
        return ResponseEntity.ok(favores);
    }

    // Obtener un favor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Favor> findById(@PathVariable Long id) {
        Favor favor = favorService.findById(id);
        if (favor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(favor);
    }

    // Crear un nuevo favor
    @PostMapping
    public ResponseEntity<Favor> create(@RequestBody Favor favor) {
        Favor createdFavor = favorService.create(favor);
        return ResponseEntity.ok(createdFavor);
    }

    // Actualizar un favor existente
    @PutMapping("/{id}")
    public ResponseEntity<Favor> update(@PathVariable Long id, @RequestBody Favor favorUpdate) {
        Favor updatedFavor = favorService.update(id, favorUpdate);
        if (updatedFavor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedFavor);
    }

    // Eliminar un favor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        Favor deletedFavor = favorService.remove(id);
        if (deletedFavor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
