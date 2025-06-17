package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.DeudaProveedor;

public interface IDeudaProveedorService {
    List<DeudaProveedor> bucarTodos();
    DeudaProveedor guardar(DeudaProveedor deudaProveedor);
    DeudaProveedor modificar(DeudaProveedor deudaProveedor);
    Optional<DeudaProveedor> buscarId(Integer idDeuda);
    void eliminar(Integer idDeuda);
}
