package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sipsoft.licoreria.dto.SegmentoModuloDTO;
import com.sipsoft.licoreria.entity.SegmentoModulo;
import com.sipsoft.licoreria.services.ISegmentoModuloService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/sipsoft")
@Tag(name = "SegmentoModulo", description = "Gestión de segmentos de módulos")
@SecurityRequirement(name = "bearerAuth")
public class SegmentoModuloController {

    private final ISegmentoModuloService segmentoModuloService;

    public SegmentoModuloController(ISegmentoModuloService segmentoModuloService) {
        this.segmentoModuloService = segmentoModuloService;
    }

    @GetMapping("/segmentos-modulo")
    @Transactional(readOnly = true)
    @Operation(summary = "Obtener todos los segmentos de módulo activos", description = "Retorna la lista de todos los segmentos de módulo activos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista obtenida exitosamente"),
            @ApiResponse(responseCode = "403", description = "No autorizado")
    })
    public ResponseEntity<List<SegmentoModuloDTO>> buscarTodos() {
        try {
            List<SegmentoModulo> segmentosModulo = segmentoModuloService.buscarActivos();
            List<SegmentoModuloDTO> segmentosModuloDTO = segmentosModulo.stream()
                    .map(this::convertirEntidadADTO)
                    .toList();
            return ResponseEntity.ok(segmentosModuloDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/segmentos-modulo/con-modulos")
    @Transactional(readOnly = true)
    @Operation(summary = "Obtener segmentos de módulo con sus módulos", description = "Retorna la lista de segmentos de módulo activos con sus módulos activos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista obtenida exitosamente"),
            @ApiResponse(responseCode = "403", description = "No autorizado")
    })
    public ResponseEntity<List<SegmentoModuloDTO>> buscarTodosConModulos() {
        try {
            List<SegmentoModulo> segmentosModulo = segmentoModuloService.buscarActivosConModulos();
            List<SegmentoModuloDTO> segmentosModuloDTO = segmentosModulo.stream()
                    .map(this::convertirEntidadADTO)
                    .toList();
            return ResponseEntity.ok(segmentosModuloDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/segmentos-modulo/{id}")
    @Transactional(readOnly = true)
    @Operation(summary = "Obtener segmento de módulo por ID", description = "Retorna un segmento de módulo específico por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Segmento de módulo encontrado"),
            @ApiResponse(responseCode = "404", description = "Segmento de módulo no encontrado"),
            @ApiResponse(responseCode = "403", description = "No autorizado")
    })
    public ResponseEntity<SegmentoModuloDTO> buscarPorId(
            @Parameter(description = "ID del segmento de módulo", required = true) @PathVariable Integer id) {
        try {
            Optional<SegmentoModulo> segmentoModuloOpt = segmentoModuloService.buscarPorIdActivo(id);
            return segmentoModuloOpt.map(segmento -> ResponseEntity.ok(convertirEntidadADTO(segmento)))
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/segmentos-modulo/{id}/con-modulos")
    @Transactional(readOnly = true)
    @Operation(summary = "Obtener segmento de módulo con sus módulos por ID", description = "Retorna un segmento de módulo con sus módulos activos por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Segmento de módulo encontrado"),
            @ApiResponse(responseCode = "404", description = "Segmento de módulo no encontrado"),
            @ApiResponse(responseCode = "403", description = "No autorizado")
    })
    public ResponseEntity<SegmentoModuloDTO> buscarPorIdConModulos(
            @Parameter(description = "ID del segmento de módulo", required = true) @PathVariable Integer id) {
        try {
            Optional<SegmentoModulo> segmentoModuloOpt = segmentoModuloService.buscarPorIdActivoConModulos(id);
            return segmentoModuloOpt.map(segmento -> ResponseEntity.ok(convertirEntidadADTO(segmento)))
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/segmentos-modulo")
    @Transactional
    @Operation(summary = "Crear un nuevo segmento de módulo", description = "Crea un nuevo segmento de módulo en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Segmento de módulo creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"),
            @ApiResponse(responseCode = "409", description = "Ya existe un segmento de módulo con esa descripción"),
            @ApiResponse(responseCode = "403", description = "No autorizado")
    })
    public ResponseEntity<Object> guardar(@RequestBody SegmentoModuloDTO dto) {
        try {
            if (dto.getDescripcionSegmento() == null || dto.getDescripcionSegmento().trim().isEmpty()) {
                return ResponseEntity.badRequest()
                        .body("La descripción del segmento de módulo es obligatoria");
            }

            // Verificar si ya existe un segmento de módulo con esa descripción
            if (segmentoModuloService.existePorDescripcion(dto.getDescripcionSegmento())) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Ya existe un segmento de módulo con la descripción: " + dto.getDescripcionSegmento());
            }

            SegmentoModulo segmentoModulo = convertirDTOAEntidad(dto);
            SegmentoModulo segmentoModuloGuardado = segmentoModuloService.guardar(segmentoModulo);
            return ResponseEntity.status(HttpStatus.CREATED).body(convertirEntidadADTO(segmentoModuloGuardado));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear el segmento de módulo");
        }
    }

    @PutMapping("/segmentos-modulo")
    @Transactional
    @Operation(summary = "Actualizar un segmento de módulo", description = "Actualiza un segmento de módulo existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Segmento de módulo actualizado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"),
            @ApiResponse(responseCode = "404", description = "Segmento de módulo no encontrado"),
            @ApiResponse(responseCode = "409", description = "Ya existe un segmento de módulo con esa descripción"),
            @ApiResponse(responseCode = "403", description = "No autorizado")
    })
    public ResponseEntity<Object> actualizar(@RequestBody SegmentoModuloDTO dto) {
        try {
            if (dto.getIdSegmento() == null) {
                return ResponseEntity.badRequest()
                        .body("El ID del segmento de módulo es obligatorio para la actualización");
            }

            if (dto.getDescripcionSegmento() == null || dto.getDescripcionSegmento().trim().isEmpty()) {
                return ResponseEntity.badRequest()
                        .body("La descripción del segmento de módulo es obligatoria");
            }

            Optional<SegmentoModulo> segmentoModuloExistenteOpt = segmentoModuloService
                    .buscarPorIdActivo(dto.getIdSegmento());
            if (segmentoModuloExistenteOpt.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            // Verificar si ya existe otro segmento de módulo con esa descripción
            Optional<SegmentoModulo> segmentoModuloConDescripcionOpt = segmentoModuloService
                    .buscarPorDescripcion(dto.getDescripcionSegmento());
            if (segmentoModuloConDescripcionOpt.isPresent() &&
                    !segmentoModuloConDescripcionOpt.get().getIdSegmento().equals(dto.getIdSegmento())) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Ya existe otro segmento de módulo con la descripción: " + dto.getDescripcionSegmento());
            }

            SegmentoModulo segmentoModulo = segmentoModuloExistenteOpt.get();
            segmentoModulo.setDescripcionSegmento(dto.getDescripcionSegmento());
            segmentoModulo.setIconoSegmento(dto.getIconoSegmento());
            segmentoModulo.setEstadoSegmento(
                    dto.getEstadoSegmento() != null ? dto.getEstadoSegmento() : segmentoModulo.getEstadoSegmento());

            SegmentoModulo segmentoModuloActualizado = segmentoModuloService.actualizar(segmentoModulo);
            return ResponseEntity.ok(convertirEntidadADTO(segmentoModuloActualizado));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el segmento de módulo");
        }
    }

    @DeleteMapping("/segmentos-modulo/{id}")
    @Transactional
    @Operation(summary = "Eliminar un segmento de módulo", description = "Elimina lógicamente un segmento de módulo (cambia estado a inactivo)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Segmento de módulo eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Segmento de módulo no encontrado"),
            @ApiResponse(responseCode = "403", description = "No autorizado")
    })
    public ResponseEntity<Object> eliminar(
            @Parameter(description = "ID del segmento de módulo", required = true) @PathVariable Integer id) {
        Optional<SegmentoModulo> segmentoModuloOpt = segmentoModuloService.buscarPorIdActivo(id);
        if (segmentoModuloOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        segmentoModuloService.eliminarLogico(id);
        return ResponseEntity.ok().body("Segmento de módulo eliminado exitosamente");
    }

    @GetMapping("/segmentos-modulo/buscar")
    @Transactional(readOnly = true)
    @Operation(summary = "Buscar segmentos de módulo por descripción", description = "Busca segmentos de módulo que contengan el texto especificado en la descripción")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Búsqueda realizada exitosamente"),
            @ApiResponse(responseCode = "403", description = "No autorizado")
    })
    public ResponseEntity<List<SegmentoModuloDTO>> buscarPorDescripcion(
            @Parameter(description = "Texto a buscar en la descripción del segmento de módulo", required = true) @RequestParam String descripcion) {
        try {
            List<SegmentoModulo> segmentosModulo = segmentoModuloService.buscarPorDescripcionContiene(descripcion);
            List<SegmentoModuloDTO> segmentosModuloDTO = segmentosModulo.stream()
                    .map(this::convertirEntidadADTO)
                    .toList();
            return ResponseEntity.ok(segmentosModuloDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Métodos de conversión entre entidad y DTO
    private SegmentoModuloDTO convertirEntidadADTO(SegmentoModulo segmentoModulo) {
        SegmentoModuloDTO dto = new SegmentoModuloDTO();
        dto.setIdSegmento(segmentoModulo.getIdSegmento());
        dto.setDescripcionSegmento(segmentoModulo.getDescripcionSegmento());
        dto.setIconoSegmento(segmentoModulo.getIconoSegmento());
        dto.setEstadoSegmento(segmentoModulo.getEstadoSegmento());
        return dto;
    }

    private SegmentoModulo convertirDTOAEntidad(SegmentoModuloDTO dto) {
        SegmentoModulo segmentoModulo = new SegmentoModulo();
        segmentoModulo.setIdSegmento(dto.getIdSegmento());
        segmentoModulo.setDescripcionSegmento(dto.getDescripcionSegmento());
        segmentoModulo.setIconoSegmento(dto.getIconoSegmento());
        segmentoModulo.setEstadoSegmento(dto.getEstadoSegmento() != null ? dto.getEstadoSegmento() : 1);
        return segmentoModulo;
    }
}
