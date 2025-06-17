package com.sipsoft.licoreria.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sipsoft.licoreria.dto.OrdenCompraDTO;
import com.sipsoft.licoreria.entity.OrdenCompra;
import com.sipsoft.licoreria.services.IOrdenCompraService;

@RestController
@RequestMapping("/sipsoft")
public class OrdenCompraController {
    @Autowired
    private IOrdenCompraService serviceOrdenCompra;

    @GetMapping("/ordenes-compra")
    public List<OrdenCompraDTO> buscarTodos() {
        return serviceOrdenCompra.bucarTodos().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/ordenes-compra/{idOrden}")
    public ResponseEntity<OrdenCompraDTO> buscarId(@PathVariable("idOrden") Integer idOrden) {
        return serviceOrdenCompra.buscarId(idOrden)
                .map(orden -> ResponseEntity.ok(convertToDto(orden)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/ordenes-compra")
    public OrdenCompraDTO guardar(@RequestBody OrdenCompraDTO dto) {
        OrdenCompra orden = new OrdenCompra();
        mapDtoToEntity(dto, orden);

        // Valores automáticos para la creación
        LocalDateTime now = LocalDateTime.now();
        orden.setFechaRegistro(now);
        orden.setFechaActualizacion(now);
        orden.setActivo(true);
        if (orden.getEstado() == null) {
            orden.setEstado("GENERADA");
        }
        
        OrdenCompra savedOrden = serviceOrdenCompra.guardar(orden);
        return convertToDto(savedOrden);
    }

    @PutMapping("/ordenes-compra")
    public ResponseEntity<OrdenCompraDTO> modificar(@RequestBody OrdenCompraDTO dto) {
        if (dto.getIdOrden() == null) {
            return ResponseEntity.badRequest().build();
        }

        return serviceOrdenCompra.buscarId(dto.getIdOrden())
                .map(ordenExistente -> {
                    mapDtoToEntity(dto, ordenExistente);
                    ordenExistente.setFechaActualizacion(LocalDateTime.now());
                    
                    OrdenCompra updatedOrden = serviceOrdenCompra.modificar(ordenExistente);
                    return ResponseEntity.ok(convertToDto(updatedOrden));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/ordenes-compra/{idOrden}")
    public String eliminar(@PathVariable Integer idOrden){
        serviceOrdenCompra.eliminar(idOrden);
        return "Orden de Compra eliminada";
    }

    // --- Métodos de Ayuda ---

    private OrdenCompraDTO convertToDto(OrdenCompra entity) {
        OrdenCompraDTO dto = new OrdenCompraDTO();
        dto.setIdOrden(entity.getIdOrden());
        dto.setActivo(entity.getActivo());
        dto.setEstado(entity.getEstado());
        dto.setFechaActualizacion(entity.getFechaActualizacion());
        dto.setFechaEnvio(entity.getFechaEnvio());
        dto.setFechaOrden(entity.getFechaOrden());
        dto.setFechaRegistro(entity.getFechaRegistro());
        dto.setFechaRespuesta(entity.getFechaRespuesta());
        dto.setObservaciones(entity.getObservaciones());
        dto.setIdEmpresa(entity.getIdEmpresa());
        dto.setIdProveedor(entity.getIdProveedor());
        dto.setIdTipoPago(entity.getIdTipoPago());
        return dto;
    }

    private void mapDtoToEntity(OrdenCompraDTO dto, OrdenCompra entity) {
        entity.setEstado(dto.getEstado());
        entity.setFechaEnvio(dto.getFechaEnvio());
        entity.setFechaOrden(dto.getFechaOrden());
        entity.setFechaRespuesta(dto.getFechaRespuesta());
        entity.setObservaciones(dto.getObservaciones());
        entity.setIdEmpresa(dto.getIdEmpresa());
        entity.setIdProveedor(dto.getIdProveedor());
        entity.setIdTipoPago(dto.getIdTipoPago());
    }
}