package com.personas.apiRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personas.apiRest.entity.PersonaEntity;
import com.personas.apiRest.service.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/lista")
	public ResponseEntity<List<PersonaEntity>> listaPersonas(){
		List<PersonaEntity> lista = personaService.getListaPersonas();
		return new ResponseEntity(lista,HttpStatus.OK);
	}

}
