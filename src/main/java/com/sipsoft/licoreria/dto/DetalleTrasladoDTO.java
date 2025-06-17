package com.sipsoft.licoreria.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "detalle_traslado")
public class DetalleTrasladoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleTraslado;
    private Integer cantidadTraslado;
    private Integer idTraslado;
    private Integer idLote;

    public Integer getIdDetalleTraslado() {
        return idDetalleTraslado;
    }
    public void setIdDetalleTraslado(Integer idDetalleTraslado) {
        this.idDetalleTraslado = idDetalleTraslado;
    }
    public Integer getCantidadTraslado() {
        return cantidadTraslado;
    }
    public void setCantidadTraslado(Integer cantidadTraslado) {
        this.cantidadTraslado = cantidadTraslado;
    }
    public Integer getIdTraslado() {
        return idTraslado;
    }
    public void setIdTraslado(Integer idTraslado) {
        this.idTraslado = idTraslado;
    }
    public Integer getIdLote() {
        return idLote;
    }
    public void setIdLote(Integer idLote) {
        this.idLote = idLote;
    }
    @Override
    public String toString() {
        return "DetalleTrasladoDTO [idDetalleTraslado=" + idDetalleTraslado + ", cantidadTraslado=" + cantidadTraslado
                + ", idTraslado=" + idTraslado + ", idLote=" + idLote + "]";
    }

        

}
