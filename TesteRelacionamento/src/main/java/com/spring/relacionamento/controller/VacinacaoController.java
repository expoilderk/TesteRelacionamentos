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

import com.spring.relacionamento.model.Vacinacao;
import com.spring.relacionamento.repository.VacinacaoRepository;
import com.spring.relacionamento.service.VacinacaoService;

@RestController
@RequestMapping(value = "/vacinacao")
public class VacinacaoController {
	
	@Autowired
	VacinacaoRepository vacinacaoRepository;
	
	@Autowired
	VacinacaoService vacinacaoService;
	
	
	//Retorna todos os pacientes
	@GetMapping
	public ResponseEntity<List<Vacinacao>> findAll() {
		List<Vacinacao> list = vacinacaoRepository.findAll();
		return ResponseEntity.ok().body(list);
		}
	
	
	//Retorna um paciente especifico
	@GetMapping(value = "/{id}")
	public ResponseEntity<Vacinacao> findById(@PathVariable Long id) {
		Vacinacao vacinacao = vacinacaoRepository.findById(id).get();
		return ResponseEntity.ok().body(vacinacao);
		}
	
		
	//Cria um novo cadastro de vacinação
	@PostMapping("/new")
	public ResponseEntity<Vacinacao> newVacinacao(@RequestBody @Valid Vacinacao vacinacao) {
		try {
			vacinacaoService.saveVacinacao(vacinacao);
			return new ResponseEntity<Vacinacao>(vacinacao, HttpStatus.CREATED);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
	}
}