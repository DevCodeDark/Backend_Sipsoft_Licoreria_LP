package com.sipsoft.licoreria.entity;

import java.time.LocalDateTime;
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
@Table(name = "devolucion_compra")
// --- CORRECCIÓN AQUÍ --- Corregido 'estadoDevolucion' a 'estadoDevolucionCompra'
@SQLDelete(sql = "UPDATE devolucion_compra SET estadoDevolucionCompra = 0 WHERE idDevolucionCompra = ?")
@Where(clause = "estadoDevolucionCompra = 1")
public class DevolucionCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDevolucionCompra;
    private LocalDateTime fechaDevolucionCompra;
    private String motivoDevolucionCompra;
    private String imagenDevolucion;
    private Integer estadoDevolucionCompra = 1;
    private Integer idDetalleCompra;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDetalleCompra", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private DetalleCompra detalleCompra;
    
    // --- Constructores, Getters y Setters ---
    public DevolucionCompra() {
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

    public Integer getEstadoDevolucionCompra() {
        return estadoDevolucionCompra;
    }

    public void setEstadoDevolucionCompra(Integer estadoDevolucionCompra) {
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
}