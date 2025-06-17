package com.sipsoft.licoreria.dto;

import java.time.LocalDateTime;
import java.util.List;

public class VentaDTO {
    private Integer idVenta;
    private LocalDateTime fechaVenta;
    private Float montoTotalVenta;
    private LocalDateTime fechaAnulacion;
    private String direccion;
    private String referencia;
    private Integer estadoVenta = 1;
    private String tipoDocumento;
    private Integer idCliente;
    private Integer idCaja;
    private Integer idTransaccion;
    private Integer idUsuario;
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
    public Integer getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public Integer getIdCaja() {
        return idCaja;
    }
    public void setIdCaja(Integer idCaja) {
        this.idCaja = idCaja;
    }
    public Integer getIdTransaccion() {
        return idTransaccion;
    }
    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }
    public Integer getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    @Override
    public String toString() {
        return "VentaDTO [idVenta=" + idVenta + ", fechaVenta=" + fechaVenta + ", montoTotalVenta=" + montoTotalVenta
                + ", fechaAnulacion=" + fechaAnulacion + ", direccion=" + direccion + ", referencia=" + referencia
                + ", estadoVenta=" + estadoVenta + ", tipoDocumento=" + tipoDocumento + ", idCliente=" + idCliente
                + ", idCaja=" + idCaja + ", idTransaccion=" + idTransaccion + ", idUsuario=" + idUsuario + "]";
    }
}
