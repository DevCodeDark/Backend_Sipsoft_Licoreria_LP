package com.sipsoft.licoreria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleVenta;
    private Float precioUnitario;
    private Float descuentoVenta;
    private Integer cantidadVenta;
    private Float subtotalVenta;
    private Integer estadoDetalleVenta = 1;
    private String tipoDescuento;
    private Integer idVenta;
    private Integer idLote;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idVenta", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Venta venta;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLote", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Lote lote;

    // --- Constructores, Getters y Setters ---
    public DetalleVenta() {
    }

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

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }
}