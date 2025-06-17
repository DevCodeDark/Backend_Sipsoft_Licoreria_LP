package com.sipsoft.licoreria.dto;

public class ModuloDTO {
    private Integer idModulo;
    private String urlModulo;
    private String nombreModulo;
    private Integer idEmpresa;

    // Getters y Setters
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

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public String toString() {
        return "ModuloDTO [idModulo=" + idModulo + ", urlModulo=" + urlModulo + ", nombreModulo=" + nombreModulo
                + ", idEmpresa=" + idEmpresa + "]";
    }
}