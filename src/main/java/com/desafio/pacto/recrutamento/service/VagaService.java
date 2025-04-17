package com.desafio.pacto.recrutamento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.desafio.pacto.recrutamento.dto.VagaDTO;
import com.desafio.pacto.recrutamento.model.Vaga;
import com.desafio.pacto.recrutamento.repository.VagaRepository;

@Service
public class VagaService {

	private final VagaRepository repository;
	
	public VagaService(VagaRepository repository) {
        this.repository = repository;
    }
	
	public Vaga criar(VagaDTO dto) {
        Vaga vaga = new Vaga();
        vaga.setTitulo(dto.getTitulo());
        vaga.setDescricao(dto.getDescricao());
        vaga.setRequisitos(dto.getRequisitos());
        return repository.save(vaga);
    }
	
	public List<Vaga> listar() {
        return repository.findAll();
    }
	
	public Vaga atualizar(Long id, VagaDTO dto) {
		Vaga vaga = repository.findById(id).orElseThrow();
        vaga.setTitulo(dto.getTitulo());
        vaga.setDescricao(dto.getDescricao());
        vaga.setRequisitos(dto.getRequisitos());
        return repository.save(vaga);
	}
	
	public void excluir(Long id) {
		repository.deleteById(id);
    }

    public Vaga buscarPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
