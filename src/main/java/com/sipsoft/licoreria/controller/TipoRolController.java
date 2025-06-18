package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sipsoft.licoreria.dto.TipoRolDTO;
import com.sipsoft.licoreria.entity.TipoRol;
import com.sipsoft.licoreria.services.ITipoRolService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/sipsoft")
@Tag(name = "TipoRol", description = "Gestión de tipos de rol")
@SecurityRequirement(name = "bearerAuth")
public class TipoRolController {
    
    private final ITipoRolService tipoRolService;
    
    public TipoRolController(ITipoRolService tipoRolService) {
        this.tipoRolService = tipoRolService;
    }

    @GetMapping("/tipos-rol")
    @Operation(summary = "Obtener todos los tipos de rol activos", description = "Retorna la lista de todos los tipos de rol activos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista obtenida exitosamente"),
        @ApiResponse(responseCode = "403", description = "No autorizado")
    })
    public ResponseEntity<List<TipoRol>> buscarTodos() {
        List<TipoRol> tiposRol = tipoRolService.buscarActivos();
        return ResponseEntity.ok(tiposRol);
    }

    @GetMapping("/tipos-rol/{id}")
    @Operation(summary = "Obtener tipo de rol por ID", description = "Retorna un tipo de rol específico por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Tipo de rol encontrado"),
        @ApiResponse(responseCode = "404", description = "Tipo de rol no encontrado"),
        @ApiResponse(responseCode = "403", description = "No autorizado")
    })
    public ResponseEntity<TipoRol> buscarPorId(
            @Parameter(description = "ID del tipo de rol", required = true) 
            @PathVariable Integer id) {
        Optional<TipoRol> tipoRolOpt = tipoRolService.buscarPorIdActivo(id);
        return tipoRolOpt.map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/tipos-rol")
    @Operation(summary = "Crear un nuevo tipo de rol", description = "Crea un nuevo tipo de rol en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Tipo de rol creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos"),
        @ApiResponse(responseCode = "409", description = "Ya existe un tipo de rol con ese nombre"),
        @ApiResponse(responseCode = "403", description = "No autorizado")
    })
    public ResponseEntity<Object> guardar(@RequestBody TipoRolDTO dto) {
        if (dto.getTipoRol() == null || dto.getTipoRol().trim().isEmpty()) {
            return ResponseEntity.badRequest()
                    .body("El nombre del tipo de rol es obligatorio");
        }
        
        // Verificar si ya existe un tipo de rol con ese nombre
        if (tipoRolService.existePorNombre(dto.getTipoRol())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Ya existe un tipo de rol con el nombre: " + dto.getTipoRol());
        }
        
        TipoRol tipoRol = new TipoRol();
        tipoRol.setTipoRol(dto.getTipoRol());
        tipoRol.setDescripcionTipoRol(dto.getDescripcionTipoRol());
        tipoRol.setEstadoTipoRol(dto.getEstadoTipoRol() != null ? dto.getEstadoTipoRol() : 1);
        
        TipoRol tipoRolGuardado = tipoRolService.guardar(tipoRol);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoRolGuardado);
    }

    @PutMapping("/tipos-rol")
    @Operation(summary = "Actualizar un tipo de rol", description = "Actualiza un tipo de rol existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Tipo de rol actualizado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos"),
        @ApiResponse(responseCode = "404", description = "Tipo de rol no encontrado"),
        @ApiResponse(responseCode = "409", description = "Ya existe un tipo de rol con ese nombre"),
        @ApiResponse(responseCode = "403", description = "No autorizado")
    })
    public ResponseEntity<Object> actualizar(@RequestBody TipoRolDTO dto) {
        if (dto.getIdTipoRol() == null) {
            return ResponseEntity.badRequest()
                    .body("El ID del tipo de rol es obligatorio para la actualización");
        }
        
        if (dto.getTipoRol() == null || dto.getTipoRol().trim().isEmpty()) {
            return ResponseEntity.badRequest()
                    .body("El nombre del tipo de rol es obligatorio");
        }
        
        Optional<TipoRol> tipoRolExistenteOpt = tipoRolService.buscarPorIdActivo(dto.getIdTipoRol());
        if (tipoRolExistenteOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        // Verificar si ya existe otro tipo de rol con ese nombre
        Optional<TipoRol> tipoRolConNombreOpt = tipoRolService.buscarPorNombre(dto.getTipoRol());
        if (tipoRolConNombreOpt.isPresent() && 
            !tipoRolConNombreOpt.get().getIdTipoRol().equals(dto.getIdTipoRol())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Ya existe otro tipo de rol con el nombre: " + dto.getTipoRol());
        }
        
        TipoRol tipoRol = tipoRolExistenteOpt.get();
        tipoRol.setTipoRol(dto.getTipoRol());
        tipoRol.setDescripcionTipoRol(dto.getDescripcionTipoRol());
        tipoRol.setEstadoTipoRol(dto.getEstadoTipoRol() != null ? dto.getEstadoTipoRol() : tipoRol.getEstadoTipoRol());
        
        TipoRol tipoRolActualizado = tipoRolService.actualizar(tipoRol);
        return ResponseEntity.ok(tipoRolActualizado);
    }

    @DeleteMapping("/tipos-rol/{id}")
    @Operation(summary = "Eliminar un tipo de rol", description = "Elimina lógicamente un tipo de rol (cambia estado a inactivo)")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Tipo de rol eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Tipo de rol no encontrado"),
        @ApiResponse(responseCode = "403", description = "No autorizado")
    })
    public ResponseEntity<Object> eliminar(
            @Parameter(description = "ID del tipo de rol", required = true) 
            @PathVariable Integer id) {
        Optional<TipoRol> tipoRolOpt = tipoRolService.buscarPorIdActivo(id);
        if (tipoRolOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        tipoRolService.eliminarLogico(id);
        return ResponseEntity.ok().body("Tipo de rol eliminado exitosamente");
    }

    @GetMapping("/tipos-rol/buscar")
    @Operation(summary = "Buscar tipos de rol por nombre", description = "Busca tipos de rol que contengan el texto especificado en el nombre")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Búsqueda realizada exitosamente"),
        @ApiResponse(responseCode = "403", description = "No autorizado")
    })
    public ResponseEntity<List<TipoRol>> buscarPorNombre(
            @Parameter(description = "Texto a buscar en el nombre del tipo de rol", required = true)
            @RequestParam String nombre) {
        List<TipoRol> tiposRol = tipoRolService.buscarPorNombreContiene(nombre);
        return ResponseEntity.ok(tiposRol);
    }
}
