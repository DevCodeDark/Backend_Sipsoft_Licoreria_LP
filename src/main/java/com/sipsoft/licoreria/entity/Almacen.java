package com.sipsoft.licoreria.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    private Integer estadoAlmacen = 1;    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSucursal")
    @JsonIgnore
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
    }    // Método para obtener solo el ID de la sucursal sin cargar la entidad completa
    @JsonProperty("idSucursal")
    public Integer getIdSucursalValue() {
        return this.idSucursal != null ? this.idSucursal.getIdSucursal() : null;
    }

    @Override
    public String toString() {
        return "Almacen [idAlmacen=" + idAlmacen + ", descripcionAlmacen=" + descripcionAlmacen + ", estadoAlmacen="
                + estadoAlmacen + ", idSucursal=" + idSucursal + "]";
    }

}
