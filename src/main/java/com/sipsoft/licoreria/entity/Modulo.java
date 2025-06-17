package com.sipsoft.licoreria.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore; // Importar JsonIgnore
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
@Table(name = "modulo")
@SQLDelete(sql = "UPDATE modulo SET estadoModulo = 0 WHERE idModulo = ?")
@Where(clause = "estadoModulo = 1")
public class Modulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idModulo;
    private String urlModulo;
    private String nombreModulo;
    private Integer estadoModulo = 1;
    private Integer idEmpresa;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpresa", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empresa empresa;

    public Modulo() {
    }

    public Integer getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Integer idModulo) {
        this.idModulo = idModulo;
    }

    public String getUrlModulo() {
        return urlModulo;
    }

    public void setUrlModulo(String urlModulo) {
        this.urlModulo = urlModulo;
    }

    public String getNombreModulo() {
        return nombreModulo;
    }

    public void setNombreModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }

    public Integer getEstadoModulo() {
        return estadoModulo;
    }

    public void setEstadoModulo(Integer estadoModulo) {
        this.estadoModulo = estadoModulo;
    }

    public Empresa getEmpresa() {
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

    @Override
    public String toString() {
        return "Modulo [idModulo=" + idModulo + ", urlModulo=" + urlModulo + ", nombreModulo=" + nombreModulo
                + ", estadoModulo=" + estadoModulo + ", empresa=" + empresa + "]";
    }
}