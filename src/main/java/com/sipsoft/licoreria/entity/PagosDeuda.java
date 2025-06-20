package com.sipsoft.licoreria.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagos_deuda")
@SQLDelete(sql = "UPDATE pagos_deuda SET estadoPagosDeuda = 0 WHERE idPagosDeuda = ?")
@SQLRestriction("estadoPagosDeuda = 1")
public class PagosDeuda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPagosDeuda;
    private LocalDateTime fechaPagoParcialDeuda;
    private Float montoAbonado;
    private Integer estadoPagosDeuda = 1;
    private String observaciones;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDeuda")
    @JsonIgnore
    private DeudaProveedor idDeuda;

    public Integer getIdPagosDeuda() {
        return idPagosDeuda;
    }

    public void setIdPagosDeuda(Integer idPagosDeuda) {
        this.idPagosDeuda = idPagosDeuda;
    }

    public LocalDateTime getFechaPagoParcialDeuda() {
        return fechaPagoParcialDeuda;
    }

    public void setFechaPagoParcialDeuda(LocalDateTime fechaPagoParcialDeuda) {
        this.fechaPagoParcialDeuda = fechaPagoParcialDeuda;
    }

    public Float getMontoAbonado() {
        return montoAbonado;
    }

    public void setMontoAbonado(Float montoAbonado) {
        this.montoAbonado = montoAbonado;
    }

    public Integer getEstadoPagosDeuda() {
        return estadoPagosDeuda;
    }

    public void setEstadoPagosDeuda(Integer estadoPagosDeuda) {
        this.estadoPagosDeuda = estadoPagosDeuda;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public DeudaProveedor getIdDeuda() {
        return idDeuda;
    }

    public void setIdDeuda(DeudaProveedor idDeuda) {
        this.idDeuda = idDeuda;
    }

    // Método helper para obtener ID de la relación
    public Integer getDeudaId() {
        return idDeuda != null ? idDeuda.getIdDeuda() : null;
    }

    @Override
    public String toString() {
        return "PagosDeuda [idPagosDeuda=" + idPagosDeuda + ", fechaPagoParcialDeuda=" + fechaPagoParcialDeuda
                + ", montoAbonado=" + montoAbonado + ", estadoPagosDeuda=" + estadoPagosDeuda + ", observaciones="
                + observaciones + ", idDeuda=" + idDeuda + "]";
    }

}
