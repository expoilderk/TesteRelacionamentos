package com.spring.relacionamento.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.relacionamento.model.Paciente;
import com.spring.relacionamento.repository.PacienteRepository;

@Service @Transactional
public class PacienteService {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@PostMapping
	public Paciente savePaciente(Paciente paciente) {
		return pacienteRepository.save(paciente);
	}
}
