package com.sipsoft.licoreria.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO completo para respuesta de registro de cliente")
public class RegistroCompletoResponseDTO {
    
    @Schema(description = "Email del cliente", example = "usuario1@email.com")
    private String email;
    
    @Schema(description = "Nombre del cliente", example = "Juan")
    private String nombre;
    
    @Schema(description = "Apellido del cliente", example = "Pérez")
    private String apellido;
    
    @Schema(description = "ID único del cliente (hash de 64 caracteres)", example = "85......")
    private String clienteId;
    
    @Schema(description = "Llave secreta del cliente (solo se devuelve una vez al registrarse)", example = "$2........")
    private String llaveSecreta;

    // Constructores
    public RegistroCompletoResponseDTO() {}

    public RegistroCompletoResponseDTO(String email, String nombre, String apellido, 
                                     String clienteId, String llaveSecreta) {
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.clienteId = clienteId;
        this.llaveSecreta = llaveSecreta;
    }

    // Getters y Setters
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
