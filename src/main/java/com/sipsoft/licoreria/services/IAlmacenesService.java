package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.Almacen;

public interface IAlmacenesService {
    List<Almacen> bucarTodos();
    Almacen guardar(Almacen almacen); //AQUI
    Almacen modificar(Almacen almacen); //AQUI
    Optional<Almacen> buscarId(Integer idAlmacen);
    void eliminar(Integer idAlmacen);
}
