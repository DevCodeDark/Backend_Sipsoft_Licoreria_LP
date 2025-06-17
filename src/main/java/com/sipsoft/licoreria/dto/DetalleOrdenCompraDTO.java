package com.sipsoft.licoreria.dto;

public class DetalleOrdenCompraDTO {
    private Integer idDetalleOrden;
    private Boolean activo;
    private Integer cantidadSolicitada;
    private String observacionesDetalle;
    private Float precioUnitario;
    private Integer idOrden;
    private Integer idProducto;

    // Getters y Setters
    public Integer getIdDetalleOrden() {
        return idDetalleOrden;
    }
    public void setIdDetalleOrden(Integer idDetalleOrden) {
        this.idDetalleOrden = idDetalleOrden;
    }
    public Boolean getActivo() {
        return activo;
    }
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    public Integer getCantidadSolicitada() {
        return cantidadSolicitada;
    }
    public void setCantidadSolicitada(Integer cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }
    public String getObservacionesDetalle() {
        return observacionesDetalle;
    }
    public void setObservacionesDetalle(String observacionesDetalle) {
        this.observacionesDetalle = observacionesDetalle;
    }
    public Float getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(Float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public Integer getIdOrden() {
        return idOrden;
    }
    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }
    public Integer getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    } 
}