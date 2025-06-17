package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.TipoPago;

public interface ITipoPagoService {
    List<TipoPago> bucarTodos();
    TipoPago guardar(TipoPago tipoPago);
    TipoPago modificar(TipoPago tipoPago);
    Optional<TipoPago> buscarId(Integer idTipoPago);
    void eliminar(Integer idTipoPago);
}
