package com.sipsoft.licoreria.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sipsoft.licoreria.entity.SegmentoModulo;

@Repository
public interface SegmentoModuloRepository extends JpaRepository<SegmentoModulo, Integer> {
    
    @Query("SELECT sm FROM SegmentoModulo sm WHERE sm.estadoSegmento = 1")
    List<SegmentoModulo> findAllActive();
    
    @Query("SELECT sm FROM SegmentoModulo sm WHERE sm.idSegmento = :id AND sm.estadoSegmento = 1")
    Optional<SegmentoModulo> findByIdAndActive(@Param("id") Integer id);
    
    @Query("SELECT sm FROM SegmentoModulo sm WHERE UPPER(sm.descripcionSegmento) = UPPER(:descripcion) AND sm.estadoSegmento = 1")
    Optional<SegmentoModulo> findByDescripcionIgnoreCaseAndActive(@Param("descripcion") String descripcion);
    
    @Query("SELECT sm FROM SegmentoModulo sm WHERE UPPER(sm.descripcionSegmento) LIKE UPPER(CONCAT('%', :descripcion, '%')) AND sm.estadoSegmento = 1")
    List<SegmentoModulo> findByDescripcionContainingIgnoreCaseAndActive(@Param("descripcion") String descripcion);
    
    @Query("SELECT sm FROM SegmentoModulo sm LEFT JOIN FETCH sm.modulos m WHERE sm.estadoSegmento = 1 AND (m.estadoModulo = 1 OR m IS NULL)")
    List<SegmentoModulo> findAllActiveWithActiveModulos();
    
    @Query("SELECT sm FROM SegmentoModulo sm LEFT JOIN FETCH sm.modulos m WHERE sm.idSegmento = :id AND sm.estadoSegmento = 1 AND (m.estadoModulo = 1 OR m IS NULL)")
    Optional<SegmentoModulo> findByIdActiveWithActiveModulos(@Param("id") Integer id);
}
