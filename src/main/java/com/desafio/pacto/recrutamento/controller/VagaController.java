package com.desafio.pacto.recrutamento.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.pacto.recrutamento.dto.VagaDTO;
import com.desafio.pacto.recrutamento.model.Vaga;
import com.desafio.pacto.recrutamento.service.VagaService;

@RestController
@RequestMapping("/vagas")
public class VagaController {

	private final VagaService service;
	
	public VagaController(VagaService service) {
        this.service = service;
    }
	
	@GetMapping
    public List<Vaga> listar() {
        return service.listar();
    }
	
	@PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Vaga criar(@RequestBody VagaDTO dto) {
        return service.criar(dto);
    }
	
	@PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Vaga atualizar(@PathVariable Long id, @RequestBody VagaDTO dto) {
        return service.atualizar(id, dto);
    }
	
	@DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
	
	@GetMapping("/{id}")
    public Vaga buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}
