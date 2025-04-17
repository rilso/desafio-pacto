package com.desafio.pacto.recrutamento.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.desafio.pacto.recrutamento.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(Usuario usuario) {
    	try {
			
			Map<String, String> payload = new HashMap<String, String>();
			payload.put("ROLE", usuario.getRole().toString());
			
			Algorithm algorithm = Algorithm.HMAC256(secret);
			
			String token = JWT.create()
					.withIssuer("login-auth-api")
					.withSubject(usuario.getEmail())
					.withPayload(payload)
					.withExpiresAt(this.generateExpirationTime())
					.sign(algorithm);
			
			return token;
		} catch (JWTCreationException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro durante a autenticacao");
		}
    }

    public String validateToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm)
					.withIssuer("login-auth-api")
					.build()
					.verify(token)
					.getSubject();
			
		} catch (JWTVerificationException e) {
			e.printStackTrace();
			return "";
		}
	}
    
    private Instant generateExpirationTime() {
		return LocalDateTime.now().plusHours(3).toInstant(ZoneOffset.of("-03:00"));
	}
}
