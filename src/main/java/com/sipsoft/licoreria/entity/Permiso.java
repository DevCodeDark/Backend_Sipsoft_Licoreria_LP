package com.sipsoft.licoreria.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "permiso")
@SQLDelete(sql = "UPDATE permiso SET estadoPermiso = 0 WHERE idPermiso = ?")
@Where(clause = "estadoPermiso = 1")
public class Permiso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPermiso;
    private Integer estadoPermiso = 1;
    private Integer idRol;
    private Integer idModulo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idRol", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Rol rol;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idModulo", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Modulo modulo;

    public Permiso() {
    }

    public Integer getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public Integer getEstadoPermiso() {
        return estadoPermiso;
    }

    public void setEstadoPermiso(Integer estadoPermiso) {
        this.estadoPermiso = estadoPermiso;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public Integer getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Integer idModulo) {
        this.idModulo = idModulo;
    }

    @Override
    public String toString() {
        return "Permiso [idPermiso=" + idPermiso + ", estadoPermiso=" + estadoPermiso + ", idRol=" + idRol
                + ", idModulo=" + idModulo + "]";
    }
}