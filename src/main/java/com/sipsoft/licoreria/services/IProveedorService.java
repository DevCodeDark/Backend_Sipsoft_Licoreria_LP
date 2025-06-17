package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;
import com.sipsoft.licoreria.entity.Proveedor;

public interface IProveedorService {
    List<Proveedor> bucarTodos();
    Proveedor guardar(Proveedor proveedor);
    Proveedor modificar(Proveedor proveedor);
    Optional<Proveedor> buscarId(Integer idProveedor);
    void eliminar(Integer idProveedor);
}