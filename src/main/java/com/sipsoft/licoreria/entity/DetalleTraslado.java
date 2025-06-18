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
@Table(name = "detalle_traslado")
public class DetalleTraslado {    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleTraslado;
    private Integer cantidadTraslado;
    private Integer estadoDetalleTraslado = 1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTraslado")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Traslado idTraslado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLote")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Lote idLote;

    public Integer getIdDetalleTraslado() {
        return idDetalleTraslado;
    }    public void setIdDetalleTraslado(Integer idDetalleTraslado) {
        this.idDetalleTraslado = idDetalleTraslado;
    }
    
    public Integer getCantidadTraslado() {
        return cantidadTraslado;
    }

    public void setCantidadTraslado(Integer cantidadTraslado) {
        this.cantidadTraslado = cantidadTraslado;
    }

    public Integer getEstadoDetalleTraslado() {
        return estadoDetalleTraslado;
    }

    public void setEstadoDetalleTraslado(Integer estadoDetalleTraslado) {
        this.estadoDetalleTraslado = estadoDetalleTraslado;
    }

    public Traslado getIdTraslado() {
        return idTraslado;
    }

    public void setIdTraslado(Traslado idTraslado) {
        this.idTraslado = idTraslado;
    }

    public Lote getIdLote() {
        return idLote;
    }    public void setIdLote(Lote idLote) {
        this.idLote = idLote;
    }
    
    @Override
    public String toString() {
        return "DetalleTraslado [idDetalleTraslado=" + idDetalleTraslado + ", cantidadTraslado=" + cantidadTraslado
                + ", estadoDetalleTraslado=" + estadoDetalleTraslado + ", idTraslado=" + idTraslado + ", idLote=" + idLote + "]";
    }

    
   
}
