package com.sipsoft.licoreria.repository;

import com.sipsoft.licoreria.entity.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer> {
    
    /**
     * Busca un registro por email
     */
    Optional<Registro> findByEmail(String email);
    
    /**
     * Busca un registro por accessToken
     */
    Optional<Registro> findByAccessToken(String accessToken);
    
    /**
     * Busca un registro por clienteId
     */
    Optional<Registro> findByClienteId(String clienteId);
    
    /**
     * Busca un registro por email y clienteId para autenticación
     */
    @Query("SELECT r FROM Registro r WHERE r.email = :email AND r.clienteId = :clienteId")
    Optional<Registro> findByEmailAndClienteId(@Param("email") String email, @Param("clienteId") String clienteId);
    
    /**
     * Verifica si existe un registro con el email dado
     */
    boolean existsByEmail(String email);
    
    /**
     * Verifica si existe un registro con el accessToken dado
     */
    boolean existsByAccessToken(String accessToken);
    
    /**
     * Busca registros que tengan accessToken no nulo (registros activos)
     */
    @Query("SELECT r FROM Registro r WHERE r.accessToken IS NOT NULL")
    java.util.List<Registro> findRegistrosActivos();
}
