package com.personas.apiRest.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class PersonaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nombre;
	private String apellido;
	private int telefono;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "tarjetaCredito", referencedColumnName = "idTarjeta")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TarjetaCreditoEntity tarjetaCredito;

	@Temporal(TemporalType.DATE)
	private Date fechaIngreso;
	
	public PersonaEntity() {
		
	}

	public PersonaEntity(int id, String nombre, String apellido, int telefono, TarjetaCreditoEntity tarjetaCredito,
			Date fechaIngreso) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.tarjetaCredito = tarjetaCredito;
		this.fechaIngreso = fechaIngreso;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public TarjetaCreditoEntity getTarjetaCredito() {
		return tarjetaCredito;
	}

	public void setTarjetaCredito(TarjetaCreditoEntity tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

}
