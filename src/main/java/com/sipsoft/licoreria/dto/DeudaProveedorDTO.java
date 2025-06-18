package com.sipsoft.licoreria.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DeudaProveedorDTO {
    private Integer idDeuda;
    private Integer idCompra;
    private LocalDateTime fechaInicioDeuda;
    private BigDecimal montoDeuda;
    private BigDecimal montoPagado;
    private LocalDateTime fechaLimiteDeuda;
    private Integer estadoDeuda;
    
    public DeudaProveedorDTO() {
    }

    public Integer getIdDeuda() {
        return idDeuda;
    }

    public void setIdDeuda(Integer idDeuda) {
        this.idDeuda = idDeuda;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public LocalDateTime getFechaInicioDeuda() {
        return fechaInicioDeuda;
    }

    public void setFechaInicioDeuda(LocalDateTime fechaInicioDeuda) {
        this.fechaInicioDeuda = fechaInicioDeuda;
    }

    public BigDecimal getMontoDeuda() {
        return montoDeuda;
    }

    public void setMontoDeuda(BigDecimal montoDeuda) {
        this.montoDeuda = montoDeuda;
    }

    public BigDecimal getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(BigDecimal montoPagado) {
        this.montoPagado = montoPagado;
    }

    public LocalDateTime getFechaLimiteDeuda() {
        return fechaLimiteDeuda;
    }

    public void setFechaLimiteDeuda(LocalDateTime fechaLimiteDeuda) {
        this.fechaLimiteDeuda = fechaLimiteDeuda;
    }

    public Integer getEstadoDeuda() {
        return estadoDeuda;
    }

    public void setEstadoDeuda(Integer estadoDeuda) {
        this.estadoDeuda = estadoDeuda;
    }

    @Override
    public String toString() {
        return "DeudaProveedorDTO [idDeuda=" + idDeuda + ", idCompra=" + idCompra + ", fechaInicioDeuda=" + fechaInicioDeuda +
               ", montoDeuda=" + montoDeuda + ", montoPagado=" + montoPagado + ", fechaLimiteDeuda=" + fechaLimiteDeuda +
               ", estadoDeuda=" + estadoDeuda + "]";
    }
}
