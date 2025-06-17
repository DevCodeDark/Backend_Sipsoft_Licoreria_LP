package com.sipsoft.licoreria.dto;

public class DetalleCompraDTO {
    private Integer idDetalleCompra;
    private Integer cantidadCompra;
    private Float precioCompra;
    private Float subtotalCompra;
    private Float igvDetalle;
    private Float totalDetalle;
    private Integer estadoDetalleCompra;
    private Integer idCompra;
    private Integer idLote;
    private Integer idProducto;

    // Getters y Setters
    public Integer getIdDetalleCompra() {
        return idDetalleCompra;
    }
    public void setIdDetalleCompra(Integer idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }
    public Integer getCantidadCompra() {
        return cantidadCompra;
    }
    public void setCantidadCompra(Integer cantidadCompra) {
        this.cantidadCompra = cantidadCompra;
    }
    public Float getPrecioCompra() {
        return precioCompra;
    }
    public void setPrecioCompra(Float precioCompra) {
        this.precioCompra = precioCompra;
    }
    public Float getSubtotalCompra() {
        return subtotalCompra;
    }
    public void setSubtotalCompra(Float subtotalCompra) {
        this.subtotalCompra = subtotalCompra;
    }
    public Float getIgvDetalle() {
        return igvDetalle;
    }
    public void setIgvDetalle(Float igvDetalle) {
        this.igvDetalle = igvDetalle;
    }
    public Float getTotalDetalle() {
        return totalDetalle;
    }
    public void setTotalDetalle(Float totalDetalle) {
        this.totalDetalle = totalDetalle;
    }
    public Integer getEstadoDetalleCompra() {
        return estadoDetalleCompra;
    }
    public void setEstadoDetalleCompra(Integer estadoDetalleCompra) {
        this.estadoDetalleCompra = estadoDetalleCompra;
    }
    public Integer getIdCompra() {
        return idCompra;
    }
    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }
    public Integer getIdLote() {
        return idLote;
    }
    public void setIdLote(Integer idLote) {
        this.idLote = idLote;
    }
    public Integer getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }    
}