package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sipsoft.licoreria.dto.DetalleOrdenCompraDTO;
import com.sipsoft.licoreria.entity.DetalleOrdenCompra;
import com.sipsoft.licoreria.services.IDetalleOrdenCompraService;

@RestController
@RequestMapping("/sipsoft")
public class DetalleOrdenCompraController {
    @Autowired
    private IDetalleOrdenCompraService serviceDetalleOrdenCompra;

    @GetMapping("/detalle-orden-compra")
    public List<DetalleOrdenCompraDTO> buscarTodos() {
        return serviceDetalleOrdenCompra.bucarTodos().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/detalle-orden-compra/{idDetalleOrden}")
    public ResponseEntity<DetalleOrdenCompraDTO> buscarId(@PathVariable("idDetalleOrden") Integer idDetalleOrden) {
        return serviceDetalleOrdenCompra.buscarId(idDetalleOrden)
                .map(detalle -> ResponseEntity.ok(convertToDto(detalle)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/detalle-orden-compra")
    public DetalleOrdenCompraDTO guardar(@RequestBody DetalleOrdenCompraDTO dto) {
        DetalleOrdenCompra detalle = new DetalleOrdenCompra();
        mapDtoToEntity(dto, detalle);
        detalle.setActivo(true); // Se establece como activo por defecto
        
        DetalleOrdenCompra savedDetalle = serviceDetalleOrdenCompra.guardar(detalle);
        return convertToDto(savedDetalle);
    }

    @PutMapping("/detalle-orden-compra")
    public ResponseEntity<DetalleOrdenCompraDTO> modificar(@RequestBody DetalleOrdenCompraDTO dto) {
        if (dto.getIdDetalleOrden() == null) {
            return ResponseEntity.badRequest().build();
        }

        return serviceDetalleOrdenCompra.buscarId(dto.getIdDetalleOrden())
                .map(detalleExistente -> {
                    mapDtoToEntity(dto, detalleExistente);
                    DetalleOrdenCompra updatedDetalle = serviceDetalleOrdenCompra.modificar(detalleExistente);
                    return ResponseEntity.ok(convertToDto(updatedDetalle));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/detalle-orden-compra/{idDetalleOrden}")
    public String eliminar(@PathVariable Integer idDetalleOrden){
        serviceDetalleOrdenCompra.eliminar(idDetalleOrden);
        return "Detalle de Orden de Compra eliminado";
    }

    // --- Métodos de Ayuda ---

    private DetalleOrdenCompraDTO convertToDto(DetalleOrdenCompra entity) {
        DetalleOrdenCompraDTO dto = new DetalleOrdenCompraDTO();
        dto.setIdDetalleOrden(entity.getIdDetalleOrden());
        dto.setActivo(entity.getActivo());
        dto.setCantidadSolicitada(entity.getCantidadSolicitada());
        dto.setObservacionesDetalle(entity.getObservacionesDetalle());
        dto.setPrecioUnitario(entity.getPrecioUnitario());
        dto.setIdOrden(entity.getIdOrden());
        dto.setIdProducto(entity.getIdProducto());
        return dto;
    }

    private void mapDtoToEntity(DetalleOrdenCompraDTO dto, DetalleOrdenCompra entity) {
        entity.setCantidadSolicitada(dto.getCantidadSolicitada());
        entity.setObservacionesDetalle(dto.getObservacionesDetalle());
        entity.setPrecioUnitario(dto.getPrecioUnitario());
        entity.setIdOrden(dto.getIdOrden());
        entity.setIdProducto(dto.getIdProducto());
    }
}