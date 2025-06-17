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
@Table(name = "sucursal")
@SQLDelete(sql = "UPDATE sucursal SET estadoSucursal = 0 WHERE idSucursal = ?")
@Where(clause = "estadoSucursal = 1")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSucursal;
    private String ubicacionSucursal;
    private Integer estadoSucursal = 1;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpresa")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empresa idEmpresa;

    public Sucursal() {
    }

    public Sucursal (Integer id){
        this.idSucursal=id;
    }

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

    public Integer getEstadoSucursal() {
        return estadoSucursal;
    }

    public void setEstadoSucursal(Integer estadoSucursal) {
        this.estadoSucursal = estadoSucursal;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public String toString() {
        return "Sucursal [idSucursal=" + idSucursal + ", ubicacionSucursal=" + ubicacionSucursal + ", estadoSucursal="
                + estadoSucursal + ", idEmpresa=" + idEmpresa + "]";
    }

    
}
