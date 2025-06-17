package com.sipsoft.licoreria.services;

import java.util.List;
import java.util.Optional;

import com.sipsoft.licoreria.entity.Rol;

public interface IRolService {
    List<Rol> bucarTodos();
    Rol guardar(Rol rol); // Cambiado de void a Rol
    Rol modificar(Rol rol); // Cambiado de void a Rol
    Optional<Rol> buscarId(Integer idRol);
    void eliminar(Integer idRol);
}