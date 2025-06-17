package com.sipsoft.licoreria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_notificaciones")
public class TipoNotificaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoNotificacion;

    private String descripcionNotificacion;

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
    }

    public void setDescripcionNotificacion(String descripcionNotificacion) {
        this.descripcionNotificacion = descripcionNotificacion;
    }

    @Override
    public String toString() {
        return "TipoNotificaciones [idTipoNotificacion=" + idTipoNotificacion + ", descripcionNotificacion="
                + descripcionNotificacion + "]";
    }
}
