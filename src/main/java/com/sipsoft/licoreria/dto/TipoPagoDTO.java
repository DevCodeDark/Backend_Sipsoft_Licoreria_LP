package com.sipsoft.licoreria.dto;

public class TipoPagoDTO {
    private Integer idTipoPago;
    private String descripcionPago;
    private Integer estadoTipoPago;
    private Integer idEmpresa;    
    public Integer getIdEmpresa() {
        return idEmpresa;
    }
    
    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    
    public Integer getIdTipoPago() {
        return idTipoPago;
    }
    
    public void setIdTipoPago(Integer idTipoPago) {
        this.idTipoPago = idTipoPago;
    }
    
    public String getDescripcionPago() {
        return descripcionPago;
    }
    
    public void setDescripcionPago(String descripcionPago) {
        this.descripcionPago = descripcionPago;
    }
    
    public Integer getEstadoTipoPago() {
        return estadoTipoPago;
    }
    
    public void setEstadoTipoPago(Integer estadoTipoPago) {
        this.estadoTipoPago = estadoTipoPago;
    }
      @Override
    public String toString() {
        return "TipoPagoDTO [idTipoPago=" + idTipoPago + ", descripcionPago=" + descripcionPago + ", estadoTipoPago="
                + estadoTipoPago + ", idEmpresa=" + idEmpresa + "]";
    }
}
