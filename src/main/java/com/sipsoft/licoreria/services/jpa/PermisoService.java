package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.Permiso;
import com.sipsoft.licoreria.repository.PermisoRepository;
import com.sipsoft.licoreria.services.IPermisoService;

@Service
public class PermisoService implements IPermisoService {
    @Autowired
    private PermisoRepository repoPermiso;
    
    public List<Permiso> bucarTodos() {
        return repoPermiso.findAll();
    }
    
    public Permiso guardar(Permiso permiso) {
        return repoPermiso.save(permiso);
    }
    
    public Permiso modificar(Permiso permiso) {
        return repoPermiso.save(permiso);
    }
    
    public Optional<Permiso> buscarId(Integer idPermiso) {
        return repoPermiso.findById(idPermiso);
    }
    
    public void eliminar(Integer idPermiso) {
        repoPermiso.deleteById(idPermiso);
    }
}