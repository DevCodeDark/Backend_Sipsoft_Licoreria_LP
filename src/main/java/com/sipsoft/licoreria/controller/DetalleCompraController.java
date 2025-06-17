package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sipsoft.licoreria.dto.DetalleCompraDTO;
import com.sipsoft.licoreria.entity.DetalleCompra;
import com.sipsoft.licoreria.services.IDetalleCompraService;

@RestController
@RequestMapping("/sipsoft")
public class DetalleCompraController {
    @Autowired
    private IDetalleCompraService serviceDetalleCompra;

    @GetMapping("/detalle-compras")
    public List<DetalleCompraDTO> buscarTodos() {
        return serviceDetalleCompra.bucarTodos().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/detalle-compras/{idDetalleCompra}")
    public ResponseEntity<DetalleCompraDTO> buscarId(@PathVariable("idDetalleCompra") Integer idDetalleCompra) {
        return serviceDetalleCompra.buscarId(idDetalleCompra)
                .map(detalle -> ResponseEntity.ok(convertToDto(detalle)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/detalle-compras")
    public DetalleCompraDTO guardar(@RequestBody DetalleCompraDTO dto) {
        DetalleCompra detalleCompra = new DetalleCompra();
        mapDtoToEntity(dto, detalleCompra);
        detalleCompra.setEstadoDetalleCompra(1); // Estado activo por defecto
        
        DetalleCompra savedDetalle = serviceDetalleCompra.guardar(detalleCompra);
        return convertToDto(savedDetalle);
    }

    @PutMapping("/detalle-compras")
    public ResponseEntity<DetalleCompraDTO> modificar(@RequestBody DetalleCompraDTO dto) {
        if (dto.getIdDetalleCompra() == null) {
            return ResponseEntity.badRequest().build();
        }

        return serviceDetalleCompra.buscarId(dto.getIdDetalleCompra())
                .map(detalleExistente -> {
                    mapDtoToEntity(dto, detalleExistente);
                    DetalleCompra updatedDetalle = serviceDetalleCompra.modificar(detalleExistente);
                    return ResponseEntity.ok(convertToDto(updatedDetalle));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/detalle-compras/{idDetalleCompra}")
    public String eliminar(@PathVariable Integer idDetalleCompra){
        serviceDetalleCompra.eliminar(idDetalleCompra);
        return "Detalle de Compra eliminado";
    }

    // --- Métodos de Ayuda ---

    private DetalleCompraDTO convertToDto(DetalleCompra entity) {
        DetalleCompraDTO dto = new DetalleCompraDTO();
        dto.setIdDetalleCompra(entity.getIdDetalleCompra());
        dto.setCantidadCompra(entity.getCantidadCompra());
        dto.setPrecioCompra(entity.getPrecioCompra());
        dto.setSubtotalCompra(entity.getSubtotalCompra());
        dto.setIgvDetalle(entity.getIgvDetalle());
        dto.setTotalDetalle(entity.getTotalDetalle());
        dto.setEstadoDetalleCompra(entity.getEstadoDetalleCompra());
        dto.setIdCompra(entity.getIdCompra());
        dto.setIdLote(entity.getIdLote());
        dto.setIdProducto(entity.getIdProducto());
        return dto;
    }

    private void mapDtoToEntity(DetalleCompraDTO dto, DetalleCompra entity) {
        entity.setCantidadCompra(dto.getCantidadCompra());
        entity.setPrecioCompra(dto.getPrecioCompra());
        entity.setSubtotalCompra(dto.getSubtotalCompra());
        entity.setIgvDetalle(dto.getIgvDetalle());
        entity.setTotalDetalle(dto.getTotalDetalle());
        entity.setIdCompra(dto.getIdCompra());
        entity.setIdLote(dto.getIdLote());
        entity.setIdProducto(dto.getIdProducto());
    }
}