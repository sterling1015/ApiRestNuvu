package com.personas.apiRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.personas.apiRest.entity.PersonaEntity;
import com.personas.apiRest.repository.PersonaRepository;

@Service
@Transactional
public class PersonaService {
	
	@Autowired
	private PersonaRepository personaRepository;

	public List<PersonaEntity> getListaPersonas() {
		return personaRepository.findAll();
	}

}
