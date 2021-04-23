package com.spring.relacionamento.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.relacionamento.model.Vacinacao;
import com.spring.relacionamento.repository.VacinacaoRepository;

@Service
public class VacinacaoService {

	@Autowired
	VacinacaoRepository vacinacaoRepository;
	
	@PostMapping
	public Vacinacao saveVacinacao(@Valid Vacinacao vacinacao) {
		return vacinacaoRepository.save(vacinacao);
	}

}
