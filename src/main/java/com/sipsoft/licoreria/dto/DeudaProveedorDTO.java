package com.sipsoft.licoreria.dto;

import java.time.LocalDate;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "deuda_proveedor")
@SQLDelete(sql = "UPDATE deuda_proveedor SET estadoDeuda = 0 WHERE idDeuda = ?")
@Where(clause = "estadoDeuda = 1")
public class DeudaProveedorDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDeuda;
    private LocalDate fechaDeuda;
    private Float montoDeuda;
    private Float montoPagado;
    private LocalDate fechaLimiteDeuda;
    private Integer idCompra;
    
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
    public Integer getIdCompra() {
        return idCompra;
    }
    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }
    @Override
    public String toString() {
        return "DeudaProveedorDTO [idDeuda=" + idDeuda + ", fechaDeuda=" + fechaDeuda + ", montoDeuda=" + montoDeuda
                + ", montoPagado=" + montoPagado + ", fechaLimiteDeuda=" + fechaLimiteDeuda + ", idCompra=" + idCompra
                + "]";
    }

    

}
