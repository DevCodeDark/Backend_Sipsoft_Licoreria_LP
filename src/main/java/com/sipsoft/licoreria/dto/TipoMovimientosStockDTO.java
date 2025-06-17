package com.sipsoft.licoreria.dto;

public class TipoMovimientosStockDTO {
    private Integer idTipoMovimiento;
    private Integer idEmpresa;
    private String descripcionMovimiento;
    
    public Integer getIdTipoMovimiento() {
        return idTipoMovimiento;
    }
    public void setIdTipoMovimiento(Integer idTipoMovimiento) {
        this.idTipoMovimiento = idTipoMovimiento;
    }
    public Integer getIdEmpresa() {
        return idEmpresa;
    }
    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    public String getDescripcionMovimiento() {
        return descripcionMovimiento;
    }
    public void setDescripcionMovimiento(String descripcionMovimiento) {
        this.descripcionMovimiento = descripcionMovimiento;
    }
    @Override
    public String toString() {
        return "TipoMovimientosStockDTO [idTipoMovimiento=" + idTipoMovimiento + ", idEmpresa=" + idEmpresa
                + ", descripcionMovimiento=" + descripcionMovimiento + "]";
    }
}
