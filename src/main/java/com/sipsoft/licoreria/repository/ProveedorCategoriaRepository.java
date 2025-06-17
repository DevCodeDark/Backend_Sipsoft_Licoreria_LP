package com.sipsoft.licoreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sipsoft.licoreria.entity.ProveedorCategoria;
import com.sipsoft.licoreria.entity.ProveedorCategoriaId;

public interface ProveedorCategoriaRepository extends JpaRepository<ProveedorCategoria, ProveedorCategoriaId> {
}