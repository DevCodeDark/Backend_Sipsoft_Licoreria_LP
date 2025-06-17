package com.sipsoft.licoreria.dto;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_pago")
@SQLDelete(sql = "UPDATE tipo_pago SET estadoTipoPago = 0 WHERE idTipoPago = ?")
@Where(clause = "estadoTipoPago = 1")
public class TipoPagoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoPago;
    private String descripcionPago;
    private Integer estadoTipoPago = 1;
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
