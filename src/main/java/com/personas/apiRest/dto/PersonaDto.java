package com.personas.apiRest.dto;

import java.util.Date;

import com.personas.apiRest.entity.TarjetaCreditoEntity;

public class PersonaDto {

	private int id;
	private String nombre;
	private String apellido;
	private long telefono;
	private TarjetaCreditoEntity tarjetaCredito;
	private Date fechaIngreso;

	public PersonaDto() {

	}

	public PersonaDto(int id, String nombre, String apellido, long telefono, TarjetaCreditoEntity tarjetaCredito,
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

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
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
