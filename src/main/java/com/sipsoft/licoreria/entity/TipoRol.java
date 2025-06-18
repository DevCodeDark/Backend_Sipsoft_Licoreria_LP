package com.sipsoft.licoreria.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_rol")
public class TipoRol {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoRol")
    private Integer idTipoRol;
    
    @Column(name = "tipoRol", length = 60, nullable = false)
    private String tipoRol;
    
    @Column(name = "descripcionTipoRol", length = 150)
    private String descripcionTipoRol;
    
    @Column(name = "estadoTipoRol", nullable = false, columnDefinition = "int(1) default 1")
    private Integer estadoTipoRol;
    
    @OneToMany(mappedBy = "idTipoRol")
    @JsonIgnore
    @JsonManagedReference
    private List<Rol> roles;
    
    public TipoRol() {
        this.estadoTipoRol = 1;
    }
    
    public TipoRol(String tipoRol, String descripcionTipoRol) {
        this();
        this.tipoRol = tipoRol;
        this.descripcionTipoRol = descripcionTipoRol;
    }

    public Integer getIdTipoRol() {
        return idTipoRol;
    }

    public void setIdTipoRol(Integer idTipoRol) {
        this.idTipoRol = idTipoRol;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }

    public String getDescripcionTipoRol() {
        return descripcionTipoRol;
    }

    public void setDescripcionTipoRol(String descripcionTipoRol) {
        this.descripcionTipoRol = descripcionTipoRol;
    }

    public Integer getEstadoTipoRol() {
        return estadoTipoRol;
    }

    public void setEstadoTipoRol(Integer estadoTipoRol) {
        this.estadoTipoRol = estadoTipoRol;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}
