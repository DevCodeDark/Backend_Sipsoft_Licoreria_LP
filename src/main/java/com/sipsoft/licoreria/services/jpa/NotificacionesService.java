package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.Notificaciones;
import com.sipsoft.licoreria.repository.NotificacionesRepository;
import com.sipsoft.licoreria.services.INotificacionesService;

@Service
public class NotificacionesService implements INotificacionesService {
    @Autowired
    private NotificacionesRepository repoNotificaciones;
    
    public List<Notificaciones> bucarTodos() {
        return repoNotificaciones.findAll();
    }
    
    public Notificaciones guardar(Notificaciones notificaciones) {
        return repoNotificaciones.save(notificaciones);
    }
    
    public Notificaciones modificar(Notificaciones notificaciones) {
        return repoNotificaciones.save(notificaciones);
    }
    
    public Optional<Notificaciones> buscarId(Integer idNotificacion) {
        return repoNotificaciones.findById(idNotificacion);
    }
    
    public void eliminar(Integer idNotificacion) {
        repoNotificaciones.deleteById(idNotificacion);
    }
}
