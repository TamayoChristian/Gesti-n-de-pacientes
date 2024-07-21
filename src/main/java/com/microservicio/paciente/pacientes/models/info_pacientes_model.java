package com.microservicio.paciente.pacientes.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "pacientes")
public class info_pacientes_model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long cedula;
	
	private String nombres;
	private String direccion;
	private Long telefono;
	private Date fecha_nac;
	private String observaciones;
	
	//Constructor completo
	public info_pacientes_model(long cedula, String nombres, String direccion, long telefono, Date fecha_nac,
			String observaciones) {
		super();
		this.cedula = cedula;
		this.nombres = nombres;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fecha_nac = fecha_nac;
		this.observaciones = observaciones;
	}
	
	//constructor sin id
	public info_pacientes_model(String nombres, String direccion, long telefono, Date fecha_nac, String observaciones) {
		super();
		this.nombres = nombres;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fecha_nac = fecha_nac;
		this.observaciones = observaciones;
	}	
	
	//Constructor sin datos
	public info_pacientes_model() {
		super();
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
}
