package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;
import com.sipsoft.licoreria.entity.DetalleVenta;

public interface IDetalleVentaService {
    List<DetalleVenta> bucarTodos();
    DetalleVenta guardar(DetalleVenta detalleVenta);
    DetalleVenta modificar(DetalleVenta detalleVenta);
    Optional<DetalleVenta> buscarId(Integer idDetalleVenta);
    void eliminar(Integer idDetalleVenta);
}