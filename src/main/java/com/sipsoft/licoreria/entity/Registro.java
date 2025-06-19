package com.sipsoft.licoreria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "registros")
public class Registro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    private Integer idRegistro;
    
    @Column(name = "email", nullable = false, length = 255, unique = true)
    private String email;
    
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    
    @Column(name = "apellido", nullable = false, length = 255)
    private String apellido;
    
    @JsonIgnore
    @Column(name = "accessToken", nullable = true, length = 500)
    private String accessToken;
    
    @Column(name = "clienteId", nullable = false, length = 255, unique = true)
    private String clienteId;
    
    @Column(name = "llaveSecreta", nullable = false, length = 255)
    private String llaveSecreta;
    
    // Constructores
    public Registro() {}
    
    public Registro(String email, String nombre, String apellido) {
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
    
    @Override
    public String toString() {
        return "Registro{" +
                "idRegistro=" + idRegistro +
                ", email='" + email + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", clienteId='" + clienteId + '\'' +
                '}';
    }
}
