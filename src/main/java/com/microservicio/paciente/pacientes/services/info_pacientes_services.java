package com.microservicio.paciente.pacientes.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicio.paciente.pacientes.models.info_pacientes_model;
import com.microservicio.paciente.pacientes.repository.info_pacientes_repository;


@Service
public class info_pacientes_services {
	@Autowired
	info_pacientes_repository info_pacientes_repository;
	
	public  ArrayList<info_pacientes_model> obtenerPacientes(){
		return (ArrayList<info_pacientes_model>) info_pacientes_repository.findAll();
	}
	
	public info_pacientes_model guardarPaciente(info_pacientes_model nuevoPaciente) {
		return info_pacientes_repository.save(nuevoPaciente);
	}
	
	public Optional<info_pacientes_model> obtenerPacientesPorCI(Long ci){
		return info_pacientes_repository.findById(ci);
	}
	
	public info_pacientes_model actualizarPacientes(info_pacientes_model Actualizacion) {
		Optional<info_pacientes_model> registro = obtenerPacientesPorCI(Actualizacion.getCedula());
		if(registro.isPresent()) {
			info_pacientes_model Actualizar_Paciente = registro.get();
			Actualizar_Paciente.setNombres(Actualizacion.getNombres());
			Actualizar_Paciente.setDireccion(Actualizacion.getDireccion());
			Actualizar_Paciente.setFecha_nac(Actualizacion.getFecha_nac());
			Actualizar_Paciente.setObservaciones(Actualizacion.getObservaciones());
			Actualizar_Paciente.setTelefono(Actualizacion.getTelefono());
			return info_pacientes_repository.save(Actualizar_Paciente);
		} else {
			return null;
		}
	}
	
	public boolean eliminarPaciente(Long ci) {
		try {
			info_pacientes_repository.deleteById(ci);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
