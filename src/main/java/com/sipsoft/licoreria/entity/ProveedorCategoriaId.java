package com.sipsoft.licoreria.entity;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProveedorCategoriaId implements Serializable {

    private Integer idProveedor;
    private Integer idCategoria;

    // Se requiere un constructor vacío
    public ProveedorCategoriaId() {
    }

    public ProveedorCategoriaId(Integer idProveedor, Integer idCategoria) {
        this.idProveedor = idProveedor;
        this.idCategoria = idCategoria;
    }

    // Getters, Setters, equals y hashCode son necesarios para las llaves compuestas
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProveedorCategoriaId that = (ProveedorCategoriaId) o;
        return Objects.equals(idProveedor, that.idProveedor) &&
               Objects.equals(idCategoria, that.idCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProveedor, idCategoria);
    }
}