package com.cbs.proyecto1.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cbs.proyecto1.dto.PersonaDTO;

@RestController
public class PersonController {

    private List<PersonaDTO> personList;

    public PersonController() {
        this.personList = new ArrayList<>();
        this.personList.add(new PersonaDTO("654981054F", "Eduardo", "Gómez", "18", "gay"));
    }

    @GetMapping("/persons/list")
    public ResponseEntity<?> personList() {
        try {
            return ResponseEntity.ok(personList);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Error al obtener todos los elementos");
        }
    }
    
    @GetMapping("/persons/bydni")
    public ResponseEntity<?> bydni(@RequestBody PersonaDTO personFind) {
        try {
            if (personFind == null || personFind.getDNI() == null) {
                return ResponseEntity.badRequest().body("Datos de entrada no válidos");
            }

            PersonaDTO person = null;

            for (PersonaDTO item : personList) {
                if (item.getDNI().equals(personFind.getDNI())) {
                    person = item;
                    break; 
                }
            }

            if (person == null) {
                return ResponseEntity.status(404).body("Usuario no encontrado");
            } else {
                return ResponseEntity.ok(person); 
            }
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Error al procesar la solicitud");
        }
    }


    @PostMapping("/persons/add")
    public ResponseEntity<?> personsAdd(@RequestBody PersonaDTO personDTO) {
        try {
            if (personDTO == null) {
                return ResponseEntity.badRequest().body(null);
            }
            personList.add(personDTO);
            return ResponseEntity.ok(personList);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Error al añadir la persona");
        }
    }

    @PostMapping("/persons/update")
    public ResponseEntity<?> personsUpdate(@RequestBody PersonaDTO personDTO) {
        try {
            if (personDTO == null || personDTO.getDNI() == null) {
                return ResponseEntity.badRequest().body("La persona introducida es null");
            }

            for (PersonaDTO person : personList) {
                if (person.getDNI().equals(personDTO.getDNI())) {
                    person.setNombre(personDTO.getNombre());
                    person.setApellido(personDTO.getApellido());
                    person.setEdad(personDTO.getEdad());
                    person.setSexo(personDTO.getSexo());
                    return ResponseEntity.ok(personList);
                }
            }
            return ResponseEntity.badRequest().body(null);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Error al actualizar");
        }
    }

    @DeleteMapping("/persons/delete")
    public ResponseEntity<?> delete(@RequestBody PersonaDTO personDelete) {
        try {
            if (personDelete == null || personDelete.getDNI() == null) {
                return ResponseEntity.badRequest().body("Datos de entrada no válidos");
            }

            PersonaDTO personAux = null;

            for (PersonaDTO personDTO : personList) {
                if (personDelete.getDNI().equals(personDTO.getDNI())) {
                    personAux = personDTO;
                    break;
                }
            }

            if (personAux != null) {
                personList.remove(personAux);
                return ResponseEntity.ok(personList);
            } else {
                return ResponseEntity.badRequest().body("Usuario no encontrado");
            }
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Error al borrar a la persona");
        }
    }
}
