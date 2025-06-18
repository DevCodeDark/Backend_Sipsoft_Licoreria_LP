package com.sipsoft.licoreria.dto;

public class SucursalDTO {
    private Integer idSucursal;
    private String ubicacionSucursal;
    private Integer estadoSucursal;
    private Integer idEmpresa;    public Integer getIdSucursal() {
        return idSucursal;
    }
    
    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }
    
    public String getUbicacionSucursal() {
        return ubicacionSucursal;
    }
    
    public void setUbicacionSucursal(String ubicacionSucursal) {
        this.ubicacionSucursal = ubicacionSucursal;
    }
    
    public Integer getEstadoSucursal() {
        return estadoSucursal;
    }
    
    public void setEstadoSucursal(Integer estadoSucursal) {
        this.estadoSucursal = estadoSucursal;
    }
    
    public Integer getIdEmpresa() {
        return idEmpresa;
    }
    
    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    
    @Override
    public String toString() {
        return "SucursalDTO [idSucursal=" + idSucursal + ", ubicacionSucursal=" + ubicacionSucursal + 
               ", estadoSucursal=" + estadoSucursal + ", idEmpresa=" + idEmpresa + "]";
    }
    
    
}
