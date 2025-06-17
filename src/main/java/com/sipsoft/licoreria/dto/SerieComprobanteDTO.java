package com.sipsoft.licoreria.dto;

public class SerieComprobanteDTO {
    private Integer idSerie;
    private String numSerie;
    private Integer estadoSerie;
    private Integer idTipoComprobante;
    private Integer idEmpresa;

    // Getters y Setters
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
}