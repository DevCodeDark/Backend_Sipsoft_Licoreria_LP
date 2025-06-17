package com.sipsoft.licoreria.dto;

public class DetalleVentaDTO {
    private Integer idDetalleVenta;
    private Float precioUnitario;
    private Float descuentoVenta;
    private Integer cantidadVenta;
    private Float subtotalVenta;
    private Integer estadoDetalleVenta;
    private String tipoDescuento;
    private Integer idVenta;
    private Integer idLote;

    // Getters y Setters
    public Integer getIdDetalleVenta() {
        return idDetalleVenta;
    }
    public void setIdDetalleVenta(Integer idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }
    public Float getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(Float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public Float getDescuentoVenta() {
        return descuentoVenta;
    }
    public void setDescuentoVenta(Float descuentoVenta) {
        this.descuentoVenta = descuentoVenta;
    }
    public Integer getCantidadVenta() {
        return cantidadVenta;
    }
    public void setCantidadVenta(Integer cantidadVenta) {
        this.cantidadVenta = cantidadVenta;
    }
    public Float getSubtotalVenta() {
        return subtotalVenta;
    }
    public void setSubtotalVenta(Float subtotalVenta) {
        this.subtotalVenta = subtotalVenta;
    }
    public Integer getEstadoDetalleVenta() {
        return estadoDetalleVenta;
    }
    public void setEstadoDetalleVenta(Integer estadoDetalleVenta) {
        this.estadoDetalleVenta = estadoDetalleVenta;
    }
    public String getTipoDescuento() {
        return tipoDescuento;
    }
    public void setTipoDescuento(String tipoDescuento) {
        this.tipoDescuento = tipoDescuento;
    }
    public Integer getIdVenta() {
        return idVenta;
    }
    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }
    public Integer getIdLote() {
        return idLote;
    }
    public void setIdLote(Integer idLote) {
        this.idLote = idLote;
    }    
}