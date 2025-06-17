package com.sipsoft.licoreria.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresa")
@SQLDelete(sql = "UPDATE empresa SET estadoEmpresa = 0 WHERE idEmpresa = ?")
@Where(clause = "estadoEmpresa = 1")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpresa;

    private String nombreEmpresa;
    private String rucEmpresa;
    private String logoEmpresa;
    private LocalDateTime fecharegistroEmpresa;
    private Integer estadoEmpresa = 1;

    public Empresa() {
    }

    public Empresa(Integer id){
        this.idEmpresa = id;
    } 

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getRucEmpresa() {
        return rucEmpresa;
    }

    public void setRucEmpresa(String rucEmpresa) {
        this.rucEmpresa = rucEmpresa;
    }

    public String getLogoEmpresa() {
        return logoEmpresa;
    }

    public void setLogoEmpresa(String logoEmpresa) {
        this.logoEmpresa = logoEmpresa;
    }

    public LocalDateTime getFecharegistroEmpresa() {
        return fecharegistroEmpresa;
    }

    public void setFecharegistroEmpresa(LocalDateTime fecharegistroEmpresa) {
        this.fecharegistroEmpresa = fecharegistroEmpresa;
    }

    public Integer getEstadoEmpresa() {
        return estadoEmpresa;
    }

    public void setEstadoEmpresa(Integer estadoEmpresa) {
        this.estadoEmpresa = estadoEmpresa;
    }

    @Override
    public String toString() {
        return "Empresa [idEmpresa=" + idEmpresa + ", nombreEmpresa=" + nombreEmpresa + ", rucEmpresa=" + rucEmpresa
                + ", logoEmpresa=" + logoEmpresa + ", fecharegistroEmpresa=" + fecharegistroEmpresa + ", estadoEmpresa="
                + estadoEmpresa + "]";
    }

    
}