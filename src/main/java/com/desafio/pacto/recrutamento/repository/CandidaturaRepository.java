package com.desafio.pacto.recrutamento.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.pacto.recrutamento.model.Candidatura;
import com.desafio.pacto.recrutamento.model.Usuario;
import com.desafio.pacto.recrutamento.model.Vaga;

public interface CandidaturaRepository extends JpaRepository<Candidatura, Long> {

	Optional<Candidatura> findByCandidatoAndVaga(Usuario candidato, Vaga vaga);
}
