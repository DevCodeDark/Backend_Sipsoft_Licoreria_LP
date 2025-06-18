package com.sipsoft.licoreria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_devolucion_proveedores")
@SQLDelete(sql = "UPDATE detalle_devolucion_proveedores SET estadoDetalleDevolucionProveedor = 0 WHERE idDetalleDevolucion = ?")
@Where(clause = "estadoDetalleDevolucionProveedor = 1")
public class DetalleDevolucionProveedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleDevolucion;
    private Integer cantidadDevolucion;
    private Integer estadoDetalleDevolucionProveedor = 1;
    private Integer idDevolucionCompra;
    private Integer idProducto;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDevolucionCompra", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private DevolucionCompra devolucionCompra;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProducto", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Producto producto;

    // --- Constructores, Getters y Setters ---
    public DetalleDevolucionProveedores() {
    }

    public Integer getIdDetalleDevolucion() {
        return idDetalleDevolucion;
    }

    public void setIdDetalleDevolucion(Integer idDetalleDevolucion) {
        this.idDetalleDevolucion = idDetalleDevolucion;
    }

    public Integer getCantidadDevolucion() {
        return cantidadDevolucion;
    }

    public void setCantidadDevolucion(Integer cantidadDevolucion) {
        this.cantidadDevolucion = cantidadDevolucion;
    }    public Integer getEstadoDetalleDevolucionProveedor() {
        return estadoDetalleDevolucionProveedor;
    }

    public void setEstadoDetalleDevolucionProveedor(Integer estadoDetalleDevolucionProveedor) {
        this.estadoDetalleDevolucionProveedor = estadoDetalleDevolucionProveedor;
    }

    public Integer getIdDevolucionCompra() {
        return idDevolucionCompra;
    }

    public void setIdDevolucionCompra(Integer idDevolucionCompra) {
        this.idDevolucionCompra = idDevolucionCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public DevolucionCompra getDevolucionCompra() {
        return devolucionCompra;
    }

    public void setDevolucionCompra(DevolucionCompra devolucionCompra) {
        this.devolucionCompra = devolucionCompra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }    @Override
    public String toString() {
        return "DetalleDevolucionProveedores [idDetalleDevolucion=" + idDetalleDevolucion + ", cantidadDevolucion="
                + cantidadDevolucion + ", estadoDetalleDevolucionProveedor=" + estadoDetalleDevolucionProveedor + ", idDevolucionCompra="
                + idDevolucionCompra + ", idProducto=" + idProducto + "]";
    }
}