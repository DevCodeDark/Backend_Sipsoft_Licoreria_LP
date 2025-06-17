package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.TipoComprobante;

public interface ITipoComprobanteService {
    List<TipoComprobante> bucarTodos();
    void guardar(TipoComprobante tipoComprobante);
    void modificar(TipoComprobante tipoComprobante);
    Optional<TipoComprobante> buscarId(Integer idTipoComprobante);
    void eliminar(Integer idTipoComprobante);
}
