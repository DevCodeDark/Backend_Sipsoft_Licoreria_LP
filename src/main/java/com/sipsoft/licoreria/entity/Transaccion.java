package com.sipsoft.licoreria.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

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
@Table(name = "transaccion")
@SQLDelete(sql = "UPDATE transaccion SET estado = 0 WHERE idTransaccion = ?")
@SQLRestriction("estado = 1")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTransaccion;
    private String motivoTransaccion;
    private BigDecimal montoTransaccion;
    private String tipo;
    private Integer estado = 1;
    private LocalDateTime fechaTransaccion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoPago")
    @JsonIgnore
    private TipoPago idTipoPago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario")
    @JsonIgnore
    private Usuario idUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCaja")
    @JsonIgnore
    private Caja idCaja;

    public Transaccion() {
    }

    public Transaccion(Integer id) {
        this.idTransaccion = id;
    }

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

    public TipoPago getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(TipoPago idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Caja getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(Caja idCaja) {
        this.idCaja = idCaja;
    }

    // Métodos helper para obtener IDs de las relaciones
    public Integer getTipoPagoId() {
        return idTipoPago != null ? idTipoPago.getIdTipoPago() : null;
    }

    public Integer getUsuarioId() {
        return idUsuario != null ? idUsuario.getIdUsuario() : null;
    }

    public Integer getCajaId() {
        return idCaja != null ? idCaja.getIdCaja() : null;
    }

    @Override
    public String toString() {
        return "Transaccion [idTransaccion=" + idTransaccion + ", motivoTransaccion=" + motivoTransaccion
                + ", montoTransaccion=" + montoTransaccion + ", tipo=" + tipo + ", estado=" + estado
                + ", fechaTransaccion=" + fechaTransaccion + ", idTipoPago=" + idTipoPago + ", idUsuario=" + idUsuario
                + ", idCaja=" + idCaja + "]";
    }

}
