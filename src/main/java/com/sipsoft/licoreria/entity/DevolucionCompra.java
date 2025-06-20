package com.sipsoft.licoreria.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "devolucion_compra")
@SQLDelete(sql = "UPDATE devolucion_compra SET estadoDevolucionCompra = 'RECHAZADO' WHERE idDevolucionCompra = ?")
@SQLRestriction("estadoDevolucionCompra != 'RECHAZADO'")
public class DevolucionCompra implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDevolucionCompra")
    private Integer idDevolucionCompra;

    @Column(name = "fechaDevolucionCompra")
    private LocalDateTime fechaDevolucionCompra;

    @Column(name = "motivoDevolucionCompra")
    private String motivoDevolucionCompra;

    @Column(name = "imagenDevolucion")
    private String imagenDevolucion;

    @Column(name = "estadoDevolucionCompra")
    private String estadoDevolucionCompra;

    @Column(name = "idDetalleCompra")
    private Integer idDetalleCompra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDetalleCompra", referencedColumnName = "idDetalleCompra", insertable = false, updatable = false)
    @JsonIgnore
    private transient DetalleCompra detalleCompra;

    public DevolucionCompra() {
        // Constructor vacío requerido por JPA
    }

    public DevolucionCompra(Integer idDevolucionCompra) {
        this.idDevolucionCompra = idDevolucionCompra;
    }

    public Integer getIdDevolucionCompra() {
        return idDevolucionCompra;
    }

    public void setIdDevolucionCompra(Integer idDevolucionCompra) {
        this.idDevolucionCompra = idDevolucionCompra;
    }

    public LocalDateTime getFechaDevolucionCompra() {
        return fechaDevolucionCompra;
    }

    public void setFechaDevolucionCompra(LocalDateTime fechaDevolucionCompra) {
        this.fechaDevolucionCompra = fechaDevolucionCompra;
    }

    public String getMotivoDevolucionCompra() {
        return motivoDevolucionCompra;
    }

    public void setMotivoDevolucionCompra(String motivoDevolucionCompra) {
        this.motivoDevolucionCompra = motivoDevolucionCompra;
    }

    public String getImagenDevolucion() {
        return imagenDevolucion;
    }

    public void setImagenDevolucion(String imagenDevolucion) {
        this.imagenDevolucion = imagenDevolucion;
    }

    public String getEstadoDevolucionCompra() {
        return estadoDevolucionCompra;
    }

    public void setEstadoDevolucionCompra(String estadoDevolucionCompra) {
        this.estadoDevolucionCompra = estadoDevolucionCompra;
    }

    public Integer getIdDetalleCompra() {
        return idDetalleCompra;
    }

    public void setIdDetalleCompra(Integer idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }

    public DetalleCompra getDetalleCompra() {
        return detalleCompra;
    }

    public void setDetalleCompra(DetalleCompra detalleCompra) {
        this.detalleCompra = detalleCompra;
    }

    @Override
    public String toString() {
        return "DevolucionCompra [idDevolucionCompra=" + idDevolucionCompra + ", fechaDevolucionCompra="
                + fechaDevolucionCompra + ", motivoDevolucionCompra=" + motivoDevolucionCompra + ", imagenDevolucion="
                + imagenDevolucion + ", estadoDevolucionCompra=" + estadoDevolucionCompra + ", idDetalleCompra="
                + idDetalleCompra + "]";
    }

}