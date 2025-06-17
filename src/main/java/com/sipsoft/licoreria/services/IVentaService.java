package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.Venta;

public interface IVentaService {
    List<Venta> bucarTodos();
    Venta guardar(Venta venta);
    Venta modificar(Venta venta);
    Optional<Venta> buscarId(Integer idVenta);
    void eliminar(Integer idVenta);
}
