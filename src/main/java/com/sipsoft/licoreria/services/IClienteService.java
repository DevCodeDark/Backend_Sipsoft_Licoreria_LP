package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.Cliente;

public interface IClienteService {
    List<Cliente> bucarTodos();
    Cliente guardar(Cliente cliente);
    Cliente modificar(Cliente cliente);
    Optional<Cliente> buscarId(Integer idCliente);
    void eliminar(Integer idCliente);
}
