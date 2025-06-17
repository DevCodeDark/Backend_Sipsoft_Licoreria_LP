package com.sipsoft.licoreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sipsoft.licoreria.entity.Transaccion;

public interface TransaccionRepository extends JpaRepository<Transaccion, Integer> {

}
