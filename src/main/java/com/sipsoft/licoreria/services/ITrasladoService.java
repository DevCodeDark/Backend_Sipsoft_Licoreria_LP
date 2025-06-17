package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;
import com.sipsoft.licoreria.entity.Traslado;

public interface ITrasladoService {
    List<Traslado> bucarTodos();
    Traslado guardar(Traslado traslado);
    Traslado modificar(Traslado traslado);
    Optional<Traslado> buscarId(Integer idTraslado);
    void eliminar(Integer idTraslado);
}