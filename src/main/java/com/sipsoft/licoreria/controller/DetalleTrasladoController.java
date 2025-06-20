package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.sipsoft.licoreria.dto.DetalleTrasladoDTO;
import com.sipsoft.licoreria.entity.DetalleTraslado;
import com.sipsoft.licoreria.entity.Lote;
import com.sipsoft.licoreria.entity.Traslado;
import com.sipsoft.licoreria.repository.LoteRepository;
import com.sipsoft.licoreria.repository.TrasladoRepository;
import com.sipsoft.licoreria.services.IDetalleTrasladoService;

@RestController
@RequestMapping("/sipsoft")
public class DetalleTrasladoController {
    @Autowired
    private IDetalleTrasladoService serviceDetalleTraslado;

    @Autowired
    private TrasladoRepository repoTraslado;

    @Autowired
    private LoteRepository repoLote;

    @GetMapping("/detalle-traslado")
    @Transactional(readOnly = true)
    public List<DetalleTrasladoDTO> buscarTodos() {
        return serviceDetalleTraslado.buscarTodos().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/detalle-traslado/{idDetalleTraslado}")
    @Transactional(readOnly = true)
    public ResponseEntity<DetalleTrasladoDTO> buscarId(@PathVariable("idDetalleTraslado") Integer idDetalleTraslado) {
        return serviceDetalleTraslado.buscarId(idDetalleTraslado)
                .map(detalle -> ResponseEntity.ok(convertToDto(detalle)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/detalle-traslado")
    @Transactional
    public DetalleTrasladoDTO guardar(@RequestBody DetalleTrasladoDTO dto) {
        DetalleTraslado detalleTraslado = new DetalleTraslado();
        mapDtoToEntity(dto, detalleTraslado);

        DetalleTraslado savedDetalle = serviceDetalleTraslado.guardar(detalleTraslado);
        return convertToDto(savedDetalle);
    }

    @PutMapping("/detalle-traslado")
    @Transactional
    public ResponseEntity<DetalleTrasladoDTO> modificar(@RequestBody DetalleTrasladoDTO dto) {
        if (dto.getIdDetalleTraslado() == null) {
            return ResponseEntity.badRequest().build();
        }

        return serviceDetalleTraslado.buscarId(dto.getIdDetalleTraslado())
                .map(detalleExistente -> {
                    mapDtoToEntity(dto, detalleExistente);
                    DetalleTraslado updatedDetalle = serviceDetalleTraslado.modificar(detalleExistente);
                    return ResponseEntity.ok(convertToDto(updatedDetalle));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/detalle-traslado/{idDetalleTraslado}")
    @Transactional
    public String eliminar(@PathVariable Integer idDetalleTraslado) {
        serviceDetalleTraslado.eliminar(idDetalleTraslado);
        return "Detalle Traslado eliminado";
    }

    // --- Métodos de Ayuda ---

    private DetalleTrasladoDTO convertToDto(DetalleTraslado entity) {
        DetalleTrasladoDTO dto = new DetalleTrasladoDTO();
        dto.setIdDetalleTraslado(entity.getIdDetalleTraslado());
        dto.setCantidadTraslado(entity.getCantidadTraslado());
        dto.setEstadoDetalleTraslado(entity.getEstadoDetalleTraslado());

        // Extraer IDs de las relaciones
        if (entity.getIdTraslado() != null) {
            dto.setIdTraslado(entity.getIdTraslado().getIdTraslado());
        }
        if (entity.getIdLote() != null) {
            dto.setIdLote(entity.getIdLote().getIdLote());
        }

        return dto;
    }

    private void mapDtoToEntity(DetalleTrasladoDTO dto, DetalleTraslado entity) {
        entity.setCantidadTraslado(dto.getCantidadTraslado());

        // Si el estado no se envía en el DTO, se asigna el valor por defecto 1
        if (dto.getEstadoDetalleTraslado() != null) {
            entity.setEstadoDetalleTraslado(dto.getEstadoDetalleTraslado());
        } else {
            entity.setEstadoDetalleTraslado(1);
        }

        // Establecer relaciones por ID
        if (dto.getIdTraslado() != null) {
            Traslado traslado = repoTraslado.findById(dto.getIdTraslado()).orElse(null);
            entity.setIdTraslado(traslado);
        }
        if (dto.getIdLote() != null) {
            Lote lote = repoLote.findById(dto.getIdLote()).orElse(null);
            entity.setIdLote(lote);
        }
    }
}
