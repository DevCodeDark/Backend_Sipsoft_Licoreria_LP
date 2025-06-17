package com.sipsoft.licoreria.dto;

public class MultiPagoDTO {
    private Integer idMultiPago;
    private Float montoPagado;
    private Integer idVenta;
    private Integer idTipoPago;

    // Getters y Setters
    public Integer getIdMultiPago() {
        return idMultiPago;
    }
    public void setIdMultiPago(Integer idMultiPago) {
        this.idMultiPago = idMultiPago;
    }
    public Float getMontoPagado() {
        return montoPagado;
    }
    public void setMontoPagado(Float montoPagado) {
        this.montoPagado = montoPagado;
    }
    public Integer getIdVenta() {
        return idVenta;
    }
    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }
    public Integer getIdTipoPago() {
        return idTipoPago;
    }
    public void setIdTipoPago(Integer idTipoPago) {
        this.idTipoPago = idTipoPago;
    }
}