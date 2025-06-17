package com.sipsoft.licoreria.dto;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sucursal")
@SQLDelete(sql = "UPDATE sucursal SET estadoSucursal = 0 WHERE idSucursal = ?")
@Where(clause = "estadoSucursal = 1")
public class SucursalDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSucursal;
    private String ubicacionSucursal;
    private Integer idEmpresa;

    public Integer getIdSucursal() {
        return idSucursal;
    }
    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }
    public String getUbicacionSucursal() {
        return ubicacionSucursal;
    }
    public void setUbicacionSucursal(String ubicacionSucursal) {
        this.ubicacionSucursal = ubicacionSucursal;
    }
    public Integer getIdEmpresa() {
        return idEmpresa;
    }
    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    @Override
    public String toString() {
        return "SucursalDTO [idSucursal=" + idSucursal + ", ubicacionSucursal=" + ubicacionSucursal + ", idEmpresa="
                + idEmpresa + "]";
    }
    
    
}
