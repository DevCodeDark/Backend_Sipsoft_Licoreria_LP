package com.sipsoft.licoreria.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_comprobante")
@SQLDelete(sql = "UPDATE tipo_comprobante SET estadoTipoComprobante = 0 WHERE idTipoComprobante = ?")
@Where(clause = "estadoTipoComprobante = 1")
public class TipoComprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoComprobante;

    private String descripcionTipoComprobante;
    private Integer estadoTipoComprobante = 1;

    public TipoComprobante() {
    }

    public Integer getIdTipoComprobante() {
        return idTipoComprobante;
    }

    public void setIdTipoComprobante(Integer idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
    }

    public String getDescripcionTipoComprobante() {
        return descripcionTipoComprobante;
    }

    public void setDescripcionTipoComprobante(String descripcionTipoComprobante) {
        this.descripcionTipoComprobante = descripcionTipoComprobante;
    }

    public Integer getEstadoTipoComprobante() {
        return estadoTipoComprobante;
    }

    public void setEstadoTipoComprobante(Integer estadoTipoComprobante) {
        this.estadoTipoComprobante = estadoTipoComprobante;
    }
    public TipoComprobante(Integer id) {
    this.idTipoComprobante = id;
}

    @Override
    public String toString() {
        return "TipoComprobante [idTipoComprobante=" + idTipoComprobante + ", descripcionTipoComprobante="
                + descripcionTipoComprobante + ", estadoTipoComprobante=" + estadoTipoComprobante + "]";
    }
}
