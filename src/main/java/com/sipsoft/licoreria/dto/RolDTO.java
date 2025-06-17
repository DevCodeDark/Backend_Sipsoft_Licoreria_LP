package com.sipsoft.licoreria.dto;

public class RolDTO {
    private Integer idRol;
    private String nombreRol;
    private String descripcionRol;
    private Integer idEmpresa;

    // Getters y Setters

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcionRol() {
        return descripcionRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public String toString() {
        return "RolDTO [idRol=" + idRol + ", nombreRol=" + nombreRol + ", descripcionRol=" + descripcionRol
                + ", idEmpresa=" + idEmpresa + "]";
    }
}