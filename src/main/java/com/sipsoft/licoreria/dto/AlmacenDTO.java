package com.sipsoft.licoreria.dto;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "almacen")
@SQLDelete(sql = "UPDATE almacen SET estadoAlmacen = 0 WHERE idAlmacen = ?")
@Where(clause = "estadoAlmacen = 1")
public class AlmacenDTO {
     @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)private Integer idAlmacen;
    private String descripcionAlmacen;
    private Integer estadoAlmacen = 1;
    private Integer idSucursal;
    
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
    public Integer getIdSucursal() {
        return idSucursal;
    }
    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    @Override
    public String toString() {
        return "AlmacenDTO [idAlmacen=" + idAlmacen + ", descripcionAlmacen=" + descripcionAlmacen + ", estadoAlmacen="
                + estadoAlmacen + ", idSucursal=" + idSucursal + "]";
    }

}
