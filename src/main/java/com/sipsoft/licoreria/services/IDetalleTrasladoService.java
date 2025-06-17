package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.DetalleTraslado;

public interface IDetalleTrasladoService {
    List<DetalleTraslado> bucarTodos();
    DetalleTraslado guardar(DetalleTraslado detalleTraslado);
    DetalleTraslado modificar(DetalleTraslado detalleTraslado);
    Optional<DetalleTraslado> buscarId(Integer idDetalleTraslado);
    void eliminar(Integer idDetalleTraslado);
}
