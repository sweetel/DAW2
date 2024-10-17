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
	public List<PersonaDTO> personList() {

		return personList;

	}

	@PostMapping("/persons/add")
	public List<PersonaDTO> personsAdd(@RequestBody PersonaDTO personDTO) {

		// this.personList.add(new PersonDTO("1344456T", "Paco", "Carmona", 23,
		// "lesbiano"));
		// this.personList.add(new PersonDTO("654981054F", "Eduardo", "Gómez", 18,
		// "gay"));
		// this.personList.add(new PersonDTO("9087536X", "Joan", "Sánchez", 4,
		// "desconocido"));

		this.personList.add(personDTO);

		return personList;

	}

	@PostMapping("/persons/update")
	public List<PersonaDTO> personsUpdate(@RequestBody PersonaDTO personDTO) {

		for (PersonaDTO person : personList) {

			if (person.getDNI().equals(personDTO.getDNI())) {

				person.setNombre(personDTO.getNombre());
				person.setApellido(personDTO.getApellido());
				person.setEdad(personDTO.getEdad());
				person.setSexo(personDTO.getSexo());
			}

		}

		return personList;
	}

	@DeleteMapping("/persons/delete")
	public ResponseEntity<?> delete(@RequestBody PersonaDTO personDelete) {

		PersonaDTO PersonAux = null;
		try {
		for (PersonaDTO personDTO : personList) {
			if (personDelete.getDNI().equals(personDTO.getDNI())) {
				PersonAux = personDTO;
			}
		}

		if (null != PersonAux) {
			personList.remove(PersonAux);
			return ResponseEntity.ok(personList);
		}

		else {
			return ResponseEntity.badRequest().body("usuario no encontrado");
		}
		} catch(Exception ex) {
			return ResponseEntity.internalServerError().body("error al procesar el delete");
		}

	} 

}