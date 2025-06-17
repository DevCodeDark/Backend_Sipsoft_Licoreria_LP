package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;
import com.sipsoft.licoreria.entity.Caja;

public interface ICajaService {
    List<Caja> bucarTodos();
    Caja guardar(Caja caja);
    Caja modificar(Caja caja);
    Optional<Caja> buscarId(Integer idCaja);
    void eliminar(Integer idCaja);
}