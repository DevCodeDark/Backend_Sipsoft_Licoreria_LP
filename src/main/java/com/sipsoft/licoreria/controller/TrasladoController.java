package com.sipsoft.licoreria.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.sipsoft.licoreria.dto.TrasladoDTO;
import com.sipsoft.licoreria.entity.Traslado;
import com.sipsoft.licoreria.services.ITrasladoService;

@RestController
@RequestMapping("/sipsoft")
public class TrasladoController {
    @Autowired
    private ITrasladoService serviceTraslado;

    @GetMapping("/traslados")
    @Transactional(readOnly = true)
    public List<TrasladoDTO> buscarTodos() {
        return serviceTraslado.buscarTodos().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/traslados/{idTraslado}")
    @Transactional(readOnly = true)
    public ResponseEntity<TrasladoDTO> buscarId(@PathVariable("idTraslado") Integer idTraslado) {
        return serviceTraslado.buscarId(idTraslado)
                .map(traslado -> ResponseEntity.ok(convertToDto(traslado)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/traslados")
    @Transactional
    public TrasladoDTO guardar(@RequestBody TrasladoDTO dto) {
        Traslado traslado = new Traslado();
        traslado.setIdAlmacenOrigen(dto.getIdAlmacenOrigen());
        traslado.setIdAlmacenDestino(dto.getIdAlmacenDestino());
        traslado.setFechaTraslado(LocalDateTime.now());
        traslado.setEstadoTraslado(1); // Estado activo por defecto

        Traslado savedTraslado = serviceTraslado.guardar(traslado);
        return convertToDto(savedTraslado);
    }

    @PutMapping("/traslados")
    @Transactional
    public ResponseEntity<TrasladoDTO> modificar(@RequestBody TrasladoDTO dto) {
        if (dto.getIdTraslado() == null) {
            return ResponseEntity.badRequest().build();
        }

        return serviceTraslado.buscarId(dto.getIdTraslado())
                .map(trasladoExistente -> {
                    trasladoExistente.setIdAlmacenOrigen(dto.getIdAlmacenOrigen());
                    trasladoExistente.setIdAlmacenDestino(dto.getIdAlmacenDestino());
                    trasladoExistente.setFechaTraslado(LocalDateTime.now());

                    Traslado updatedTraslado = serviceTraslado.modificar(trasladoExistente);
                    return ResponseEntity.ok(convertToDto(updatedTraslado));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/traslados/{idTraslado}")
    @Transactional
    public String eliminar(@PathVariable Integer idTraslado) {
        serviceTraslado.eliminar(idTraslado);
        return "Traslado eliminado";
    }

    // --- Métodos de Ayuda ---

    private TrasladoDTO convertToDto(Traslado entity) {
        TrasladoDTO dto = new TrasladoDTO();
        dto.setIdTraslado(entity.getIdTraslado());
        dto.setFechaTraslado(entity.getFechaTraslado());
        dto.setEstadoTraslado(entity.getEstadoTraslado());
        dto.setIdAlmacenOrigen(entity.getIdAlmacenOrigen());
        dto.setIdAlmacenDestino(entity.getIdAlmacenDestino());
        return dto;
    }
}