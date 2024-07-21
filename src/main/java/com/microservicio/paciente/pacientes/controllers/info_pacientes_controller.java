package com.microservicio.paciente.pacientes.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.paciente.pacientes.models.info_pacientes_model;
import com.microservicio.paciente.pacientes.services.info_pacientes_services;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/pacientes")
public class info_pacientes_controller {
	@Autowired
	info_pacientes_services info_pacientes_service;
	
	 @GetMapping()
	 public ArrayList<info_pacientes_model> obtnerPacientes() {
	 	return info_pacientes_service.obtenerPacientes();
	 }
	 
	 @PostMapping()
	 public info_pacientes_model guardarPaciente(@RequestBody info_pacientes_model paciente) {
		 return this.info_pacientes_service.guardarPaciente(paciente);
	 }
	 
	 @GetMapping("/{cedula}")
	 public Optional<info_pacientes_model> ObtenerPacientesPorCI(@PathVariable("cedula") 
	 Long cedula) {
	 	
		 return this.info_pacientes_service.obtenerPacientesPorCI(cedula);
	 }
	 
	 @DeleteMapping(path = "/{cedula}")
	 public String eliminarPaciente(@PathVariable("cedula") Long cedula) {
		 boolean ok = this.info_pacientes_service.eliminarPaciente(cedula);
		 if(ok) {
			 return "Se ha borrado el paciente con el número de cédula" + cedula;
		 } else {
			 return "No se pudo eliminar al paciente " + cedula;
		 }
	 }
	 @PutMapping(path = "/{cedula}")
	 public ResponseEntity<info_pacientes_model> actualizarPacientes(@PathVariable("cedula") Long cedula, @RequestBody info_pacientes_model paciente) {
	     paciente.setCedula(cedula);
	     info_pacientes_model actualizado = this.info_pacientes_service.actualizarPacientes(paciente);
	     if (actualizado != null) {
	         return new ResponseEntity<>(actualizado, HttpStatus.OK);
	     } else {
	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     }
	 }

}
