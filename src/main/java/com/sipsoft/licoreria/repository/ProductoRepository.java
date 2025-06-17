package com.sipsoft.licoreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sipsoft.licoreria.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
