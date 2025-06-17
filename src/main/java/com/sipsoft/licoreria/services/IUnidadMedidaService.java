package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.UnidadMedida;

public interface IUnidadMedidaService {
    List<UnidadMedida> bucarTodos();
    UnidadMedida guardar(UnidadMedida unidadMedida);
    UnidadMedida modificar(UnidadMedida unidadMedida);
    Optional<UnidadMedida> buscarId(Integer idUnidadMedida);
    void eliminar(Integer idUnidadMedida);
}
