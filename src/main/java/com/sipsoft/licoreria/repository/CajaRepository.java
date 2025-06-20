package com.sipsoft.licoreria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sipsoft.licoreria.entity.Caja;

public interface CajaRepository extends JpaRepository<Caja, Integer> {
    
    // Buscar cajas por estado específico
    List<Caja> findByEstadoCaja(Integer estadoCaja);
    
    // Buscar solo cajas activas (estado = 1)
    @Query("SELECT c FROM Caja c WHERE c.estadoCaja = 1")
    List<Caja> findCajasActivas();
    
    // Buscar solo cajas inactivas (estado = 0)
    @Query("SELECT c FROM Caja c WHERE c.estadoCaja = 0")
    List<Caja> findCajasInactivas();
    
    // Buscar cajas por sucursal y estado
    List<Caja> findByIdSucursalAndEstadoCaja(Integer idSucursal, Integer estadoCaja);
}
