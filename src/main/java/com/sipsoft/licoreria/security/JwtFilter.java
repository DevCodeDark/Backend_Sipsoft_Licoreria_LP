package com.sipsoft.licoreria.security;

import java.io.IOException;
import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.GenericFilter;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class JwtFilter extends GenericFilter {
    
    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
            throws IOException, ServletException{
        HttpServletRequest request = (HttpServletRequest) req;
        String header = request.getHeader("Authorization");
        
        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            
            if (jwtUtil.validarToken(token)) {
                String clienteId = jwtUtil.extraerClienteId(token);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                    clienteId, null, Collections.emptyList());
                SecurityContextHolder.getContext().setAuthentication(auth);  
            }
        }
        chain.doFilter(req, res);
    }
}
