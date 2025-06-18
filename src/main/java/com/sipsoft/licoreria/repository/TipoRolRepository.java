package com.sipsoft.licoreria.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sipsoft.licoreria.entity.TipoRol;

@Repository
public interface TipoRolRepository extends JpaRepository<TipoRol, Integer> {
    
    @Query("SELECT tr FROM TipoRol tr WHERE tr.estadoTipoRol = 1")
    List<TipoRol> findAllActive();
    
    @Query("SELECT tr FROM TipoRol tr WHERE tr.idTipoRol = :id AND tr.estadoTipoRol = 1")
    Optional<TipoRol> findByIdAndActive(@Param("id") Integer id);
    
    @Query("SELECT tr FROM TipoRol tr WHERE UPPER(tr.tipoRol) = UPPER(:tipoRol) AND tr.estadoTipoRol = 1")
    Optional<TipoRol> findByTipoRolIgnoreCaseAndActive(@Param("tipoRol") String tipoRol);
    
    @Query("SELECT tr FROM TipoRol tr WHERE UPPER(tr.tipoRol) LIKE UPPER(CONCAT('%', :tipoRol, '%')) AND tr.estadoTipoRol = 1")
    List<TipoRol> findByTipoRolContainingIgnoreCaseAndActive(@Param("tipoRol") String tipoRol);
}
