package com.sipsoft.licoreria.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_pago")
@SQLDelete(sql = "UPDATE tipo_pago SET estadoTipoPago = 0 WHERE idTipoPago = ?")
@Where(clause = "estadoTipoPago = 1")
public class TipoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoPago;
    private String descripcionPago;
    private Integer estadoTipoPago = 1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpresa")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empresa idEmpresa;

    public TipoPago() {
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

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    public TipoPago(Integer id) { this.idTipoPago = id; }
    @Override
    public String toString() {
        return "TipoPago [idTipoPago=" + idTipoPago + ", descripcionPago=" + descripcionPago + ", estadoTipoPago="
                + estadoTipoPago + ", idEmpresa=" + idEmpresa + "]";
    }

    
    
}
