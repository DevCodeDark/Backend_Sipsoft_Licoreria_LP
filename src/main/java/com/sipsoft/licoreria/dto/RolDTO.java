package com.sipsoft.licoreria.dto;

public class RolDTO {
    private Integer idRol;
    private String descripcionRol;
    private Integer estadoRol;
    private Integer idEmpresa;
    private Integer idTipoRol;    // Getters y Setters

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getDescripcionRol() {
        return descripcionRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
    }

    public Integer getEstadoRol() {
        return estadoRol;
    }

    public void setEstadoRol(Integer estadoRol) {
        this.estadoRol = estadoRol;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdTipoRol() {
        return idTipoRol;
    }

    public void setIdTipoRol(Integer idTipoRol) {
        this.idTipoRol = idTipoRol;
    }    @Override
    public String toString() {
        return "RolDTO [idRol=" + idRol + ", descripcionRol=" + descripcionRol + ", estadoRol=" + estadoRol
                + ", idEmpresa=" + idEmpresa + ", idTipoRol=" + idTipoRol + "]";
    }
}