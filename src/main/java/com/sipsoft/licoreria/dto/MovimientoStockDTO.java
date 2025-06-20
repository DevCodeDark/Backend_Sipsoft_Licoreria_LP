package com.sipsoft.licoreria.dto;

import java.time.LocalDateTime;

public class MovimientoStockDTO {
    private Integer idMovimientoStock;
    private Integer cantidadMovimientoStock;
    private LocalDateTime fechaMovimientoStock;
    private Integer idLote;
    private Integer idTipoMovimiento;

    public Integer getIdMovimientoStock() {
        return idMovimientoStock;
    }
    public void setIdMovimientoStock(Integer idMovimientoStock) {
        this.idMovimientoStock = idMovimientoStock;
    }
    public Integer getCantidadMovimientoStock() {
        return cantidadMovimientoStock;
    }
    public void setCantidadMovimientoStock(Integer cantidadMovimientoStock) {
        this.cantidadMovimientoStock = cantidadMovimientoStock;
    }
    public LocalDateTime getFechaMovimientoStock() {
        return fechaMovimientoStock;
    }
    public void setFechaMovimientoStock(LocalDateTime fechaMovimientoStock) {
        this.fechaMovimientoStock = fechaMovimientoStock;
    }
    public Integer getIdLote() {
        return idLote;
    }
    public void setIdLote(Integer idLote) {
        this.idLote = idLote;
    }
    public Integer getIdTipoMovimiento() {
        return idTipoMovimiento;
    }
    public void setIdTipoMovimiento(Integer idTipoMovimiento) {
        this.idTipoMovimiento = idTipoMovimiento;
    }
    @Override
    public String toString() {
        return "MovimientoStockDTO [idMovimientoStock=" + idMovimientoStock + ", cantidadMovimientoStock="
                + cantidadMovimientoStock + ", fechaMovimientoStock=" + fechaMovimientoStock + ", idLote=" + idLote
                + ", idTipoMovimiento=" + idTipoMovimiento + "]";
    }

    
    

}
