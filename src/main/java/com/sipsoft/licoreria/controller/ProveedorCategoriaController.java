package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.sipsoft.licoreria.dto.ProveedorCategoriaDTO;
import com.sipsoft.licoreria.entity.ProveedorCategoria;
import com.sipsoft.licoreria.services.IProveedorCategoriaService;

@RestController
@RequestMapping("/sipsoft")
public class ProveedorCategoriaController {

    @Autowired
    private IProveedorCategoriaService serviceProveedorCategoria;

    /**
     * Obtiene todas las relaciones proveedor-categoría.
     * 
     * @return Una lista de DTOs con los datos de las relaciones.
     */
    @GetMapping("/proveedor-categoria")
    @Transactional(readOnly = true)
    public List<ProveedorCategoriaDTO> buscarTodos() {
        return serviceProveedorCategoria.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    /**
     * Crea una nueva relación entre un proveedor y una categoría.
     * 
     * @param dto DTO con idProveedor y idCategoria.
     * @return El DTO de la relación creada.
     */
    @PostMapping("/proveedor-categoria")
    @Transactional
    public ProveedorCategoriaDTO guardar(@RequestBody ProveedorCategoriaDTO dto) {
        ProveedorCategoria pc = convertToEntity(dto);
        ProveedorCategoria savedPc = serviceProveedorCategoria.save(pc);
        return convertToDto(savedPc);
    }

    /**
     * Actualiza una relación existente.
     */
    @PutMapping("/proveedor-categoria")
    @Transactional
    public ResponseEntity<?> modificar(@RequestBody ProveedorCategoriaDTO dto) {
        if (dto.getIdProveedorCategoria() == null) {
            return ResponseEntity.badRequest().body("El idProveedorCategoria es requerido para modificar.");
        }

        Optional<ProveedorCategoria> pcOpt = serviceProveedorCategoria.findById(dto.getIdProveedorCategoria());
        if (pcOpt.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body("No se encontró la relación con ID: " + dto.getIdProveedorCategoria());
        }

        ProveedorCategoria pcExistente = pcOpt.get();
        pcExistente.setIdProveedor(dto.getIdProveedor());
        pcExistente.setIdCategoria(dto.getIdCategoria());

        ProveedorCategoria pcModificado = serviceProveedorCategoria.save(pcExistente);
        return ResponseEntity.ok(convertToDto(pcModificado));
    }

    /**
     * Busca una relación por ID.
     */
    @GetMapping("/proveedor-categoria/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<ProveedorCategoriaDTO> buscarPorId(@PathVariable Integer id) {
        Optional<ProveedorCategoria> pcOpt = serviceProveedorCategoria.findById(id);
        if (pcOpt.isPresent()) {
            return ResponseEntity.ok(convertToDto(pcOpt.get()));
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Elimina una relación por ID.
     */
    @DeleteMapping("/proveedor-categoria/{id}")
    @Transactional
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        if (serviceProveedorCategoria.findById(id).isPresent()) {
            serviceProveedorCategoria.deleteById(id);
            return ResponseEntity.ok("Relación proveedor-categoría eliminada");
        }
        return ResponseEntity.notFound().build();
    }

    // --- Métodos de ayuda para convertir entre Entidad y DTO ---

    private ProveedorCategoriaDTO convertToDto(ProveedorCategoria pc) {
        ProveedorCategoriaDTO dto = new ProveedorCategoriaDTO();
        dto.setIdProveedorCategoria(pc.getIdProveedorCategoria());
        dto.setIdProveedor(pc.getIdProveedor());
        dto.setIdCategoria(pc.getIdCategoria());
        return dto;
    }

    private ProveedorCategoria convertToEntity(ProveedorCategoriaDTO dto) {
        ProveedorCategoria pc = new ProveedorCategoria();
        pc.setIdProveedorCategoria(dto.getIdProveedorCategoria());
        pc.setIdProveedor(dto.getIdProveedor());
        pc.setIdCategoria(dto.getIdCategoria());
        return pc;
    }
}