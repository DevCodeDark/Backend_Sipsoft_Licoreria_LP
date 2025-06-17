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
@Table(name = "almacen")
@SQLDelete(sql = "UPDATE almacen SET estadoAlmacen = 0 WHERE idAlmacen  = ?")
@Where(clause = "estadoAlmacen = 1")
public class Almacen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlmacen;
    private String descripcionAlmacen;
    private Integer estadoAlmacen = 1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSucursal")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Sucursal idSucursal;

    public Integer getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(Integer idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public String getDescripcionAlmacen() {
        return descripcionAlmacen;
    }

    public void setDescripcionAlmacen(String descripcionAlmacen) {
        this.descripcionAlmacen = descripcionAlmacen;
    }

    public Integer getEstadoAlmacen() {
        return estadoAlmacen;
    }

    public void setEstadoAlmacen(Integer estadoAlmacen) {
        this.estadoAlmacen = estadoAlmacen;
    }

    public Sucursal getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursal idSucursal) {
        this.idSucursal = idSucursal;
    }

    @Override
    public String toString() {
        return "Almacen [idAlmacen=" + idAlmacen + ", descripcionAlmacen=" + descripcionAlmacen + ", estadoAlmacen="
                + estadoAlmacen + ", idSucursal=" + idSucursal + "]";
    }

}
