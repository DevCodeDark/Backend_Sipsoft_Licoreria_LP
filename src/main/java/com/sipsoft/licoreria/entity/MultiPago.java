package com.sipsoft.licoreria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "multi_pago")
public class MultiPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMultiPago;
    private Float montoPagado;
    private Integer idVenta;
    private Integer idTipoPago;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idVenta", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Venta venta;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoPago", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TipoPago tipoPago;
    
    // Getters y Setters
    public MultiPago() {}

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

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }
}