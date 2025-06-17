package com.sipsoft.licoreria.dto;

public class CategoriaDTO {
    private Integer idCategoria;
    private String nombreCategoria;
    private Integer estadoCategoria = 1;
    private Integer idEmpresa;

    public Integer getIdCategoria() {
        return idCategoria;
    }
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
    public String getNombreCategoria() {
        return nombreCategoria;
    }
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    public Integer getEstadoCategoria() {
        return estadoCategoria;
    }
    public void setEstadoCategoria(Integer estadoCategoria) {
        this.estadoCategoria = estadoCategoria;
    }
    public Integer getIdEmpresa() {
        return idEmpresa;
    }
    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    @Override
    public String toString() {
        return "CategoriaDTO [idCategoria=" + idCategoria + ", nombreCategoria=" + nombreCategoria
                + ", estadoCategoria=" + estadoCategoria + ", idEmpresa=" + idEmpresa + "]";
    }
}
