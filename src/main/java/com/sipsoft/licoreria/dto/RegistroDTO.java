package com.sipsoft.licoreria.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para el registro de nuevos clientes")
public class RegistroDTO {
    
    @Schema(description = "Email del usuario", example = "usuario@email.com", required = true)
    private String email;
    
    @Schema(description = "Nombre del usuario", example = "Juan", required = true)
    private String nombre;
    
    @Schema(description = "Apellido del usuario", example = "Pérez", required = true)
    private String apellido;
    
    // Constructores
    public RegistroDTO() {}
    
    public RegistroDTO(String email, String nombre, String apellido) {
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
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
}
