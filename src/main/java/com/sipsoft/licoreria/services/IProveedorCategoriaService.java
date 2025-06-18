package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;
import com.sipsoft.licoreria.entity.ProveedorCategoria;

public interface IProveedorCategoriaService {
    List<ProveedorCategoria> findAll();
    ProveedorCategoria save(ProveedorCategoria proveedorCategoria);
    Optional<ProveedorCategoria> findById(Integer id);
    void deleteById(Integer id);
}