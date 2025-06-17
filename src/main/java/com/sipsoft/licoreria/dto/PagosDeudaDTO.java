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
@Table(name = "pagos_deuda")
@SQLDelete(sql = "UPDATE pagos_deuda SET estadoPagosDeuda = 0 WHERE idPagosDeuda = ?")
@Where(clause = "estadoPagosDeuda = 1")
public class PagosDeudaDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPagosDeuda;
    private LocalDateTime fechaPagoParcialDeuda;
    private Float montoAbonado;
    private String observaciones;
    private Integer idDeuda;

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
    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public Integer getIdDeuda() {
        return idDeuda;
    }
    public void setIdDeuda(Integer idDeuda) {
        this.idDeuda = idDeuda;
    }
    @Override
    public String toString() {
        return "PagosDeudaDTO [idPagosDeuda=" + idPagosDeuda + ", fechaPagoParcialDeuda=" + fechaPagoParcialDeuda
                + ", montoAbonado=" + montoAbonado + ", observaciones=" + observaciones + ", idDeuda=" + idDeuda + "]";
    }       

}
