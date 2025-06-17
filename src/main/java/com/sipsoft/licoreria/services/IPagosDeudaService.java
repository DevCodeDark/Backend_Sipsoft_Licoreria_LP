package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.PagosDeuda;

public interface IPagosDeudaService {
    List<PagosDeuda> bucarTodos();
    PagosDeuda guardar(PagosDeuda pagosDeuda);
    PagosDeuda modificar(PagosDeuda pagosDeuda);
    Optional<PagosDeuda> buscarId(Integer idPagosDeuda);
    void eliminar(Integer idPagosDeuda);
}
