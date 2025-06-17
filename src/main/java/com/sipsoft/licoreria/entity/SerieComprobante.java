package com.sipsoft.licoreria.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "serie_comprobante")
@SQLDelete(sql = "UPDATE serie_comprobante SET estadoSerie = 0 WHERE idSerie = ?")
@Where(clause = "estadoSerie = 1")
public class SerieComprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSerie;
    private String numSerie;
    private Integer estadoSerie = 1;
    private Integer idTipoComprobante;
    private Integer idEmpresa;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoComprobante", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TipoComprobante tipoComprobante;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpresa", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empresa empresa;

    // Getters y Setters
    public SerieComprobante() {}

    public Integer getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Integer idSerie) {
        this.idSerie = idSerie;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public Integer getEstadoSerie() {
        return estadoSerie;
    }

    public void setEstadoSerie(Integer estadoSerie) {
        this.estadoSerie = estadoSerie;
    }

    public Integer getIdTipoComprobante() {
        return idTipoComprobante;
    }

    public void setIdTipoComprobante(Integer idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public TipoComprobante getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(TipoComprobante tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}