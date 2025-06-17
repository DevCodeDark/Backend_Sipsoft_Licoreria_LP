package com.sipsoft.licoreria.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sipsoft.licoreria.dto.DevolucionCompraDTO;
import com.sipsoft.licoreria.entity.DevolucionCompra;
import com.sipsoft.licoreria.services.IDevolucionCompraService;

@RestController
@RequestMapping("/sipsoft")
public class DevolucionCompraController {
    @Autowired
    private IDevolucionCompraService serviceDevolucionCompra;

    @GetMapping("/devolucion-compra")
    public List<DevolucionCompraDTO> buscarTodos() {
        return serviceDevolucionCompra.bucarTodos().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/devolucion-compra/{idDevolucionCompra}")
    public ResponseEntity<DevolucionCompraDTO> buscarId(@PathVariable("idDevolucionCompra") Integer idDevolucionCompra) {
        return serviceDevolucionCompra.buscarId(idDevolucionCompra)
                .map(devolucion -> ResponseEntity.ok(convertToDto(devolucion)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/devolucion-compra")
    public DevolucionCompraDTO guardar(@RequestBody DevolucionCompraDTO dto) {
        DevolucionCompra devolucion = new DevolucionCompra();
        mapDtoToEntity(dto, devolucion);
        
        // Valores automáticos
        devolucion.setFechaDevolucionCompra(LocalDateTime.now());
        devolucion.setEstadoDevolucionCompra(1); // 1 = REGISTRADO
        
        DevolucionCompra savedDevolucion = serviceDevolucionCompra.guardar(devolucion);
        return convertToDto(savedDevolucion);
    }

    @PutMapping("/devolucion-compra")
    public ResponseEntity<DevolucionCompraDTO> modificar(@RequestBody DevolucionCompraDTO dto) {
        if (dto.getIdDevolucionCompra() == null) {
            return ResponseEntity.badRequest().build();
        }

        return serviceDevolucionCompra.buscarId(dto.getIdDevolucionCompra())
                .map(devolucionExistente -> {
                    mapDtoToEntity(dto, devolucionExistente);
                    
                    // Opcional: Actualizar el estado si es necesario desde el DTO
                    if(dto.getEstadoDevolucionCompra() != null) {
                        devolucionExistente.setEstadoDevolucionCompra(dto.getEstadoDevolucionCompra());
                    }
                    
                    DevolucionCompra updatedDevolucion = serviceDevolucionCompra.modificar(devolucionExistente);
                    return ResponseEntity.ok(convertToDto(updatedDevolucion));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/devolucion-compra/{idDevolucionCompra}")
    public String eliminar(@PathVariable Integer idDevolucionCompra){
        serviceDevolucionCompra.eliminar(idDevolucionCompra);
        return "Devolucion de Compra eliminada";
    }

    // --- Métodos de Ayuda ---

    private DevolucionCompraDTO convertToDto(DevolucionCompra entity) {
        DevolucionCompraDTO dto = new DevolucionCompraDTO();
        dto.setIdDevolucionCompra(entity.getIdDevolucionCompra());
        dto.setFechaDevolucionCompra(entity.getFechaDevolucionCompra());
        dto.setMotivoDevolucionCompra(entity.getMotivoDevolucionCompra());
        dto.setImagenDevolucion(entity.getImagenDevolucion());
        dto.setEstadoDevolucionCompra(entity.getEstadoDevolucionCompra());
        dto.setIdDetalleCompra(entity.getIdDetalleCompra());
        return dto;
    }

    private void mapDtoToEntity(DevolucionCompraDTO dto, DevolucionCompra entity) {
        entity.setMotivoDevolucionCompra(dto.getMotivoDevolucionCompra());
        entity.setImagenDevolucion(dto.getImagenDevolucion());
        entity.setIdDetalleCompra(dto.getIdDetalleCompra());
    }
}