package com.spring.relacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.relacionamento.model.Vacinacao;

@Repository
public interface VacinacaoRepository extends JpaRepository<Vacinacao, Long>{

}
