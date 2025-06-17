package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipsoft.licoreria.dto.PermisoDTO;
import com.sipsoft.licoreria.entity.Permiso;
import com.sipsoft.licoreria.services.IPermisoService;

@RestController
@RequestMapping("/sipsoft")
public class PermisoController {
    @Autowired
    private IPermisoService servicePermiso;

    @GetMapping("/permisos")
    public List<Permiso> buscarTodos() {
        return servicePermiso.bucarTodos();
    }

    /**
     * Endpoint para crear un nuevo permiso.
     * @param permisoDto DTO con los IDs de Rol y Modulo.
     * @return El permiso creado.
     */
    @PostMapping("/permisos")
    public Permiso guardar(@RequestBody PermisoDTO permisoDto) {
        Permiso permiso = new Permiso();
        permiso.setIdRol(permisoDto.getIdRol());
        permiso.setIdModulo(permisoDto.getIdModulo());
        permiso.setEstadoPermiso(1); // Se establece el estado activo por defecto

        return servicePermiso.guardar(permiso);
    }

    /**
     * Endpoint para modificar un permiso existente.
     * @param permisoDto DTO con la información a actualizar.
     * @return El permiso modificado o un mensaje de error si no se encuentra.
     */
    @PutMapping("/permisos")
    public ResponseEntity<?> modificar(@RequestBody PermisoDTO permisoDto) {
        if (permisoDto.getIdPermiso() == null) {
            return ResponseEntity.badRequest().body("El idPermiso es requerido para modificar.");
        }
        
        Optional<Permiso> permisoOpt = servicePermiso.buscarId(permisoDto.getIdPermiso());
        if (permisoOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("No se encontró el Permiso con ID: " + permisoDto.getIdPermiso());
        }

        Permiso permisoExistente = permisoOpt.get();
        permisoExistente.setIdRol(permisoDto.getIdRol());
        permisoExistente.setIdModulo(permisoDto.getIdModulo());
        
        Permiso permisoModificado = servicePermiso.modificar(permisoExistente);
        return ResponseEntity.ok(permisoModificado);
    }

    @GetMapping("/permisos/{idPermiso}")
    public Optional<Permiso> buscarId(@PathVariable("idPermiso") Integer idPermiso) {
        return servicePermiso.buscarId(idPermiso);
    }

    @DeleteMapping("/permisos/{idPermiso}")
    public String eliminar(@PathVariable Integer idPermiso){
        servicePermiso.eliminar(idPermiso);
        return "Permiso eliminado";
    }
}