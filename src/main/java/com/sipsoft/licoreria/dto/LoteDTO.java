package com.sipsoft.licoreria.dto;

import java.time.LocalDate;

public class LoteDTO {
    private Integer idLote;
    private String codLote;
    private LocalDate fechaEntradaLote;
    private LocalDate fechaVencimientoLote;
    private Integer stockInicial;
    private Integer stockActual;
    private Integer flagLote;
    private Integer estadoLote = 1;
    private Integer idProducto;
    private Integer idAlmacen;

    public Integer getIdLote() { return idLote; }
    public void setIdLote(Integer idLote) { this.idLote = idLote; }
    public String getCodLote() { return codLote; }
    public void setCodLote(String codLote) { this.codLote = codLote; }
    public LocalDate getFechaEntradaLote() { return fechaEntradaLote; }
    public void setFechaEntradaLote(LocalDate fechaEntradaLote) { this.fechaEntradaLote = fechaEntradaLote; }
    public LocalDate getFechaVencimientoLote() { return fechaVencimientoLote; }
    public void setFechaVencimientoLote(LocalDate fechaVencimientoLote) { this.fechaVencimientoLote = fechaVencimientoLote; }
    public Integer getStockInicial() { return stockInicial; }
    public void setStockInicial(Integer stockInicial) { this.stockInicial = stockInicial; }
    public Integer getStockActual() { return stockActual; }
    public void setStockActual(Integer stockActual) { this.stockActual = stockActual; }
    public Integer getFlagLote() { return flagLote; }
    public void setFlagLote(Integer flagLote) { this.flagLote = flagLote; }
    public Integer getEstadoLote() { return estadoLote; }
    public void setEstadoLote(Integer estadoLote) { this.estadoLote = estadoLote; }
    public Integer getIdProducto() { return idProducto; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }
    public Integer getIdAlmacen() { return idAlmacen; }
    public void setIdAlmacen(Integer idAlmacen) { this.idAlmacen = idAlmacen; }
    @Override
    public String toString() {
        return "LoteDTO [idLote=" + idLote + ", codLote=" + codLote + ", fechaEntradaLote=" + fechaEntradaLote
                + ", fechaVencimientoLote=" + fechaVencimientoLote + ", stockInicial=" + stockInicial + ", stockActual="
                + stockActual + ", flagLote=" + flagLote + ", estadoLote=" + estadoLote + ", idProducto=" + idProducto
                + ", idAlmacen=" + idAlmacen + "]";
    }
}
