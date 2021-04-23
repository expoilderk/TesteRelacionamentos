package com.spring.relacionamento.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.spring.relacionamento.model.Paciente;
import com.spring.relacionamento.repository.PacienteRepository;
import com.spring.relacionamento.service.PacienteService;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteController {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private PacienteService pacienteService;
	
	//Retorna todos os pacientes
	@GetMapping
	public ResponseEntity<List<Paciente>> findAll() {
		List<Paciente> list = pacienteRepository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//Retorna um paciente especifico
	@GetMapping(value = "/{id}")
	public ResponseEntity<Paciente> findById(@PathVariable Long id) {
		Paciente paciente = pacienteRepository.findById(id).get();
		return ResponseEntity.ok().body(paciente);
	}
	
	//Cria um novo paciente
	@PostMapping("/new")
	public ResponseEntity<Paciente> newPaciente(@RequestBody @Valid Paciente paciente) {
		try {
			pacienteService.savePaciente(paciente);
			return new ResponseEntity<Paciente>(paciente, HttpStatus.CREATED);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}
