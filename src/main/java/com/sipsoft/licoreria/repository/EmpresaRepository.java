package com.sipsoft.licoreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sipsoft.licoreria.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

}
