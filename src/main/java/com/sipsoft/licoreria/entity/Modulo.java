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
@Table(name = "modulo")
@SQLDelete(sql = "UPDATE modulo SET estadoModulo = 0 WHERE idModulo = ?")
@Where(clause = "estadoModulo = 1")
public class Modulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idModulo;
    
    private Integer idSegmento;
    private String urlModulo;
    private String nombreModulo;
    private Integer estadoModulo = 1;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSegmento", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "modulos"})
    private SegmentoModulo segmentoModulo;    public Modulo() {
        // Constructor vacío requerido por JPA
    }

    public Integer getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Integer idModulo) {
        this.idModulo = idModulo;
    }

    public Integer getIdSegmento() {
        return idSegmento;
    }

    public void setIdSegmento(Integer idSegmento) {
        this.idSegmento = idSegmento;
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

    public SegmentoModulo getSegmentoModulo() {
        return segmentoModulo;
    }

    public void setSegmentoModulo(SegmentoModulo segmentoModulo) {
        this.segmentoModulo = segmentoModulo;
    }

    @Override
    public String toString() {
        return "Modulo [idModulo=" + idModulo + ", idSegmento=" + idSegmento + ", urlModulo=" + urlModulo 
                + ", nombreModulo=" + nombreModulo + ", estadoModulo=" + estadoModulo + "]";
    }
}