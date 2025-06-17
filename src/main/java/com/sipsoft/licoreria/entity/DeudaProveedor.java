package com.sipsoft.licoreria.entity;

import java.time.LocalDate;

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
@Table(name = "deuda_proveedor")
@SQLDelete(sql = "UPDATE deuda_proveedor SET estadoDeuda = 0 WHERE idDeuda = ?")
@Where(clause = "estadoDeuda = 1")
public class DeudaProveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDeuda;
    private LocalDate fechaDeuda;
    private Float montoDeuda;
    private Float montoPagado;
    private LocalDate fechaLimiteDeuda;
    private Integer estadoDeuda = 1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCompra")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Compra idCompra;

    public DeudaProveedor() {
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

    public LocalDate getFechaDeuda() {
        return fechaDeuda;
    }

    public void setFechaDeuda(LocalDate fechaDeuda) {
        this.fechaDeuda = fechaDeuda;
    }

    public Float getMontoDeuda() {
        return montoDeuda;
    }

    public void setMontoDeuda(Float montoDeuda) {
        this.montoDeuda = montoDeuda;
    }

    public Float getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(Float montoPagado) {
        this.montoPagado = montoPagado;
    }

    public LocalDate getFechaLimiteDeuda() {
        return fechaLimiteDeuda;
    }

    public void setFechaLimiteDeuda(LocalDate fechaLimiteDeuda) {
        this.fechaLimiteDeuda = fechaLimiteDeuda;
    }

    public Integer getEstadoDeuda() {
        return estadoDeuda;
    }

    public void setEstadoDeuda(Integer estadoDeuda) {
        this.estadoDeuda = estadoDeuda;
    }

    public Compra getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Compra idCompra) {
        this.idCompra = idCompra;
    }

    @Override
    public String toString() {
        return "DeudaProveedor [idDeuda=" + idDeuda + ", fechaDeuda=" + fechaDeuda + ", montoDeuda=" + montoDeuda
                + ", montoPagado=" + montoPagado + ", fechaLimiteDeuda=" + fechaLimiteDeuda + ", estadoDeuda="
                + estadoDeuda + ", idCompra=" + idCompra + "]";
    }

    
    
}
