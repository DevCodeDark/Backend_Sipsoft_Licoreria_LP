package com.sipsoft.licoreria.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para respuestas de autenticación")
public class AuthResponse {
    
    @Schema(description = "Token de acceso JWT", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    private String accessToken;
    
    @Schema(description = "ID del cliente", example = "client_123")
    private String clienteId;
    
    @Schema(description = "Email del usuario", example = "usuario@email.com")
    private String email;
    
    @Schema(description = "Nombre del usuario", example = "Juan")
    private String nombre;
    
    @Schema(description = "Apellido del usuario", example = "Pérez")
    private String apellido;
    
    @Schema(description = "Tipo de token", example = "Bearer")
    private String tokenType = "Bearer";
    
    @Schema(description = "Tiempo de expiración en segundos", example = "86400")
    private Long expiresIn = 86400L; // 24 horas
      // Constructores
    public AuthResponse() {}
    
    public AuthResponse(String accessToken) {
        this.accessToken = accessToken;
    }
    
    public AuthResponse(String accessToken, String clienteId, String email, String nombre, String apellido) {
        this.accessToken = accessToken;
        this.clienteId = clienteId;
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    // Getters y Setters
    public String getAccessToken() {
        return accessToken;
    }
    
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    
    public String getClienteId() {
        return clienteId;
    }
    
    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getTokenType() {
        return tokenType;
    }
    
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
    
    public Long getExpiresIn() {
        return expiresIn;
    }
    
    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }
}
