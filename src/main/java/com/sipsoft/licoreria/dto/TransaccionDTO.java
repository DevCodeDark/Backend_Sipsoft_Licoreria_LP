package com.sipsoft.licoreria.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaccion")
@SQLDelete(sql = "UPDATE transaccion SET estado = 0 WHERE idTransaccion = ?")
@Where(clause = "estado = 1")
public class TransaccionDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTransaccion;
    private String motivoTransaccion;
    private Float montoTransaccion;
    private String tipo;
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
    public Float getMontoTransaccion() {
        return montoTransaccion;
    }
    public void setMontoTransaccion(Float montoTransaccion) {
        this.montoTransaccion = montoTransaccion;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
                + ", montoTransaccion=" + montoTransaccion + ", tipo=" + tipo + ", fechaTransaccion=" + fechaTransaccion
                + ", idTipoPago=" + idTipoPago + ", idUsuario=" + idUsuario + ", idCaja=" + idCaja + "]";
    }

    
    
}
