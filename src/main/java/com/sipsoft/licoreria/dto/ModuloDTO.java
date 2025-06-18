package com.sipsoft.licoreria.dto;

public class ModuloDTO {
    private Integer idModulo;
    private Integer idSegmento;
    private String urlModulo;
    private String nombreModulo;
    private Integer estadoModulo;

    // Getters y Setters
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

    @Override
    public String toString() {
        return "ModuloDTO [idModulo=" + idModulo + ", idSegmento=" + idSegmento + ", urlModulo=" + urlModulo 
                + ", nombreModulo=" + nombreModulo + ", estadoModulo=" + estadoModulo + "]";
    }
}