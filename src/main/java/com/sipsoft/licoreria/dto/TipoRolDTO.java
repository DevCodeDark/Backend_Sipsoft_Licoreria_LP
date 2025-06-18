package com.sipsoft.licoreria.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para TipoRol")
public class TipoRolDTO {
    
    @Schema(description = "ID del tipo de rol", example = "1")
    private Integer idTipoRol;
    
    @Schema(description = "Nombre del tipo de rol", example = "Administrativo")
    private String tipoRol;
    
    @Schema(description = "Descripción del tipo de rol", example = "Tipo de rol para personal administrativo")
    private String descripcionTipoRol;
    
    @Schema(description = "Estado del tipo de rol (1=activo, 0=inactivo)", example = "1")
    private Integer estadoTipoRol;
    
    public TipoRolDTO() {
        this.estadoTipoRol = 1;
    }
    
    public TipoRolDTO(String tipoRol, String descripcionTipoRol) {
        this();
        this.tipoRol = tipoRol;
        this.descripcionTipoRol = descripcionTipoRol;
    }

    public Integer getIdTipoRol() {
        return idTipoRol;
    }

    public void setIdTipoRol(Integer idTipoRol) {
        this.idTipoRol = idTipoRol;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }

    public String getDescripcionTipoRol() {
        return descripcionTipoRol;
    }

    public void setDescripcionTipoRol(String descripcionTipoRol) {
        this.descripcionTipoRol = descripcionTipoRol;
    }

    public Integer getEstadoTipoRol() {
        return estadoTipoRol;
    }

    public void setEstadoTipoRol(Integer estadoTipoRol) {
        this.estadoTipoRol = estadoTipoRol;
    }
}
