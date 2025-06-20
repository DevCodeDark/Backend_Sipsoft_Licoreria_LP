package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;
import com.sipsoft.licoreria.entity.Caja;

public interface ICajaService {
    // Métodos existentes
    List<Caja> bucarTodos();
    Caja guardar(Caja caja);
    Caja modificar(Caja caja);
    Optional<Caja> buscarId(Integer idCaja);
    void eliminar(Integer idCaja);
    
    // Nuevos métodos para filtrar por estado
    List<Caja> buscarPorEstado(Integer estadoCaja);
    List<Caja> buscarCajasActivas();
    List<Caja> buscarCajasInactivas();
    List<Caja> buscarPorSucursalYEstado(Integer idSucursal, Integer estadoCaja);
}