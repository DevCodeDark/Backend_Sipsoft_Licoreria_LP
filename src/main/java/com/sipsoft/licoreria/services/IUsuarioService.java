package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.Usuario;

public interface IUsuarioService {
    List<Usuario> bucarTodos();
    Usuario guardar(Usuario usuario); // Cambiado de void a Usuario
    Usuario modificar(Usuario usuario); // Cambiado de void a Usuario
    Optional<Usuario> buscarId(Integer idUsuario);
    void eliminar(Integer idUsuario);
}