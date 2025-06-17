package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.Categoria;

public interface ICategoriaService {
    List<Categoria> bucarTodos();
    Categoria guardar(Categoria categoria);
    Categoria modificar(Categoria categoria);
    Optional<Categoria> buscarId(Integer idCategoria);
    void eliminar(Integer idCategoria);
}
