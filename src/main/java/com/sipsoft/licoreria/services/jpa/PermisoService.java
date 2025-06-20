package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.Modulo;
import com.sipsoft.licoreria.entity.Permiso;
import com.sipsoft.licoreria.repository.ModuloRepository;
import com.sipsoft.licoreria.repository.PermisoRepository;
import com.sipsoft.licoreria.services.IPermisoService;

@Service
public class PermisoService implements IPermisoService {
    @Autowired
    private PermisoRepository repoPermiso;

    @Autowired
    private ModuloRepository repoModulo;
    
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


    @Override
    public List<Permiso> buscarPorRol(Integer idRol) {
        return repoPermiso.findByIdRol(idRol);
    }    

    @Override
    public List<Permiso> buscarPorRolActivos(Integer idRol) {
        return repoPermiso.findByRolIdRolAndEstadoPermiso(idRol, 1);
    } 

    @Override
public void actualizarPermisos(Integer idRol, List<Integer> modulosSeleccionados) {
    List<Permiso> permisos = repoPermiso.findByIdRol(idRol);

    // Desactiva todos los permisos existentes
    for (Permiso p : permisos) {
        p.setEstadoPermiso(0);
    }

    // Activa los seleccionados y crea si no existen
    if (modulosSeleccionados != null) {
        for (Integer idModulo : modulosSeleccionados) {
            boolean existe = false;
            for (Permiso p : permisos) {
                if (p.getModulo().getIdModulo().equals(idModulo)) {
                    p.setEstadoPermiso(1);
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                Permiso nuevo = new Permiso();
                nuevo.setIdRol(idRol);
                // Debes obtener el objeto Modulo por idModulo
                Modulo modulo = repoModulo.findById(idModulo).orElse(null);
                if (modulo != null) {
                    nuevo.setModulo(modulo);
                    nuevo.setEstadoPermiso(1);
                    repoPermiso.save(nuevo);
                }
            }
        }
    }
    repoPermiso.saveAll(permisos);
}

@Override
    public Optional<Permiso> buscarPorRolYModulo(Integer idRol, Integer idModulo) {
        return repoPermiso.findByIdRolAndIdModulo(idRol, idModulo);
    }
}