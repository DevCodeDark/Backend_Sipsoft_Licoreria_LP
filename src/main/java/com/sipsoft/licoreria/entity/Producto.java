package com.sipsoft.licoreria.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
@SQLDelete(sql = "UPDATE producto SET estadoProducto = 0 WHERE idProducto = ?")
@Where(clause = "estadoProducto = 1")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;
    private String codBarras;
    private String descripcionProducto;
    private Integer idEmpresa;
    private Integer idCategoria;
    private Integer idUnidadMedida;
    private Integer stockMinimo;
    private String imagenProducto;
    private Float precioVentaProducto;
    private Float gananciaPorcentaje;
    private Integer estadoProducto = 1;    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpresa", insertable = false, updatable = false)
    @JsonIgnore
    private Empresa empresa;    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCategoria", insertable = false, updatable = false)
    @JsonIgnore
    private Categoria categoria;    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUnidadMedida", insertable = false, updatable = false)
    @JsonIgnore
    private UnidadMedida unidadMedida;

    public Producto() {
    }
    
    public Producto(Integer id){
        this.idProducto = id;
    } 

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(Integer idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public Integer getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(Integer stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public Float getPrecioVentaProducto() {
        return precioVentaProducto;
    }

    public void setPrecioVentaProducto(Float precioVentaProducto) {
        this.precioVentaProducto = precioVentaProducto;
    }

    public Float getGananciaPorcentaje() {
        return gananciaPorcentaje;
    }

    public void setGananciaPorcentaje(Float gananciaPorcentaje) {
        this.gananciaPorcentaje = gananciaPorcentaje;
    }

    public Integer getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(Integer estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }    @Override
    public String toString() {
        return "Producto [idProducto=" + idProducto + ", codBarras=" + codBarras + ", descripcionProducto="
                + descripcionProducto + ", idEmpresa=" + idEmpresa + ", idCategoria=" + idCategoria
                + ", idUnidadMedida=" + idUnidadMedida + ", stockMinimo=" + stockMinimo + ", imagenProducto=" + imagenProducto
                + ", precioVentaProducto=" + precioVentaProducto + ", gananciaPorcentaje=" + gananciaPorcentaje
                + ", estadoProducto=" + estadoProducto + "]";
    }
}
