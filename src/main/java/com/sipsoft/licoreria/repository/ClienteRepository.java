package com.sipsoft.licoreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sipsoft.licoreria.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
