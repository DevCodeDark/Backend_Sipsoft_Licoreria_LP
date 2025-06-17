package com.sipsoft.licoreria.entity;

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
@Table(name = "tipo_movimientos_stock")
public class TipoMovimientosStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoMovimiento;
    private String descripcionMovimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpresa")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empresa idEmpresa;

    public TipoMovimientosStock() {
    }

    public TipoMovimientosStock(Integer id){
        this.idTipoMovimiento = id;
    }

    public Integer getIdTipoMovimiento() {
        return idTipoMovimiento;
    }

    public void setIdTipoMovimiento(Integer idTipoMovimiento) {
        this.idTipoMovimiento = idTipoMovimiento;
    }

    public String getDescripcionMovimiento() {
        return descripcionMovimiento;
    }

    public void setDescripcionMovimiento(String descripcionMovimiento) {
        this.descripcionMovimiento = descripcionMovimiento;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public String toString() {
        return "TipoMovimientosStock [idTipoMovimiento=" + idTipoMovimiento + ", descripcionMovimiento="
                + descripcionMovimiento + ", idEmpresa=" + idEmpresa + "]";
    }
    
}
