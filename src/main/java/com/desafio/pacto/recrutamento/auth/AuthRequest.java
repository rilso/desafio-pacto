package com.desafio.pacto.recrutamento.auth;

import com.desafio.pacto.recrutamento.model.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {
	
	private String nome;
    private String email;
    private String senha;
    private Role role;
}
