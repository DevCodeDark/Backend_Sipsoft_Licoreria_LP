package com.sipsoft.licoreria.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para respuesta segura de registro (sin información sensible)")
public class RegistroResponseDTO {
    
    @Schema(description = "ID del registro", example = "1")
    private Integer idRegistro;
    
    @Schema(description = "Email del cliente", example = "usuario@email.com")
    private String email;
    
    @Schema(description = "Nombre del cliente", example = "Juan")
    private String nombre;
    
    @Schema(description = "Apellido del cliente", example = "Pérez")
    private String apellido;
      @Schema(description = "ID único del cliente", example = "8......")
    private String clienteId;
    
    @Schema(description = "Llave secreta del cliente", example = "$2.......")
    private String llaveSecreta;

    // Constructores
    public RegistroResponseDTO() {}

    public RegistroResponseDTO(Integer idRegistro, String email, String nombre, String apellido, String clienteId, String llaveSecreta) {
        this.idRegistro = idRegistro;
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.clienteId = clienteId;
        this.llaveSecreta = llaveSecreta;
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
    }    public String getClienteId() {
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
