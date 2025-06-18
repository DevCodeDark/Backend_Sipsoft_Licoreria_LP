package com.sipsoft.licoreria.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "deuda_proveedor")
@SQLDelete(sql = "UPDATE deuda_proveedor SET estadoDeuda = 0 WHERE idDeuda = ?")
@Where(clause = "estadoDeuda = 1")
public class DeudaProveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDeuda;
    
    @Column(name = "idCompra")
    private Integer idCompra;
    
    private LocalDateTime fechaInicioDeuda;
    private BigDecimal montoDeuda;
    private BigDecimal montoPagado;
    private LocalDateTime fechaLimiteDeuda;
    private Integer estadoDeuda = 1;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCompra", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Compra compra;    public DeudaProveedor() {
    }

    public DeudaProveedor(Integer id) {
        this.idDeuda = id;
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

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    @Override
    public String toString() {
        return "DeudaProveedor [idDeuda=" + idDeuda + ", idCompra=" + idCompra + ", fechaInicioDeuda=" + fechaInicioDeuda + 
               ", montoDeuda=" + montoDeuda + ", montoPagado=" + montoPagado + ", fechaLimiteDeuda=" + fechaLimiteDeuda + 
               ", estadoDeuda=" + estadoDeuda + "]";
    }
}
