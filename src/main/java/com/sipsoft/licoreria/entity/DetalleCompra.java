package com.sipsoft.licoreria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_compra")
@SQLDelete(sql = "UPDATE detalle_compra SET estadoDetalleCompra = 0 WHERE idDetalleCompra = ?")
@Where(clause = "estadoDetalleCompra = 1")
public class DetalleCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleCompra;
    private Integer cantidadCompra;
    private Float precioCompra;
    private Float subtotalCompra;
    private Float igvDetalle;
    private Float totalDetalle;
    private Integer estadoDetalleCompra = 1;
    private Integer idCompra;
    private Integer idLote;
    private Integer idProducto;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCompra", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Compra compra;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLote", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Lote lote;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProducto", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Producto producto;

    // --- Getters y Setters ---
    public DetalleCompra() {}

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

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}