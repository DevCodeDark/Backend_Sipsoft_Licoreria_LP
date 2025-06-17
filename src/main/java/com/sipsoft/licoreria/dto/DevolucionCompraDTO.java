package com.sipsoft.licoreria.dto;

import java.time.LocalDateTime;

public class DevolucionCompraDTO {
    private Integer idDevolucionCompra;
    private LocalDateTime fechaDevolucionCompra;
    private String motivoDevolucionCompra;
    private String imagenDevolucion;
    private Integer estadoDevolucionCompra;
    private Integer idDetalleCompra;
    
    // Getters y Setters
    public Integer getIdDevolucionCompra() {
        return idDevolucionCompra;
    }
    public void setIdDevolucionCompra(Integer idDevolucionCompra) {
        this.idDevolucionCompra = idDevolucionCompra;
    }
    public LocalDateTime getFechaDevolucionCompra() {
        return fechaDevolucionCompra;
    }
    public void setFechaDevolucionCompra(LocalDateTime fechaDevolucionCompra) {
        this.fechaDevolucionCompra = fechaDevolucionCompra;
    }
    public String getMotivoDevolucionCompra() {
        return motivoDevolucionCompra;
    }
    public void setMotivoDevolucionCompra(String motivoDevolucionCompra) {
        this.motivoDevolucionCompra = motivoDevolucionCompra;
    }
    public String getImagenDevolucion() {
        return imagenDevolucion;
    }
    public void setImagenDevolucion(String imagenDevolucion) {
        this.imagenDevolucion = imagenDevolucion;
    }
    public Integer getEstadoDevolucionCompra() {
        return estadoDevolucionCompra;
    }
    public void setEstadoDevolucionCompra(Integer estadoDevolucionCompra) {
        this.estadoDevolucionCompra = estadoDevolucionCompra;
    }
    public Integer getIdDetalleCompra() {
        return idDetalleCompra;
    }
    public void setIdDetalleCompra(Integer idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }  
}