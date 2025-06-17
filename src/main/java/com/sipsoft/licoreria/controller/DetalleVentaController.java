package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sipsoft.licoreria.dto.DetalleVentaDTO;
import com.sipsoft.licoreria.entity.DetalleVenta;
import com.sipsoft.licoreria.services.IDetalleVentaService;

@RestController
@RequestMapping("/sipsoft")
public class DetalleVentaController {
    @Autowired
    private IDetalleVentaService serviceDetalleVenta;

    @GetMapping("/detalle-ventas")
    public List<DetalleVentaDTO> buscarTodos() {
        return serviceDetalleVenta.bucarTodos().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/detalle-ventas/{idDetalleVenta}")
    public ResponseEntity<DetalleVentaDTO> buscarId(@PathVariable("idDetalleVenta") Integer idDetalleVenta) {
        return serviceDetalleVenta.buscarId(idDetalleVenta)
                .map(detalle -> ResponseEntity.ok(convertToDto(detalle)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/detalle-ventas")
    public DetalleVentaDTO guardar(@RequestBody DetalleVentaDTO dto) {
        DetalleVenta detalle = new DetalleVenta();
        mapDtoToEntity(dto, detalle);
        detalle.setEstadoDetalleVenta(1); // Estado activo por defecto
        
        DetalleVenta savedDetalle = serviceDetalleVenta.guardar(detalle);
        return convertToDto(savedDetalle);
    }

    @PutMapping("/detalle-ventas")
    public ResponseEntity<DetalleVentaDTO> modificar(@RequestBody DetalleVentaDTO dto) {
        if (dto.getIdDetalleVenta() == null) {
            return ResponseEntity.badRequest().build();
        }

        return serviceDetalleVenta.buscarId(dto.getIdDetalleVenta())
                .map(detalleExistente -> {
                    mapDtoToEntity(dto, detalleExistente);
                    DetalleVenta updatedDetalle = serviceDetalleVenta.modificar(detalleExistente);
                    return ResponseEntity.ok(convertToDto(updatedDetalle));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/detalle-ventas/{idDetalleVenta}")
    public String eliminar(@PathVariable Integer idDetalleVenta){
        serviceDetalleVenta.eliminar(idDetalleVenta);
        return "Detalle de Venta eliminado";
    }

    // --- Métodos de Ayuda ---

    private DetalleVentaDTO convertToDto(DetalleVenta entity) {
        DetalleVentaDTO dto = new DetalleVentaDTO();
        dto.setIdDetalleVenta(entity.getIdDetalleVenta());
        dto.setPrecioUnitario(entity.getPrecioUnitario());
        dto.setDescuentoVenta(entity.getDescuentoVenta());
        dto.setCantidadVenta(entity.getCantidadVenta());
        dto.setSubtotalVenta(entity.getSubtotalVenta());
        dto.setEstadoDetalleVenta(entity.getEstadoDetalleVenta());
        dto.setTipoDescuento(entity.getTipoDescuento());
        dto.setIdVenta(entity.getIdVenta());
        dto.setIdLote(entity.getIdLote());
        return dto;
    }

    private void mapDtoToEntity(DetalleVentaDTO dto, DetalleVenta entity) {
        entity.setPrecioUnitario(dto.getPrecioUnitario());
        entity.setDescuentoVenta(dto.getDescuentoVenta());
        entity.setCantidadVenta(dto.getCantidadVenta());
        entity.setSubtotalVenta(dto.getSubtotalVenta());
        entity.setTipoDescuento(dto.getTipoDescuento());
        entity.setIdVenta(dto.getIdVenta());
        entity.setIdLote(dto.getIdLote());
    }
}