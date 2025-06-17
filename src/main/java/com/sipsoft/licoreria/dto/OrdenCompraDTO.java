package com.sipsoft.licoreria.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrdenCompraDTO {
    private Integer idOrden;
    private Boolean activo;
    private String estado;
    private LocalDateTime fechaActualizacion;
    private LocalDateTime fechaEnvio;
    private LocalDate fechaOrden;
    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaRespuesta;
    private String observaciones;
    private Integer idEmpresa;
    private Integer idProveedor;
    private Integer idTipoPago;

    // Getters y Setters
    public Integer getIdOrden() {
        return idOrden;
    }
    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }
    public Boolean getActivo() {
        return activo;
    }
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }
    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }
    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
    public LocalDate getFechaOrden() {
        return fechaOrden;
    }
    public void setFechaOrden(LocalDate fechaOrden) {
        this.fechaOrden = fechaOrden;
    }
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public LocalDateTime getFechaRespuesta() {
        return fechaRespuesta;
    }
    public void setFechaRespuesta(LocalDateTime fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }
    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public Integer getIdEmpresa() {
        return idEmpresa;
    }
    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    public Integer getIdProveedor() {
        return idProveedor;
    }
    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }
    public Integer getIdTipoPago() {
        return idTipoPago;
    }
    public void setIdTipoPago(Integer idTipoPago) {
        this.idTipoPago = idTipoPago;
    }    
}