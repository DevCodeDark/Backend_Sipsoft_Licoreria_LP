package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;
import com.sipsoft.licoreria.entity.DetalleCompra;

public interface IDetalleCompraService {
    List<DetalleCompra> bucarTodos();
    DetalleCompra guardar(DetalleCompra detalleCompra);
    DetalleCompra modificar(DetalleCompra detalleCompra);
    Optional<DetalleCompra> buscarId(Integer idDetalleCompra);
    void eliminar(Integer idDetalleCompra);
}