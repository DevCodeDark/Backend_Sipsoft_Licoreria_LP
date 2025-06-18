package com.sipsoft.licoreria.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para SegmentoModulo")
public class SegmentoModuloDTO {
    
    @Schema(description = "ID del segmento de módulo", example = "1")
    private Integer idSegmento;
    
    @Schema(description = "Descripción del segmento de módulo", example = "Administración del Sistema")
    private String descripcionSegmento;
    
    @Schema(description = "Icono del segmento de módulo", example = "fa-cogs")
    private String iconoSegmento;
    
    @Schema(description = "Estado del segmento de módulo (1=activo, 0=inactivo)", example = "1")
    private Integer estadoSegmento;
    
    public SegmentoModuloDTO() {
        this.estadoSegmento = 1;
    }
    
    public SegmentoModuloDTO(String descripcionSegmento, String iconoSegmento) {
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
}
