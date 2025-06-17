package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;
import com.sipsoft.licoreria.entity.Comprobante;

public interface IComprobanteService {
    List<Comprobante> bucarTodos();
    Comprobante guardar(Comprobante comprobante);
    Comprobante modificar(Comprobante comprobante);
    Optional<Comprobante> buscarId(Integer idComprobante);
    void eliminar(Integer idComprobante);
}