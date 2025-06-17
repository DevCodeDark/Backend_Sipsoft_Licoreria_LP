package com.sipsoft.licoreria.dto;

import java.time.LocalDateTime;

public class CajaDTO {
    private Integer idCaja;
    private String numCaja;
    private Float montoInicialCaja;
    private Float montoFinalCaja;
    private LocalDateTime fechaaperturaCaja;
    private LocalDateTime fechacierreCaja;
    private Integer estadoCaja;
    private Integer idSucursal;
    private Integer idUsuarioApertura;
    private Integer idUsuarioCierre;

    // Getters y Setters
    public Integer getIdCaja() {
        return idCaja;
    }
    public void setIdCaja(Integer idCaja) {
        this.idCaja = idCaja;
    }
    public String getNumCaja() {
        return numCaja;
    }
    public void setNumCaja(String numCaja) {
        this.numCaja = numCaja;
    }
    public Float getMontoInicialCaja() {
        return montoInicialCaja;
    }
    public void setMontoInicialCaja(Float montoInicialCaja) {
        this.montoInicialCaja = montoInicialCaja;
    }
    public Float getMontoFinalCaja() {
        return montoFinalCaja;
    }
    public void setMontoFinalCaja(Float montoFinalCaja) {
        this.montoFinalCaja = montoFinalCaja;
    }
    public LocalDateTime getFechaaperturaCaja() {
        return fechaaperturaCaja;
    }
    public void setFechaaperturaCaja(LocalDateTime fechaaperturaCaja) {
        this.fechaaperturaCaja = fechaaperturaCaja;
    }
    public LocalDateTime getFechacierreCaja() {
        return fechacierreCaja;
    }
    public void setFechacierreCaja(LocalDateTime fechacierreCaja) {
        this.fechacierreCaja = fechacierreCaja;
    }
    public Integer getEstadoCaja() {
        return estadoCaja;
    }
    public void setEstadoCaja(Integer estadoCaja) {
        this.estadoCaja = estadoCaja;
    }
    public Integer getIdSucursal() {
        return idSucursal;
    }
    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }
    public Integer getIdUsuarioApertura() {
        return idUsuarioApertura;
    }
    public void setIdUsuarioApertura(Integer idUsuarioApertura) {
        this.idUsuarioApertura = idUsuarioApertura;
    }
    public Integer getIdUsuarioCierre() {
        return idUsuarioCierre;
    }
    public void setIdUsuarioCierre(Integer idUsuarioCierre) {
        this.idUsuarioCierre = idUsuarioCierre;
    }    
}