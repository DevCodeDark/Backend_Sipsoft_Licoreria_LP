package com.sipsoft.licoreria.dto;

public class ClienteDTO {
    private Integer idCliente;
    private Integer idEmpresa;
    private String numDocumento;
    private String nombreCliente;
    private String apellidoCliente;
    private String telefonoCliente;
    private Integer estadoCliente = 1;
    private String tipoCliente;

    public ClienteDTO() {
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
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

    public Integer getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(Integer estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return "ClienteDTO [idCliente=" + idCliente + ", idEmpresa=" + idEmpresa + ", numDocumento=" + numDocumento
                + ", nombreCliente=" + nombreCliente + ", apellidoCliente=" + apellidoCliente + ", telefonoCliente="
                + telefonoCliente + ", estadoCliente=" + estadoCliente + ", tipoCliente=" + tipoCliente + "]";
    }
}
