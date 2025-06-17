package com.sipsoft.licoreria.dto;

import java.time.LocalDate;

public class ComprobanteDTO {
    private Integer idComprobante;
    private String correlativoComprobante;
    private Integer estadoComprobante;
    private String direccionEmpresa;
    private LocalDate fechaEmision;
    private String nombreComprobante;
    private String numComprobante;
    private String telefonoEmpresa;
    private Integer idVenta;
    private Integer idSerie;
    private Integer idCaja;
    private Integer idCompra;
    private Integer idTipoComprobante;

    // Getters y Setters
    public Integer getIdComprobante() {
        return idComprobante;
    }
    public void setIdComprobante(Integer idComprobante) {
        this.idComprobante = idComprobante;
    }
    public String getCorrelativoComprobante() {
        return correlativoComprobante;
    }
    public void setCorrelativoComprobante(String correlativoComprobante) {
        this.correlativoComprobante = correlativoComprobante;
    }
    public Integer getEstadoComprobante() {
        return estadoComprobante;
    }
    public void setEstadoComprobante(Integer estadoComprobante) {
        this.estadoComprobante = estadoComprobante;
    }
    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }
    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }
    public LocalDate getFechaEmision() {
        return fechaEmision;
    }
    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
    public String getNombreComprobante() {
        return nombreComprobante;
    }
    public void setNombreComprobante(String nombreComprobante) {
        this.nombreComprobante = nombreComprobante;
    }
    public String getNumComprobante() {
        return numComprobante;
    }
    public void setNumComprobante(String numComprobante) {
        this.numComprobante = numComprobante;
    }
    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }
    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }
    public Integer getIdVenta() {
        return idVenta;
    }
    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }
    public Integer getIdSerie() {
        return idSerie;
    }
    public void setIdSerie(Integer idSerie) {
        this.idSerie = idSerie;
    }
    public Integer getIdCaja() {
        return idCaja;
    }
    public void setIdCaja(Integer idCaja) {
        this.idCaja = idCaja;
    }
    public Integer getIdCompra() {
        return idCompra;
    }
    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }
    public Integer getIdTipoComprobante() {
        return idTipoComprobante;
    }
    public void setIdTipoComprobante(Integer idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
    }    
}