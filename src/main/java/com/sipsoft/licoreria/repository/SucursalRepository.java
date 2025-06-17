package com.sipsoft.licoreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sipsoft.licoreria.entity.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {

}
