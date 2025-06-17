package com.sipsoft.licoreria.entity;

import java.time.LocalDateTime;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "traslado")
@SQLDelete(sql = "UPDATE traslado SET estadoTraslado = 0 WHERE idTraslado = ?")
@Where(clause = "estadoTraslado = 1")
public class Traslado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTraslado;
    private LocalDateTime fechaTraslado;
    private Integer estadoTraslado = 1;
    private Integer idAlmacenOrigen;
    private Integer idAlmacenDestino;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAlmacenOrigen", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Almacen almacenOrigen;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAlmacenDestino", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Almacen almacenDestino;

    // --- Constructores, Getters y Setters para todos los campos ---
    public Traslado() {}

    public Integer getIdTraslado() { return idTraslado; }
    public void setIdTraslado(Integer idTraslado) { this.idTraslado = idTraslado; }
    public LocalDateTime getFechaTraslado() { return fechaTraslado; }
    public void setFechaTraslado(LocalDateTime fechaTraslado) { this.fechaTraslado = fechaTraslado; }
    public Integer getEstadoTraslado() { return estadoTraslado; }
    public void setEstadoTraslado(Integer estadoTraslado) { this.estadoTraslado = estadoTraslado; }
    public Integer getIdAlmacenOrigen() { return idAlmacenOrigen; }
    public void setIdAlmacenOrigen(Integer idAlmacenOrigen) { this.idAlmacenOrigen = idAlmacenOrigen; }
    public Integer getIdAlmacenDestino() { return idAlmacenDestino; }
    public void setIdAlmacenDestino(Integer idAlmacenDestino) { this.idAlmacenDestino = idAlmacenDestino; }
    public Almacen getAlmacenOrigen() { return almacenOrigen; }
    public void setAlmacenOrigen(Almacen almacenOrigen) { this.almacenOrigen = almacenOrigen; }
    public Almacen getAlmacenDestino() { return almacenDestino; }
    public void setAlmacenDestino(Almacen almacenDestino) { this.almacenDestino = almacenDestino; }
}