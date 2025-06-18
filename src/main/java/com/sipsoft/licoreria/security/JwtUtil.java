package com.sipsoft.licoreria.security;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

@Component
public class JwtUtil {    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);
    private final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME = 100L * 365 * 24 * 60 * 60 * 1000; // 100 años
    
    public String generarToken(String clienteId){
        return Jwts.builder()
            .setSubject(clienteId)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(key)
            .compact();
    }
    
    public String generarTokenCompleto(String email, String clienteId){
        return Jwts.builder()
            .setSubject(email)
            .claim("clienteId", clienteId)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(key)
            .compact();
    }
    
    public boolean validarToken(String token){
        try {
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);            return true;
        } catch (Exception e) {
            logger.error("Error validando token: {}", e.getMessage());
            return false;
        }
    }
    
    public String extraerClienteId(String token){
        try {
            Claims claims = Jwts.parserBuilder()
                   .setSigningKey(key)
                   .build()
                   .parseClaimsJws(token)
                   .getBody();
              // Primero intentar obtener clienteId del claim
            String clienteId = (String) claims.get("clienteId");
            if (clienteId != null) {
                return clienteId;
            }
            
            return claims.getSubject();
        } catch (Exception e) {
            logger.error("Error extrayendo clienteId: {}", e.getMessage());
            return null;
        }
    }
    
    public String extraerEmail(String token){
        try {
            Claims claims = Jwts.parserBuilder()
                   .setSigningKey(key)
                   .build()                   .parseClaimsJws(token)
                   .getBody();
            
            return claims.getSubject(); // El subject contiene el email
        } catch (Exception e) {
            logger.error("Error extrayendo email: {}", e.getMessage());
            return null;
        }
    }
}
