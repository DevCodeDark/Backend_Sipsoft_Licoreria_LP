package com.sipsoft.licoreria.dto;

public class ProveedorCategoriaDTO {
    private Integer idProveedorCategoria;
    private Integer idProveedor;
    private Integer idCategoria;

    // Getters y Setters
    public Integer getIdProveedorCategoria() {
        return idProveedorCategoria;
    }

    public void setIdProveedorCategoria(Integer idProveedorCategoria) {
        this.idProveedorCategoria = idProveedorCategoria;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public String toString() {
        return "ProveedorCategoriaDTO [idProveedorCategoria=" + idProveedorCategoria + ", idProveedor=" + idProveedor 
                + ", idCategoria=" + idCategoria + "]";
    }
}