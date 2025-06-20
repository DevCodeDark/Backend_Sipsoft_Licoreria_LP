package com.sipsoft.licoreria.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sipsoft.licoreria.entity.Permiso;

public interface PermisoRepository extends JpaRepository<Permiso, Integer> {
    @Query("SELECT p.modulo.urlModulo FROM Permiso p " +
           "WHERE p.rol.idRol = :idRol " +
           "AND p.estadoPermiso = 1 AND p.modulo.estadoModulo = 1")
    List<String> findRutasPermitidas(@Param("idRol") Integer idRol);

    //findByRolIdRolAndEmpresaIdEmpresa (incluir estadoPermiso, estadoModulo y estadoRol)
    @Query("SELECT p FROM Permiso p " +
              "WHERE p.rol.idRol = :idRol " +
              "AND p.estadoPermiso = 1 " +
              "AND p.modulo.estadoModulo = :estadoPermiso " +
              "AND p.rol.estadoRol = 1")
    List<Permiso> findByRolIdRolAndEstadoPermiso(@Param("idRol") Integer idRol, 
                                                  @Param("estadoPermiso") Integer estadoPermiso);

    List<Permiso> findByIdRol(Integer idRol);   

    Optional<Permiso> findByIdRolAndIdModulo(Integer idRol, Integer idModulo);



}
