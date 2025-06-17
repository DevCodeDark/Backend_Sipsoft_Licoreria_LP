package com.sipsoft.licoreria.dto;

import java.time.LocalDateTime;

public class TrasladoDTO {
    private Integer idTraslado;
    private LocalDateTime fechaTraslado;
    private Integer estadoTraslado;
    private Integer idAlmacenOrigen;
    private Integer idAlmacenDestino;

    // Getters y Setters
    public Integer getIdTraslado() { return idTraslado; }
    public void setIdTraslado(Integer idTraslado) { this.idTraslado = idTraslado; }
    public LocalDateTime getFechaTraslado() { return fechaTraslado; }
    public void setFechaTraslado(LocalDateTime fechaTraslado) { this.fechaTraslado = fechaTraslado; }
    public Integer getEstadoTraslado() { return estadoTraslado; }
    public void setEstadoTraslado(Integer estadoTraslado) { this.estadoTraslado = estadoTraslado; }
    public Integer getIdAlmacenOrigen() { return idAlmacenOrigen; }
    public void setIdAlmacenOrigen(Integer idAlmacenOrigen) { this.idAlmacenOrigen = idAlmacenOrigen; }
    public Integer getIdAlmacenDestino() { return idAlmacenDestino; }
    public void setIdAlmacenDestino(Integer idAlmacenDestino) { this.idAlmacenDestino = idAlmacenDestino; }
}