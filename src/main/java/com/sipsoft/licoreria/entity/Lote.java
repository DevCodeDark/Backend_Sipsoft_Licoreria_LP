package com.sipsoft.licoreria.entity;

import java.time.LocalDate;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lote")
@SQLDelete(sql = "UPDATE lote SET estadoLote = 0 WHERE idLote = ?")
@Where(clause = "estadoLote = 1")
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLote;
    private String codLote;
    private LocalDate fechaEntradaLote;
    private LocalDate fechaVencimientoLote;
    private Integer stockInicial;
    private Integer stockActual;
    private Integer flagLote;
    private Integer estadoLote = 1;
    private Integer idProducto;
    private Integer idAlmacen;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProducto", insertable = false, updatable = false)
    @JsonIgnore
    private Producto producto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAlmacen", insertable = false, updatable = false)
    @JsonIgnore
    private Almacen almacen;

    public Lote() {
    }

    public Lote(Integer id) {
        this.idLote = id;
    }

    public Integer getIdLote() {
        return idLote;
    }

    public void setIdLote(Integer idLote) {
        this.idLote = idLote;
    }

    public String getCodLote() {
        return codLote;
    }

    public void setCodLote(String codLote) {
        this.codLote = codLote;
    }

    public LocalDate getFechaEntradaLote() {
        return fechaEntradaLote;
    }

    public void setFechaEntradaLote(LocalDate fechaEntradaLote) {
        this.fechaEntradaLote = fechaEntradaLote;
    }

    public LocalDate getFechaVencimientoLote() {
        return fechaVencimientoLote;
    }

    public void setFechaVencimientoLote(LocalDate fechaVencimientoLote) {
        this.fechaVencimientoLote = fechaVencimientoLote;
    }

    public Integer getStockInicial() {
        return stockInicial;
    }

    public void setStockInicial(Integer stockInicial) {
        this.stockInicial = stockInicial;
    }

    public Integer getStockActual() {
        return stockActual;
    }

    public void setStockActual(Integer stockActual) {
        this.stockActual = stockActual;
    }

    public Integer getFlagLote() {
        return flagLote;
    }

    public void setFlagLote(Integer flagLote) {
        this.flagLote = flagLote;
    }

    public Integer getEstadoLote() {
        return estadoLote;
    }

    public void setEstadoLote(Integer estadoLote) {
        this.estadoLote = estadoLote;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(Integer idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public String toString() {
        return "Lote [idLote=" + idLote + ", codLote=" + codLote + ", fechaEntradaLote=" + fechaEntradaLote
                + ", fechaVencimientoLote=" + fechaVencimientoLote + ", stockInicial=" + stockInicial + ", stockActual="
                + stockActual + ", flagLote=" + flagLote + ", estadoLote=" + estadoLote + ", idProducto=" + idProducto
                + ", idAlmacen=" + idAlmacen + "]";
    }
}
