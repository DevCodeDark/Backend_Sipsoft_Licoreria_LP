package com.sipsoft.licoreria.dto;

public class TipoNotificacionesDTO {
    private Integer idTipoNotificacion;
    private String descripcionNotificacion;
    public Integer getIdTipoNotificacion() {
        return idTipoNotificacion;
    }
    public void setIdTipoNotificacion(Integer idTipoNotificacion) {
        this.idTipoNotificacion = idTipoNotificacion;
    }
    public String getDescripcionNotificacion() {
        return descripcionNotificacion;
    }
    public void setDescripcionNotificacion(String descripcionNotificacion) {
        this.descripcionNotificacion = descripcionNotificacion;
    }
    @Override
    public String toString() {
        return "TipoNotificacionesDTO [idTipoNotificacion=" + idTipoNotificacion + ", descripcionNotificacion="
                + descripcionNotificacion + "]";
    }
}
