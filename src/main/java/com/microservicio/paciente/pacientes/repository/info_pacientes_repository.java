package com.microservicio.paciente.pacientes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservicio.paciente.pacientes.models.info_pacientes_model;
@Repository
public interface info_pacientes_repository extends CrudRepository<info_pacientes_model, Long>{

}
