package com.sipsoft.licoreria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "detalle_orden_compra")
@SQLDelete(sql = "UPDATE detalle_orden_compra SET activo = 0 WHERE idDetalleOrden = ?")
@Where(clause = "activo = 1")
public class DetalleOrdenCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleOrden;
    private Boolean activo = true;
    private Integer cantidadSolicitada;
    @Column(name = "observacionesDet")
    private String observacionesDetalle;

    private Float precioUnitario;
    private Integer idOrden;
    private Integer idProducto;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idOrden", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private OrdenCompra ordenCompra;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProducto", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Producto producto;

    // --- Constructores, Getters y Setters---
    public DetalleOrdenCompra() {
    }

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

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}