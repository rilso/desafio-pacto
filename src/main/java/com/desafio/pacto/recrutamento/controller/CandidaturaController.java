package com.desafio.pacto.recrutamento.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.pacto.recrutamento.dto.CandidaturaDTO;
import com.desafio.pacto.recrutamento.model.Candidatura;
import com.desafio.pacto.recrutamento.service.CandidaturaService;

@RestController
@RequestMapping("/candidaturas")
public class CandidaturaController {
	
	private final CandidaturaService service;

    public CandidaturaController(CandidaturaService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasRole('COLABORADOR')")
    public Candidatura candidatar(@RequestBody CandidaturaDTO dto) {
        return service.candidatar(dto);
    }
}
