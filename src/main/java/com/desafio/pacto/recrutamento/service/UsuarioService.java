package com.desafio.pacto.recrutamento.service;

import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.desafio.pacto.recrutamento.model.Usuario;
import com.desafio.pacto.recrutamento.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {
	
	private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario user = repository.findByEmail(email);

        return new User(
                user.getEmail(),
                user.getSenha(),
                Collections.singletonList((GrantedAuthority) new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        );
    }
    
    public Usuario buscarPorEmail(String email) {
    	return repository.findByEmail(email);
    }

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }
}
