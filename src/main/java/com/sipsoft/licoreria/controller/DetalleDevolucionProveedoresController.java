package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sipsoft.licoreria.dto.DetalleDevolucionProveedoresDTO;
import com.sipsoft.licoreria.entity.DetalleDevolucionProveedores;
import com.sipsoft.licoreria.services.IDetalleDevolucionProveedoresService;

@RestController
@RequestMapping("/sipsoft")
public class DetalleDevolucionProveedoresController {
    @Autowired
    private IDetalleDevolucionProveedoresService serviceDetalleDevolucionProveedores;

    @GetMapping("/detalle-devolucion-proveedores")
    public List<DetalleDevolucionProveedoresDTO> buscarTodos() {
        return serviceDetalleDevolucionProveedores.bucarTodos().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/detalle-devolucion-proveedores/{idDetalleDevolucion}")
    public ResponseEntity<DetalleDevolucionProveedoresDTO> buscarId(@PathVariable("idDetalleDevolucion") Integer idDetalleDevolucion) {
        return serviceDetalleDevolucionProveedores.buscarId(idDetalleDevolucion)
                .map(detalle -> ResponseEntity.ok(convertToDto(detalle)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/detalle-devolucion-proveedores")
    public DetalleDevolucionProveedoresDTO guardar(@RequestBody DetalleDevolucionProveedoresDTO dto) {
        DetalleDevolucionProveedores detalle = new DetalleDevolucionProveedores();
        mapDtoToEntity(dto, detalle);
        detalle.setEstadoDetalleDevolucion(1); // Estado activo por defecto
        
        DetalleDevolucionProveedores savedDetalle = serviceDetalleDevolucionProveedores.guardar(detalle);
        return convertToDto(savedDetalle);
    }

    @PutMapping("/detalle-devolucion-proveedores")
    public ResponseEntity<DetalleDevolucionProveedoresDTO> modificar(@RequestBody DetalleDevolucionProveedoresDTO dto) {
        if (dto.getIdDetalleDevolucion() == null) {
            return ResponseEntity.badRequest().build();
        }

        return serviceDetalleDevolucionProveedores.buscarId(dto.getIdDetalleDevolucion())
                .map(detalleExistente -> {
                    mapDtoToEntity(dto, detalleExistente);
                    DetalleDevolucionProveedores updatedDetalle = serviceDetalleDevolucionProveedores.modificar(detalleExistente);
                    return ResponseEntity.ok(convertToDto(updatedDetalle));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/detalle-devolucion-proveedores/{idDetalleDevolucion}")
    public String eliminar(@PathVariable Integer idDetalleDevolucion){
        serviceDetalleDevolucionProveedores.eliminar(idDetalleDevolucion);
        return "Detalle de Devolucion a Proveedor eliminado";
    }

    // --- Métodos de Ayuda ---

    private DetalleDevolucionProveedoresDTO convertToDto(DetalleDevolucionProveedores entity) {
        DetalleDevolucionProveedoresDTO dto = new DetalleDevolucionProveedoresDTO();
        dto.setIdDetalleDevolucion(entity.getIdDetalleDevolucion());
        dto.setCantidadDevolucion(entity.getCantidadDevolucion());
        dto.setEstadoDetalleDevolucion(entity.getEstadoDetalleDevolucion());
        dto.setIdDevolucionCompra(entity.getIdDevolucionCompra());
        dto.setIdProducto(entity.getIdProducto());
        return dto;
    }

    private void mapDtoToEntity(DetalleDevolucionProveedoresDTO dto, DetalleDevolucionProveedores entity) {
        entity.setCantidadDevolucion(dto.getCantidadDevolucion());
        entity.setIdDevolucionCompra(dto.getIdDevolucionCompra());
        entity.setIdProducto(dto.getIdProducto());
    }
}