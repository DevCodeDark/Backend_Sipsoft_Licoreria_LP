package com.sipsoft.licoreria.dto;

import java.time.LocalDate;

public class ProveedorDTO {
    private Integer idProveedor;
    private String rucProveedor;
    private String nombreProveedor;
    private String telefonoMovilProveedor;
    private String emailProveedor;
    private String logoProveedor;
    private String direccionProveedor;
    private Integer estadoProveedor;
    private String telefonoFijoProveedor;
    private String numeroContactoProveedor;
    private LocalDate fechaRegistroProveedor;
    private Integer idEmpresa;

    // Getters y Setters
    public Integer getIdProveedor() {
        return idProveedor;
    }
    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }
    public String getRucProveedor() {
        return rucProveedor;
    }
    public void setRucProveedor(String rucProveedor) {
        this.rucProveedor = rucProveedor;
    }
    public String getNombreProveedor() {
        return nombreProveedor;
    }
    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }
    public String getTelefonoMovilProveedor() {
        return telefonoMovilProveedor;
    }
    public void setTelefonoMovilProveedor(String telefonoMovilProveedor) {
        this.telefonoMovilProveedor = telefonoMovilProveedor;
    }
    public String getEmailProveedor() {
        return emailProveedor;
    }
    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }
    public String getLogoProveedor() {
        return logoProveedor;
    }
    public void setLogoProveedor(String logoProveedor) {
        this.logoProveedor = logoProveedor;
    }
    public String getDireccionProveedor() {
        return direccionProveedor;
    }
    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }
    public Integer getEstadoProveedor() {
        return estadoProveedor;
    }
    public void setEstadoProveedor(Integer estadoProveedor) {
        this.estadoProveedor = estadoProveedor;
    }
    public String getTelefonoFijoProveedor() {
        return telefonoFijoProveedor;
    }
    public void setTelefonoFijoProveedor(String telefonoFijoProveedor) {
        this.telefonoFijoProveedor = telefonoFijoProveedor;
    }
    public String getNumeroContactoProveedor() {
        return numeroContactoProveedor;
    }
    public void setNumeroContactoProveedor(String numeroContactoProveedor) {
        this.numeroContactoProveedor = numeroContactoProveedor;
    }
    public LocalDate getFechaRegistroProveedor() {
        return fechaRegistroProveedor;
    }
    public void setFechaRegistroProveedor(LocalDate fechaRegistroProveedor) {
        this.fechaRegistroProveedor = fechaRegistroProveedor;
    }
    public Integer getIdEmpresa() {
        return idEmpresa;
    }
    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}