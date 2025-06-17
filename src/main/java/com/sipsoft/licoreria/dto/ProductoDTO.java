package com.sipsoft.licoreria.dto;

public class ProductoDTO {
    private Integer idProducto;
    private String codBarras;
    private String descripcionProducto;
    private Integer stockMinimo;
    private String imagenProducto;
    private Float precioVentaProducto;
    private Float gananciaPorcentaje;
    private Integer estadoProducto = 1;
    private Integer idEmpresa;
    private Integer idCategoria;
    private Integer idUnidadMedida;

    public Integer getIdProducto() { return idProducto; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }
    public String getCodBarras() { return codBarras; }
    public void setCodBarras(String codBarras) { this.codBarras = codBarras; }
    public String getDescripcionProducto() { return descripcionProducto; }
    public void setDescripcionProducto(String descripcionProducto) { this.descripcionProducto = descripcionProducto; }
    public Integer getStockMinimo() { return stockMinimo; }
    public void setStockMinimo(Integer stockMinimo) { this.stockMinimo = stockMinimo; }
    public String getImagenProducto() { return imagenProducto; }
    public void setImagenProducto(String imagenProducto) { this.imagenProducto = imagenProducto; }
    public Float getPrecioVentaProducto() { return precioVentaProducto; }
    public void setPrecioVentaProducto(Float precioVentaProducto) { this.precioVentaProducto = precioVentaProducto; }
    public Float getGananciaPorcentaje() { return gananciaPorcentaje; }
    public void setGananciaPorcentaje(Float gananciaPorcentaje) { this.gananciaPorcentaje = gananciaPorcentaje; }
    public Integer getEstadoProducto() { return estadoProducto; }
    public void setEstadoProducto(Integer estadoProducto) { this.estadoProducto = estadoProducto; }
    public Integer getIdEmpresa() { return idEmpresa; }
    public void setIdEmpresa(Integer idEmpresa) { this.idEmpresa = idEmpresa; }
    public Integer getIdCategoria() { return idCategoria; }
    public void setIdCategoria(Integer idCategoria) { this.idCategoria = idCategoria; }
    public Integer getIdUnidadMedida() { return idUnidadMedida; }
    public void setIdUnidadMedida(Integer idUnidadMedida) { this.idUnidadMedida = idUnidadMedida; }

    @Override
    public String toString() {
        return "ProductoDTO [idProducto=" + idProducto + ", codBarras=" + codBarras + ", descripcionProducto="
                + descripcionProducto + ", stockMinimo=" + stockMinimo + ", imagenProducto=" + imagenProducto
                + ", precioVentaProducto=" + precioVentaProducto + ", gananciaPorcentaje=" + gananciaPorcentaje
                + ", estadoProducto=" + estadoProducto + ", idEmpresa=" + idEmpresa + ", idCategoria=" + idCategoria
                + ", idUnidadMedida=" + idUnidadMedida + "]";
    }   
}
