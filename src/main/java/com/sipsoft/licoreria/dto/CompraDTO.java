package com.sipsoft.licoreria.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CompraDTO {
    private Integer idCompra;
    private String guiaRemisionCompra;
    private Float precioTotalCompra;
    private LocalDate fechaCompra;
    private Float igv;
    private Integer estadoCompra;
    private String tipoCompra;
    private Boolean activo;
    private LocalDateTime fechaActualizacion;
    private LocalDateTime fechaRegistro;
    private Integer idProveedor;
    private Integer idOrden;
    private Integer idEmpresa;
    private Integer idTipoPago;

    // Getters y Setters
    public Integer getIdCompra() {
        return idCompra;
    }
    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }
    public String getGuiaRemisionCompra() {
        return guiaRemisionCompra;
    }
    public void setGuiaRemisionCompra(String guiaRemisionCompra) {
        this.guiaRemisionCompra = guiaRemisionCompra;
    }
    public Float getPrecioTotalCompra() {
        return precioTotalCompra;
    }
    public void setPrecioTotalCompra(Float precioTotalCompra) {
        this.precioTotalCompra = precioTotalCompra;
    }
    public LocalDate getFechaCompra() {
        return fechaCompra;
    }
    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    public Float getIgv() {
        return igv;
    }
    public void setIgv(Float igv) {
        this.igv = igv;
    }
    public Integer getEstadoCompra() {
        return estadoCompra;
    }
    public void setEstadoCompra(Integer estadoCompra) {
        this.estadoCompra = estadoCompra;
    }
    public String getTipoCompra() {
        return tipoCompra;
    }
    public void setTipoCompra(String tipoCompra) {
        this.tipoCompra = tipoCompra;
    }
    public Boolean getActivo() {
        return activo;
    }
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }
    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public Integer getIdProveedor() {
        return idProveedor;
    }
    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }
    public Integer getIdOrden() {
        return idOrden;
    }
    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }
    public Integer getIdEmpresa() {
        return idEmpresa;
    }
    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    public Integer getIdTipoPago() {
        return idTipoPago;
    }
    public void setIdTipoPago(Integer idTipoPago) {
        this.idTipoPago = idTipoPago;
    }
}