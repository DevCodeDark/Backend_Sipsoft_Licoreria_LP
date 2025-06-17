package com.sipsoft.licoreria.entity;

import java.time.LocalDate;

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
@Table(name = "contrato_proveedor")
@SQLDelete(sql = "UPDATE contrato_proveedor SET estadoContrato = 0 WHERE idContratoProveedor = ?")
@Where(clause = "estadoContratoProveedor = 1")
public class ContratoProveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContratoProveedor;
    private String rutaPdfContratoProveedor;
    private LocalDate fechaInicioContratoProveedor;
    private LocalDate fechaFinContratoProveedor;
    private String detallesContrato;
    private Integer estadoContratoProveedor = 1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProveedor")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Proveedor idProveedor;

    public ContratoProveedor() {
    }

    public ContratoProveedor( Integer id){
        this.idContratoProveedor = id;
    }

    public Integer getIdContratoProveedor() {
        return idContratoProveedor;
    }

    public void setIdContratoProveedor(Integer idContratoProveedor) {
        this.idContratoProveedor = idContratoProveedor;
    }

    public String getRutaPdfContratoProveedor() {
        return rutaPdfContratoProveedor;
    }

    public void setRutaPdfContratoProveedor(String rutaPdfContratoProveedor) {
        this.rutaPdfContratoProveedor = rutaPdfContratoProveedor;
    }

    public LocalDate getFechaInicioContratoProveedor() {
        return fechaInicioContratoProveedor;
    }

    public void setFechaInicioContratoProveedor(LocalDate fechaInicioContratoProveedor) {
        this.fechaInicioContratoProveedor = fechaInicioContratoProveedor;
    }

    public LocalDate getFechaFinContratoProveedor() {
        return fechaFinContratoProveedor;
    }

    public void setFechaFinContratoProveedor(LocalDate fechaFinContratoProveedor) {
        this.fechaFinContratoProveedor = fechaFinContratoProveedor;
    }

    public String getDetallesContrato() {
        return detallesContrato;
    }

    public void setDetallesContrato(String detallesContrato) {
        this.detallesContrato = detallesContrato;
    }

    public Integer getEstadoContratoProveedor() {
        return estadoContratoProveedor;
    }

    public void setEstadoContratoProveedor(Integer estadoContratoProveedor) {
        this.estadoContratoProveedor = estadoContratoProveedor;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public String toString() {
        return "ContratoProveedor [idContratoProveedor=" + idContratoProveedor + ", rutaPdfContratoProveedor="
                + rutaPdfContratoProveedor + ", fechaInicioContratoProveedor=" + fechaInicioContratoProveedor
                + ", fechaFinContratoProveedor=" + fechaFinContratoProveedor + ", detallesContrato=" + detallesContrato
                + ", estadoContratoProveedor=" + estadoContratoProveedor + ", idProveedor=" + idProveedor + "]";
    }

   
}
