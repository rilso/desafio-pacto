package com.desafio.pacto.recrutamento.repository;

import com.desafio.pacto.recrutamento.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByEmail(String email);
}
