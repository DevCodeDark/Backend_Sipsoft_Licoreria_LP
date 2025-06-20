package com.sipsoft.licoreria.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "segmento_modulo")
public class SegmentoModulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSegmento")
    private Integer idSegmento;

    @Column(name = "descripcionSegmento", length = 255, nullable = false)
    private String descripcionSegmento;

    @Column(name = "iconoSegmento", length = 255)
    private String iconoSegmento;

    @Column(name = "estadoSegmento", nullable = false, columnDefinition = "int(1) default 1")
    private Integer estadoSegmento;
    @OneToMany(mappedBy = "idSegmento")
    @JsonIgnore
    private List<Modulo> modulos;

    public SegmentoModulo() {
        this.estadoSegmento = 1;
    }

    public SegmentoModulo(String descripcionSegmento, String iconoSegmento) {
        this();
        this.descripcionSegmento = descripcionSegmento;
        this.iconoSegmento = iconoSegmento;
    }

    public Integer getIdSegmento() {
        return idSegmento;
    }

    public void setIdSegmento(Integer idSegmento) {
        this.idSegmento = idSegmento;
    }

    public String getDescripcionSegmento() {
        return descripcionSegmento;
    }

    public void setDescripcionSegmento(String descripcionSegmento) {
        this.descripcionSegmento = descripcionSegmento;
    }

    public String getIconoSegmento() {
        return iconoSegmento;
    }

    public void setIconoSegmento(String iconoSegmento) {
        this.iconoSegmento = iconoSegmento;
    }

    public Integer getEstadoSegmento() {
        return estadoSegmento;
    }

    public void setEstadoSegmento(Integer estadoSegmento) {
        this.estadoSegmento = estadoSegmento;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }
}
