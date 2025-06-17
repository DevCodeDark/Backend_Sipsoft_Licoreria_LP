package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;
import com.sipsoft.licoreria.entity.SerieComprobante;

public interface ISerieComprobanteService {
    List<SerieComprobante> bucarTodos();
    SerieComprobante guardar(SerieComprobante serieComprobante);
    SerieComprobante modificar(SerieComprobante serieComprobante);
    Optional<SerieComprobante> buscarId(Integer idSerie);
    void eliminar(Integer idSerie);
}