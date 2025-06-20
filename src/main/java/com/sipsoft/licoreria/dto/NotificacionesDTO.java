package com.sipsoft.licoreria.dto;

import java.time.LocalDateTime;

public class NotificacionesDTO {
    private Integer idNotificacion;
    private LocalDateTime fechaNotificacion;
    private String mensaje;
    private Integer idProducto;
    private Integer idTipoNotificacion;
    private Integer idContratoProveedor;
    private Integer estadoNotificacion;

    public Integer getIdNotificacion() {
        return idNotificacion;
    }
    public void setIdNotificacion(Integer idNotificacion) {
        this.idNotificacion = idNotificacion;
    }
    public LocalDateTime getFechaNotificacion() {
        return fechaNotificacion;
    }
    public void setFechaNotificacion(LocalDateTime fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public Integer getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
    public Integer getIdTipoNotificacion() {
        return idTipoNotificacion;
    }
    public void setIdTipoNotificacion(Integer idTipoNotificacion) {
        this.idTipoNotificacion = idTipoNotificacion;
    }
    public Integer getIdContratoProveedor() {
        return idContratoProveedor;
    }
    public void setIdContratoProveedor(Integer idContratoProveedor) {
        this.idContratoProveedor = idContratoProveedor;
    }
    public Integer getEstadoNotificacion() {
        return estadoNotificacion;
    }
    public void setEstadoNotificacion(Integer estadoNotificacion) {
        this.estadoNotificacion = estadoNotificacion;
    }
    @Override
    public String toString() {
        return "NotificacionesDTO [idNotificacion=" + idNotificacion + ", fechaNotificacion=" + fechaNotificacion
                + ", mensaje=" + mensaje + ", idProducto=" + idProducto + ", idTipoNotificacion=" + idTipoNotificacion
                + ", idContratoProveedor=" + idContratoProveedor + ", estadoNotificacion=" + estadoNotificacion + "]";
    }
}
