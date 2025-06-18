package com.sipsoft.licoreria.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para el registro de autenticación")
public class RegistroDTO {
    
    @Schema(description = "ID del registro", example = "1")
    private Integer idRegistro;
      @Schema(description = "Email del usuario", example = "usuario@email.com")
    private String email;
    
    @Schema(description = "Nombre del usuario", example = "Juan")
    private String nombre;
    
    @Schema(description = "Apellido del usuario", example = "Pérez")
    private String apellido;
    
    @Schema(description = "Token de acceso", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    private String accessToken;
    
    @Schema(description = "ID del cliente", example = "client_123")
    private String clienteId;
    
    @Schema(description = "Llave secreta", example = "secret_key_123")
    private String llaveSecreta;
    
    // Constructores
    public RegistroDTO() {}
    
    public RegistroDTO(String email, String nombre, String apellido) {
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    // Getters y Setters
    public Integer getIdRegistro() {
        return idRegistro;
    }
    
    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
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
    
    public String getLlaveSecreta() {
        return llaveSecreta;
    }
    
    public void setLlaveSecreta(String llaveSecreta) {
        this.llaveSecreta = llaveSecreta;
    }
}
