package com.sipsoft.licoreria.dto;

public class PermisoDTO {
    private Integer idPermiso;
    private Integer idRol;
    private Integer idModulo;
    private Integer estadoPermiso;

    public Integer getEstadoPermiso() {
        return estadoPermiso;
    }

    public void setEstadoPermiso(Integer estadoPermiso) {
        this.estadoPermiso = estadoPermiso;
    }

    // Getters y Setters
    public Integer getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public Integer getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Integer idModulo) {
        this.idModulo = idModulo;
    }
}