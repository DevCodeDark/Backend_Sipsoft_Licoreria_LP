package com.sipsoft.licoreria.services;

import java.util.List;
import com.sipsoft.licoreria.entity.ProveedorCategoria;
import com.sipsoft.licoreria.entity.ProveedorCategoriaId;

public interface IProveedorCategoriaService {
    List<ProveedorCategoria> findAll();
    ProveedorCategoria save(ProveedorCategoria proveedorCategoria);
    void deleteById(ProveedorCategoriaId id);
}