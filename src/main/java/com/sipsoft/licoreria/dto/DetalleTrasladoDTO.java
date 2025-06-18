package com.sipsoft.licoreria.dto;

public class DetalleTrasladoDTO {
    private Integer idDetalleTraslado;
    private Integer cantidadTraslado;
    private Integer estadoDetalleTraslado;
    private Integer idTraslado;
    private Integer idLote;    // Constructores
    public DetalleTrasladoDTO() {
        // Constructor vacío para serialización/deserialización
    }

    // Getters y Setters
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
    public Integer getEstadoDetalleTraslado() {
        return estadoDetalleTraslado;
    }
    public void setEstadoDetalleTraslado(Integer estadoDetalleTraslado) {
        this.estadoDetalleTraslado = estadoDetalleTraslado;
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
                + ", estadoDetalleTraslado=" + estadoDetalleTraslado + ", idTraslado=" + idTraslado + ", idLote=" + idLote + "]";
    }
}
