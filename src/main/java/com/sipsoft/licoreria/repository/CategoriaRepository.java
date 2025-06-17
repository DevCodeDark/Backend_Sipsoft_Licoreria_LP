package com.sipsoft.licoreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sipsoft.licoreria.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
