package com.sipsoft.licoreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sipsoft.licoreria.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
