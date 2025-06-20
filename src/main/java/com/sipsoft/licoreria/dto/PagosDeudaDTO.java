package com.sipsoft.licoreria.dto;

import java.time.LocalDateTime;

public class PagosDeudaDTO {
    private Integer idPagosDeuda;
    private LocalDateTime fechaPagoParcialDeuda;
    private Float montoAbonado;
    private String observaciones;
    private Integer idDeuda;
    private Integer estadoPagosDeuda;

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

    public Integer getEstadoPagosDeuda() {
        return estadoPagosDeuda;
    }

    public void setEstadoPagosDeuda(Integer estadoPagosDeuda) {
        this.estadoPagosDeuda = estadoPagosDeuda;
    }

    @Override
    public String toString() {
        return "PagosDeudaDTO [idPagosDeuda=" + idPagosDeuda + ", fechaPagoParcialDeuda=" + fechaPagoParcialDeuda
                + ", montoAbonado=" + montoAbonado + ", observaciones=" + observaciones + ", idDeuda=" + idDeuda
                + ", estadoPagosDeuda=" + estadoPagosDeuda + "]";
    }

}
