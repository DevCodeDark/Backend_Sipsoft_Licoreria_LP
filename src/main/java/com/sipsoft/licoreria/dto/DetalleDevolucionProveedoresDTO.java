package com.sipsoft.licoreria.dto;

public class DetalleDevolucionProveedoresDTO {
    private Integer idDetalleDevolucion;
    private Integer cantidadDevolucion;
    private Integer estadoDetalleDevolucionProveedor = 1;
    private Integer idDevolucionCompra;
    private Integer idProducto;

    // Getters y Setters
    public Integer getIdDetalleDevolucion() {
        return idDetalleDevolucion;
    }
    public void setIdDetalleDevolucion(Integer idDetalleDevolucion) {
        this.idDetalleDevolucion = idDetalleDevolucion;
    }
    public Integer getCantidadDevolucion() {
        return cantidadDevolucion;
    }
    public void setCantidadDevolucion(Integer cantidadDevolucion) {
        this.cantidadDevolucion = cantidadDevolucion;
    }
    public Integer getEstadoDetalleDevolucionProveedor() {
        return estadoDetalleDevolucionProveedor;
    }
    public void setEstadoDetalleDevolucionProveedor(Integer estadoDetalleDevolucionProveedor) {
        this.estadoDetalleDevolucionProveedor = estadoDetalleDevolucionProveedor;
    }
    public Integer getIdDevolucionCompra() {
        return idDevolucionCompra;
    }
    public void setIdDevolucionCompra(Integer idDevolucionCompra) {
        this.idDevolucionCompra = idDevolucionCompra;
    }
    public Integer getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    } 
}