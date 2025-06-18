package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.TipoRol;

public interface ITipoRolService {
    
    List<TipoRol> buscarTodos();
    
    List<TipoRol> buscarActivos();
    
    Optional<TipoRol> buscarPorId(Integer id);
    
    Optional<TipoRol> buscarPorIdActivo(Integer id);
    
    TipoRol guardar(TipoRol tipoRol);
    
    TipoRol actualizar(TipoRol tipoRol);
    
    void eliminar(Integer id);
    
    void eliminarLogico(Integer id);
    
    Optional<TipoRol> buscarPorNombre(String tipoRol);
    
    List<TipoRol> buscarPorNombreContiene(String tipoRol);
    
    boolean existePorNombre(String tipoRol);
}
