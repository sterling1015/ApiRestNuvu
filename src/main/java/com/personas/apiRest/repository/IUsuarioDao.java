package com.personas.apiRest.repository;

import org.springframework.data.repository.CrudRepository;

import com.personas.apiRest.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{
	
	public Usuario findByUsername(String username);

}
