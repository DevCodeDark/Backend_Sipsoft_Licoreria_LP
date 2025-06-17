package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.Producto;

public interface IProductoService {
    List<Producto> bucarTodos();
    Producto guardar(Producto producto);
    Producto modificar(Producto producto);
    Optional<Producto> buscarId(Integer idProducto);
    void eliminar(Integer idProducto);
}
