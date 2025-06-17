package com.sipsoft.licoreria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedor_categoria")
public class ProveedorCategoria {

    @EmbeddedId
    private ProveedorCategoriaId id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idProveedor")
    @JoinColumn(name = "idProveedor")
    private Proveedor proveedor;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idCategoria")
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    // Getters y Setters
    public ProveedorCategoriaId getId() {
        return id;
    }

    public void setId(ProveedorCategoriaId id) {
        this.id = id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}