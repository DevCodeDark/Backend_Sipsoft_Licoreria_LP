package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.MovimientosStock;

public interface IMovimientosStockService {
    List<MovimientosStock> bucarTodos();
    MovimientosStock guardar(MovimientosStock movimientosStock);
    MovimientosStock modificar(MovimientosStock movimientosStock);
    Optional<MovimientosStock> buscarId(Integer idMovimientoStock);
    void eliminar(Integer idMovimientoStock);
}
