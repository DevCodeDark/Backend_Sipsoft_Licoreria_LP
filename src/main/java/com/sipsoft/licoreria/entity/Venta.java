package com.sipsoft.licoreria.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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
@Table(name = "venta")
@SQLDelete(sql = "UPDATE venta SET estadoVenta = 0 WHERE idVenta = ?")
@Where(clause = "estadoVenta = 1")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;
    private LocalDateTime fechaVenta;
    private Float montoTotalVenta;
    private LocalDateTime fechaAnulacion;
    private String direccion;
    private String referencia;
    private Integer estadoVenta = 1;
    private String tipoDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Cliente idCliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCaja")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Caja idCaja;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTransaccion")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Transaccion idTransaccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario idUsuario;
    
    public Venta() {
    }
    public Venta(Integer id) { this.idVenta = id; }
    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Float getMontoTotalVenta() {
        return montoTotalVenta;
    }

    public void setMontoTotalVenta(Float montoTotalVenta) {
        this.montoTotalVenta = montoTotalVenta;
    }

    public LocalDateTime getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(LocalDateTime fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Integer getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(Integer estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Caja getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(Caja idCaja) {
        this.idCaja = idCaja;
    }

    public Transaccion getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Transaccion idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Venta [idVenta=" + idVenta + ", fechaVenta=" + fechaVenta + ", montoTotalVenta=" + montoTotalVenta
                + ", fechaAnulacion=" + fechaAnulacion + ", direccion=" + direccion + ", referencia=" + referencia
                + ", estadoVenta=" + estadoVenta + ", tipoDocumento=" + tipoDocumento + ", idCliente=" + idCliente
                + ", idCaja=" + idCaja + ", idTransaccion=" + idTransaccion + ", idUsuario=" + idUsuario + "]";
    }
}
