package com.desafio.pacto.recrutamento.controller;

import com.desafio.pacto.recrutamento.auth.AuthRequest;
import com.desafio.pacto.recrutamento.auth.AuthResponse;
import com.desafio.pacto.recrutamento.model.Role;
import com.desafio.pacto.recrutamento.model.Usuario;
import com.desafio.pacto.recrutamento.security.JwtService;
import com.desafio.pacto.recrutamento.service.UsuarioService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
		var auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSenha()));

		String token = jwtService.generateToken((Usuario) auth.getPrincipal());
		Usuario usuario = usuarioService.buscarPorEmail(request.getEmail());
		
		if (usuario != null) {
			AuthResponse authResponse = new AuthResponse(token, String.valueOf(usuario.getId()));
			return ResponseEntity.ok(authResponse);
		}
		return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid AuthRequest request) {
        String encodedPassword = new BCryptPasswordEncoder().encode(request.getSenha());
    	
    	Usuario usuario = new Usuario(request.getNome(), request.getEmail(), encodedPassword, (request.getRole() != null ? request.getRole() : Role.COLABORADOR));

        usuarioService.salvar(usuario);
        return ResponseEntity.ok("Usuário registrado com sucesso!");
    }
}
