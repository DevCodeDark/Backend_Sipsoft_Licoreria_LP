package com.sipsoft.licoreria.entity;

import java.time.LocalDateTime;

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
@Table(name = "movimientos_stock")
public class MovimientosStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovimientoStock;
    private Integer cantidadMovimientoStock;
    private LocalDateTime fechaMovimientoStock;
    private Integer idLote;
    private Integer idTipoMovimiento;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLote", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Lote lote;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoMovimiento", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TipoMovimientosStock tipoMovimiento;

    public Integer getIdMovimientoStock() {
        return idMovimientoStock;
    }

    public void setIdMovimientoStock(Integer idMovimientoStock) {
        this.idMovimientoStock = idMovimientoStock;
    }

    public Integer getCantidadMovimientoStock() {
        return cantidadMovimientoStock;
    }

    public void setCantidadMovimientoStock(Integer cantidadMovimientoStock) {
        this.cantidadMovimientoStock = cantidadMovimientoStock;
    }    public LocalDateTime getFechaMovimientoStock() {
        return fechaMovimientoStock;
    }

    public void setFechaMovimientoStock(LocalDateTime fechaMovimientoStock) {
        this.fechaMovimientoStock = fechaMovimientoStock;
    }

    public Integer getIdLote() {
        return idLote;
    }

    public void setIdLote(Integer idLote) {
        this.idLote = idLote;
    }

    public Integer getIdTipoMovimiento() {
        return idTipoMovimiento;
    }

    public void setIdTipoMovimiento(Integer idTipoMovimiento) {
        this.idTipoMovimiento = idTipoMovimiento;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public TipoMovimientosStock getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimientosStock tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }    @Override
    public String toString() {
        return "MovimientosStock [idMovimientoStock=" + idMovimientoStock + ", cantidadMovimientoStock="
                + cantidadMovimientoStock + ", fechaMovimientoStock=" + fechaMovimientoStock + ", idLote=" + idLote
                + ", idTipoMovimiento=" + idTipoMovimiento + "]";
    }

     
}
