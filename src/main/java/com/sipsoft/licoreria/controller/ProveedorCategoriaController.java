package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sipsoft.licoreria.dto.ProveedorCategoriaDTO;
import com.sipsoft.licoreria.entity.Categoria;
import com.sipsoft.licoreria.entity.Proveedor;
import com.sipsoft.licoreria.entity.ProveedorCategoria;
import com.sipsoft.licoreria.entity.ProveedorCategoriaId;
import com.sipsoft.licoreria.services.IProveedorCategoriaService;

@RestController
@RequestMapping("/sipsoft")
public class ProveedorCategoriaController {

    @Autowired
    private IProveedorCategoriaService serviceProveedorCategoria;

    /**
     * Obtiene todas las relaciones proveedor-categoría.
     * @return Una lista de DTOs, cada uno con idProveedor y idCategoria.
     */
    @GetMapping("/proveedor-categoria")
    public List<ProveedorCategoriaDTO> buscarTodos() {
        return serviceProveedorCategoria.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    /**
     * Crea una nueva relación entre un proveedor y una categoría.
     * @param dto DTO con idProveedor y idCategoria.
     * @return El DTO de la relación creada.
     */
    @PostMapping("/proveedor-categoria")
    public ProveedorCategoriaDTO guardar(@RequestBody ProveedorCategoriaDTO dto) {
        ProveedorCategoria pc = convertToEntity(dto);
        ProveedorCategoria savedPc = serviceProveedorCategoria.save(pc);
        return convertToDto(savedPc);
    }

    /**
     * Elimina una relación existente.
     * Para "actualizar", simplemente elimina la relación incorrecta y crea una nueva con POST.
     */
    @DeleteMapping("/proveedor-categoria/proveedor/{idProveedor}/categoria/{idCategoria}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Integer idProveedor,
            @PathVariable Integer idCategoria) {
        serviceProveedorCategoria.deleteById(new ProveedorCategoriaId(idProveedor, idCategoria));
        return ResponseEntity.noContent().build();
    }
    
    // --- Métodos de ayuda para convertir entre Entidad y DTO ---

    private ProveedorCategoriaDTO convertToDto(ProveedorCategoria pc) {
        ProveedorCategoriaDTO dto = new ProveedorCategoriaDTO();
        if (pc.getId() != null) {
            dto.setIdProveedor(pc.getId().getIdProveedor());
            dto.setIdCategoria(pc.getId().getIdCategoria());
        }
        return dto;
    }

    private ProveedorCategoria convertToEntity(ProveedorCategoriaDTO dto) {
        ProveedorCategoria pc = new ProveedorCategoria();
        pc.setId(new ProveedorCategoriaId(dto.getIdProveedor(), dto.getIdCategoria()));
        
        // Asociamos las entidades (JPA las usará para la relación)
        pc.setProveedor(new Proveedor(dto.getIdProveedor()));
        
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(dto.getIdCategoria());
        pc.setCategoria(categoria);
        
        return pc;
    }
}