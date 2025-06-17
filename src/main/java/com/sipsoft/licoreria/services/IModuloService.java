package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.Modulo;

public interface IModuloService {
    List<Modulo> bucarTodos();
    Modulo guardar(Modulo modulo);
    Modulo modificar(Modulo modulo);
    Optional<Modulo> buscarId(Integer idModulo);
    void eliminar(Integer idModulo);
}