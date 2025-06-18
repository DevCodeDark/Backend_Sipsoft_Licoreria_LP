package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.SegmentoModulo;

public interface ISegmentoModuloService {
    
    List<SegmentoModulo> buscarTodos();
    
    List<SegmentoModulo> buscarActivos();
    
    Optional<SegmentoModulo> buscarPorId(Integer id);
    
    Optional<SegmentoModulo> buscarPorIdActivo(Integer id);
    
    SegmentoModulo guardar(SegmentoModulo segmentoModulo);
    
    SegmentoModulo actualizar(SegmentoModulo segmentoModulo);
    
    void eliminar(Integer id);
    
    void eliminarLogico(Integer id);
    
    Optional<SegmentoModulo> buscarPorDescripcion(String descripcion);
    
    List<SegmentoModulo> buscarPorDescripcionContiene(String descripcion);
    
    boolean existePorDescripcion(String descripcion);
    
    List<SegmentoModulo> buscarActivosConModulos();
    
    Optional<SegmentoModulo> buscarPorIdActivoConModulos(Integer id);
}
