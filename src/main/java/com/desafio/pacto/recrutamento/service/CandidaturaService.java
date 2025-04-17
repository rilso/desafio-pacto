package com.desafio.pacto.recrutamento.service;

import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.desafio.pacto.recrutamento.dto.CandidaturaDTO;
import com.desafio.pacto.recrutamento.model.Candidatura;
import com.desafio.pacto.recrutamento.model.Usuario;
import com.desafio.pacto.recrutamento.model.Vaga;
import com.desafio.pacto.recrutamento.repository.CandidaturaRepository;
import com.desafio.pacto.recrutamento.repository.UsuarioRepository;
import com.desafio.pacto.recrutamento.repository.VagaRepository;

@Service
public class CandidaturaService {

	private final CandidaturaRepository candidaturaRepository;
    private final VagaRepository vagaRepository;
    private final UsuarioRepository usuarioRepository;
    
	public CandidaturaService(CandidaturaRepository candidaturaRepo, VagaRepository vagaRepo,
			UsuarioRepository usuarioRepo) {
		this.candidaturaRepository = candidaturaRepo;
		this.vagaRepository = vagaRepo;
		this.usuarioRepository = usuarioRepo;
	}
	
	public Candidatura candidatar(CandidaturaDTO dto) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario candidato = usuarioRepository.findByEmail(email);

        Vaga vaga = vagaRepository.findById(dto.getIdVaga()).orElseThrow();

        Optional<Candidatura> existente = candidaturaRepository
            .findByCandidatoAndVaga(candidato, vaga);
        if (existente.isPresent()) {
            throw new RuntimeException("Você já se candidatou a esta vaga.");
        }

        Candidatura candidatura = new Candidatura();
        candidatura.setCandidato(candidato);
        candidatura.setVaga(vaga);
        candidatura.setStatus("PENDENTE");
        return candidaturaRepository.save(candidatura);
    }
}
