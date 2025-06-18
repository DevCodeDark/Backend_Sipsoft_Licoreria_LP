package com.sipsoft.licoreria.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransaccionDTO {
    private Integer idTransaccion;
    private String motivoTransaccion;
    private BigDecimal montoTransaccion;
    private String tipo;
    private Integer estado;
    private LocalDateTime fechaTransaccion;
    private Integer idTipoPago;
    private Integer idUsuario; 
    private Integer idCaja;    
    public Integer getIdTransaccion() {
        return idTransaccion;
    }
    
    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }
    
    public String getMotivoTransaccion() {
        return motivoTransaccion;
    }
    
    public void setMotivoTransaccion(String motivoTransaccion) {
        this.motivoTransaccion = motivoTransaccion;
    }
    
    public BigDecimal getMontoTransaccion() {
        return montoTransaccion;
    }
    
    public void setMontoTransaccion(BigDecimal montoTransaccion) {
        this.montoTransaccion = montoTransaccion;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public Integer getEstado() {
        return estado;
    }
    
    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
    public LocalDateTime getFechaTransaccion() {
        return fechaTransaccion;
    }
    
    public void setFechaTransaccion(LocalDateTime fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }
    
    public Integer getIdTipoPago() {
        return idTipoPago;
    }
    
    public void setIdTipoPago(Integer idTipoPago) {
        this.idTipoPago = idTipoPago;
    }
    
    public Integer getIdUsuario() {
        return idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public Integer getIdCaja() {
        return idCaja;
    }
    
    public void setIdCaja(Integer idCaja) {
        this.idCaja = idCaja;
    }
      @Override
    public String toString() {
        return "TransaccionDTO [idTransaccion=" + idTransaccion + ", motivoTransaccion=" + motivoTransaccion
                + ", montoTransaccion=" + montoTransaccion + ", tipo=" + tipo + ", estado=" + estado 
                + ", fechaTransaccion=" + fechaTransaccion + ", idTipoPago=" + idTipoPago + ", idUsuario=" + idUsuario 
                + ", idCaja=" + idCaja + "]";
    }
}
