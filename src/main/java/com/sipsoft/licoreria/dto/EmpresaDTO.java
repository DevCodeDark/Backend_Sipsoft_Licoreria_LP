package com.sipsoft.licoreria.dto;

public class EmpresaDTO {
    private Integer idEmpresa;
    private String nombreEmpresa;
    private String rucEmpresa;
    private String logoEmpresa;

    // Getters y Setters

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

    @Override
    public String toString() {
        return "EmpresaDTO [idEmpresa=" + idEmpresa + ", nombreEmpresa=" + nombreEmpresa + ", rucEmpresa=" + rucEmpresa
                + ", logoEmpresa=" + logoEmpresa + "]";
    }
}