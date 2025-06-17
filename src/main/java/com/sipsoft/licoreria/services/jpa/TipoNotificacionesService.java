package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.TipoNotificaciones;
import com.sipsoft.licoreria.repository.TipoNotificacionesRepository;
import com.sipsoft.licoreria.services.ITipoNotificacionesService;

@Service
public class TipoNotificacionesService implements ITipoNotificacionesService {
    @Autowired
    private TipoNotificacionesRepository repoTipoNotificaciones;
    
    public List<TipoNotificaciones> bucarTodos() {
        return repoTipoNotificaciones.findAll();
    }
    
    public TipoNotificaciones guardar(TipoNotificaciones tipoNotificaciones) {
        return repoTipoNotificaciones.save(tipoNotificaciones);
    }
    
    public TipoNotificaciones modificar(TipoNotificaciones tipoNotificaciones) {
        return repoTipoNotificaciones.save(tipoNotificaciones);
    }
    
    public Optional<TipoNotificaciones> buscarId(Integer idTipoNotificacion) {
        return repoTipoNotificaciones.findById(idTipoNotificacion);
    }
    
    public void eliminar(Integer idTipoNotificacion) {
        repoTipoNotificaciones.deleteById(idTipoNotificacion);
    }
}
