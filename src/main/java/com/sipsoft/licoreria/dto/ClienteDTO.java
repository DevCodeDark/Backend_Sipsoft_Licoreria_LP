package com.sipsoft.licoreria.dto;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "cliente")
@SQLDelete(sql = "UPDATE cliente SET estadoCliente = 0 WHERE idCliente = ?")
@Where(clause = "estadoCliente = 1")
public class ClienteDTO {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer idCliente;
    private String numDocumento;
    private String razonSocial;
    private String nombreCliente;
    private String apellidoCliente;
    private String telefonoCliente;
    private Integer frecuenciaCompra;
    private Float montoTotalComprado;
    private Integer estadoCliente = 1;
    private String nombreRazonSocial;
    private String tipoCliente;
    private Integer idEmpresa;

    public Integer getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public String getNumDocumento() {
        return numDocumento;
    }
    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }
    public String getRazonSocial() {
        return razonSocial;
    }
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    public String getNombreCliente() {
        return nombreCliente;
    }
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    public String getApellidoCliente() {
        return apellidoCliente;
    }
    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }
    public String getTelefonoCliente() {
        return telefonoCliente;
    }
    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }
    public Integer getFrecuenciaCompra() {
        return frecuenciaCompra;
    }
    public void setFrecuenciaCompra(Integer frecuenciaCompra) {
        this.frecuenciaCompra = frecuenciaCompra;
    }
    public Float getMontoTotalComprado() {
        return montoTotalComprado;
    }
    public void setMontoTotalComprado(Float montoTotalComprado) {
        this.montoTotalComprado = montoTotalComprado;
    }
    public Integer getEstadoCliente() {
        return estadoCliente;
    }
    public void setEstadoCliente(Integer estadoCliente) {
        this.estadoCliente = estadoCliente;
    }
    public String getNombreRazonSocial() {
        return nombreRazonSocial;
    }
    public void setNombreRazonSocial(String nombreRazonSocial) {
        this.nombreRazonSocial = nombreRazonSocial;
    }
    public String getTipoCliente() {
        return tipoCliente;
    }
    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    public Integer getIdEmpresa() {
        return idEmpresa;
    }
    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    @Override
    public String toString() {
        return "ClienteDTO [idCliente=" + idCliente + ", numDocumento=" + numDocumento + ", razonSocial=" + razonSocial
                + ", nombreCliente=" + nombreCliente + ", apellidoCliente=" + apellidoCliente + ", telefonoCliente="
                + telefonoCliente + ", frecuenciaCompra=" + frecuenciaCompra + ", montoTotalComprado="
                + montoTotalComprado + ", estadoCliente=" + estadoCliente + ", nombreRazonSocial=" + nombreRazonSocial
                + ", tipoCliente=" + tipoCliente + ", idEmpresa=" + idEmpresa + "]";
    }
    

    
    

}
