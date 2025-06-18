package com.sipsoft.licoreria.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_notificaciones")
@SQLDelete(sql = "UPDATE tipo_notificaciones SET estadoTipoNotificacion = 0 WHERE idTipoNotificacion = ?")
@Where(clause = "estadoTipoNotificacion = 1")
public class TipoNotificaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoNotificacion;

    private String descripcionNotificacion;
    private Integer estadoTipoNotificacion = 1;

    public TipoNotificaciones() {
    }

    public TipoNotificaciones(Integer id) {
        this.idTipoNotificacion = id;
    }

    public Integer getIdTipoNotificacion() {
        return idTipoNotificacion;
    }

    public void setIdTipoNotificacion(Integer idTipoNotificacion) {
        this.idTipoNotificacion = idTipoNotificacion;
    }

    public String getDescripcionNotificacion() {
        return descripcionNotificacion;
    }    public void setDescripcionNotificacion(String descripcionNotificacion) {
        this.descripcionNotificacion = descripcionNotificacion;
    }

    public Integer getEstadoTipoNotificacion() {
        return estadoTipoNotificacion;
    }

    public void setEstadoTipoNotificacion(Integer estadoTipoNotificacion) {
        this.estadoTipoNotificacion = estadoTipoNotificacion;
    }

    @Override
    public String toString() {
        return "TipoNotificaciones [idTipoNotificacion=" + idTipoNotificacion + ", descripcionNotificacion="
                + descripcionNotificacion + ", estadoTipoNotificacion=" + estadoTipoNotificacion + "]";
    }
}
