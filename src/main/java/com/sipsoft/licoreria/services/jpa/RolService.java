package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.Rol;
import com.sipsoft.licoreria.repository.RolRepository;
import com.sipsoft.licoreria.services.IRolService;

@Service
public class RolService implements IRolService {
    @Autowired
    private RolRepository repoRol;
    
    public List<Rol> bucarTodos() {
        return repoRol.findAll();
    }
    
    public Rol guardar(Rol rol) {
        return repoRol.save(rol);
    }
    
    public Rol modificar(Rol rol) {
        return repoRol.save(rol);
    }
    
    public Optional<Rol> buscarId(Integer idRol) {
        return repoRol.findById(idRol);
    }
    
    public void eliminar(Integer idRol) {
        repoRol.deleteById(idRol);
    }
}