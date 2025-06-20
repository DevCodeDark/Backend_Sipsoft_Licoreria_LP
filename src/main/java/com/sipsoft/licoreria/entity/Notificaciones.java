package com.sipsoft.licoreria.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "notificaciones")
@SQLDelete(sql = "UPDATE notificaciones SET estadoNotificacion = 0 WHERE idNotificacion = ?")
@SQLRestriction("estadoNotificacion = 1")
public class Notificaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNotificacion;
    private LocalDateTime fechaNotificacion;
    private String mensaje;
    private Integer estadoNotificacion = 1;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProducto")
    @JsonIgnore
    private Producto idProducto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idContratoProveedor")
    @JsonIgnore
    private ContratoProveedor idContratoProveedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoNotificacion")
    @JsonIgnore
    private TipoNotificaciones idTipoNotificacion;

    public Notificaciones() {
        // Constructor vacío requerido por JPA
    }

    public Integer getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Integer idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public LocalDateTime getFechaNotificacion() {
        return fechaNotificacion;
    }

    public void setFechaNotificacion(LocalDateTime fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getEstadoNotificacion() {
        return estadoNotificacion;
    }

    public void setEstadoNotificacion(Integer estadoNotificacion) {
        this.estadoNotificacion = estadoNotificacion;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public ContratoProveedor getIdContratoProveedor() {
        return idContratoProveedor;
    }

    public void setIdContratoProveedor(ContratoProveedor idContratoProveedor) {
        this.idContratoProveedor = idContratoProveedor;
    }

    public TipoNotificaciones getIdTipoNotificacion() {
        return idTipoNotificacion;
    }

    public void setIdTipoNotificacion(TipoNotificaciones idTipoNotificacion) {
        this.idTipoNotificacion = idTipoNotificacion;
    }

    // Métodos helper para obtener IDs de las relaciones
    public Integer getProductoId() {
        return idProducto != null ? idProducto.getIdProducto() : null;
    }

    public Integer getContratoProveedorId() {
        return idContratoProveedor != null ? idContratoProveedor.getIdContratoProveedor() : null;
    }

    public Integer getTipoNotificacionId() {
        return idTipoNotificacion != null ? idTipoNotificacion.getIdTipoNotificacion() : null;
    }

    @Override
    public String toString() {
        return "Notificaciones [idNotificacion=" + idNotificacion + ", fechaNotificacion=" + fechaNotificacion
                + ", mensaje=" + mensaje + ", estadoNotificacion=" + estadoNotificacion + ", idProducto=" + idProducto
                + ", idContratoProveedor=" + idContratoProveedor + ", idTipoNotificacion=" + idTipoNotificacion + "]";
    }

}
