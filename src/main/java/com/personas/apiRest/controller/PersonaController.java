package com.personas.apiRest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personas.apiRest.dto.Mensaje;
import com.personas.apiRest.dto.PersonaDto;
import com.personas.apiRest.entity.PersonaEntity;
import com.personas.apiRest.service.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {

	Map<String, Object> response = new HashMap<String, Object>();

	@Autowired
	private PersonaService personaService;
	
	/**
	 * Metodo encargado de obtener la lista de las personas registradas en BD
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/lista")
	public ResponseEntity<List<PersonaEntity>> listaPersonas() {
		List<PersonaEntity> lista = personaService.getListaPersonas();
		return new ResponseEntity(lista, HttpStatus.OK);
	}

	/**
	 * Metodo encargado de crear un nuevo registro en BD
	 * @param personaDto
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody PersonaDto personaDto) {

		PersonaEntity personaNueva = new PersonaEntity();

		try {
			personaNueva.setNombre(personaDto.getNombre());
			personaNueva.setApellido(personaDto.getApellido());
			personaNueva.setTelefono(personaDto.getTelefono());
			personaNueva.setTarjetaCredito(personaDto.getTarjetaCredito());

			personaService.save(personaNueva);

		} catch (DataAccessException e) {

			response.put("mensaje", "error al insertar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}

		response.put("mensaje", "la persona ha sido registrado con exito");
		response.put("cliente", personaNueva);
		return new ResponseEntity(new Mensaje("Persona creada"), HttpStatus.OK);

	}
	
	/**
	 * Metodo encargado de actualizar el registro en BD
	 * @param personaDto
	 * @param id
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody PersonaDto personaDto, @PathVariable("id") int id) {

		PersonaEntity personaEntity = personaService.findById(id).get();

		try {

			personaEntity.setNombre(personaDto.getNombre());
			personaEntity.setApellido(personaDto.getApellido());
			personaEntity.setTelefono(personaDto.getTelefono());
			personaEntity.setTarjetaCredito(personaDto.getTarjetaCredito());
			personaEntity.setFechaIngreso(personaDto.getFechaIngreso());

			personaService.save(personaEntity);

		} catch (DataAccessException e) {
			response.put("mensaje", "error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		response.put("mensaje", "la persona ha sido actualizada con exito");
		response.put("cliente", personaEntity);
		return new ResponseEntity(new Mensaje("El registro ha sido actualizado con exito"), HttpStatus.OK);

	}
	
	/**
	 * Metodo encargado de eliminar registro en BD
	 * @param id
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		
		if (!personaService.existsById(id)) {
			response.put("mensaje", "error al actualizar en la base de datos");
			return new ResponseEntity(new Mensaje("El registro no existe"), HttpStatus.NOT_FOUND);
		}
		personaService.delete(id);
		return new ResponseEntity(new Mensaje("Registro eliminado"), HttpStatus.OK);
		
	}

}
