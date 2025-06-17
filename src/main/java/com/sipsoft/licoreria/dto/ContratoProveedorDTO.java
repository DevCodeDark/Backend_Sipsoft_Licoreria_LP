package com.sipsoft.licoreria.dto;

import java.time.LocalDate;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import jakarta.persistence.Table;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "contrato_proveedor")
@SQLDelete(sql = "UPDATE contrato_proveedor SET estadoContratoProveedor = 0 WHERE idContratoProveedor = ?")
@Where(clause = "estadoContratoProveedor = 1")
public class ContratoProveedorDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContratoProveedor;
    private String rutaPdfContratoProveedor;
    private LocalDate fechaInicioContratoProveedor;
    private LocalDate fechaFinContratoProveedor;
    private String detallesContrato;
    private Integer estadoContratoProveedor = 1;
    private Integer idProveedor;
    
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
    public Integer getIdProveedor() {
        return idProveedor;
    }
    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }
    @Override
    public String toString() {
        return "ContratoProveedorDTO [idContratoProveedor=" + idContratoProveedor + ", rutaPdfContratoProveedor="
                + rutaPdfContratoProveedor + ", fechaInicioContratoProveedor=" + fechaInicioContratoProveedor
                + ", fechaFinContratoProveedor=" + fechaFinContratoProveedor + ", detallesContrato=" + detallesContrato
                + ", estadoContratoProveedor=" + estadoContratoProveedor + ", idProveedor=" + idProveedor + "]";
    }

    
}
