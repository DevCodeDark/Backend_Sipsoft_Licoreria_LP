package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.TipoNotificaciones;

public interface ITipoNotificacionesService {
    List<TipoNotificaciones> bucarTodos();
    TipoNotificaciones guardar(TipoNotificaciones tipoNotificaciones);
    TipoNotificaciones modificar(TipoNotificaciones tipoNotificaciones);
    Optional<TipoNotificaciones> buscarId(Integer idTipoNotificacion);
    void eliminar(Integer idTipoNotificacion);
}
