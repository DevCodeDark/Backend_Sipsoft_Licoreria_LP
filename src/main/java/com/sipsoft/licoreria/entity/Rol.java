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
@Table(name = "rol")
@SQLDelete(sql = "UPDATE rol SET estadoRol = 0 WHERE idRol = ?")
@Where(clause = "estadoRol = 1")
public class Rol {    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;
    private String descripcionRol;
    private Integer estadoRol = 1;
    private Integer idEmpresa;
    private Integer idTipoRol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpresa", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnore
    private Empresa empresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoRol", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "roles"})
    @JsonIgnore
    private TipoRol tipoRol;    public Rol() {
        // Constructor vacío requerido por JPA
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }    public String getDescripcionRol() {
        return descripcionRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
    }

    public Integer getEstadoRol() {
        return estadoRol;
    }

    public void setEstadoRol(Integer estadoRol) {
        this.estadoRol = estadoRol;
    }    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdTipoRol() {
        return idTipoRol;
    }

    public void setIdTipoRol(Integer idTipoRol) {
        this.idTipoRol = idTipoRol;
    }

    public TipoRol getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(TipoRol tipoRol) {
        this.tipoRol = tipoRol;
    }    @Override
    public String toString() {
        return "Rol [idRol=" + idRol + ", descripcionRol=" + descripcionRol
                + ", estadoRol=" + estadoRol + ", idEmpresa=" + idEmpresa + ", idTipoRol=" + idTipoRol + "]";
    }
}
