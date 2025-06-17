package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.Sucursal;

public interface ISucursalService {
    List<Sucursal> bucarTodos();
    Sucursal guardar(Sucursal sucursal);
    Sucursal modificar(Sucursal sucursal);
    Optional<Sucursal> buscarId(Integer idSucursal);
    void eliminar(Integer idSucursal);
}
