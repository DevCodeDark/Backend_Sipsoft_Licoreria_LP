package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sipsoft.licoreria.dto.SerieComprobanteDTO;
import com.sipsoft.licoreria.entity.SerieComprobante;
import com.sipsoft.licoreria.services.ISerieComprobanteService;

@RestController
@RequestMapping("/sipsoft")
public class SerieComprobanteController {
    @Autowired
    private ISerieComprobanteService serviceSerieComprobante;

    @GetMapping("/series-comprobante")
    public List<SerieComprobanteDTO> buscarTodos() {
        return serviceSerieComprobante.bucarTodos().stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
    }

    @GetMapping("/series-comprobante/{idSerie}")
    public ResponseEntity<SerieComprobanteDTO> buscarId(@PathVariable("idSerie") Integer idSerie) {
        return serviceSerieComprobante.buscarId(idSerie)
            .map(serie -> ResponseEntity.ok(convertToDto(serie)))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/series-comprobante")
    public SerieComprobanteDTO guardar(@RequestBody SerieComprobanteDTO dto) {
        SerieComprobante serie = new SerieComprobante();
        serie.setNumSerie(dto.getNumSerie());
        serie.setIdTipoComprobante(dto.getIdTipoComprobante());
        serie.setIdEmpresa(dto.getIdEmpresa());
        serie.setEstadoSerie(1); // Activo por defecto

        SerieComprobante savedSerie = serviceSerieComprobante.guardar(serie);
        return convertToDto(savedSerie);
    }

    @PutMapping("/series-comprobante")
    public ResponseEntity<SerieComprobanteDTO> modificar(@RequestBody SerieComprobanteDTO dto) {
        if (dto.getIdSerie() == null) {
            return ResponseEntity.badRequest().build();
        }

        return serviceSerieComprobante.buscarId(dto.getIdSerie())
            .map(serieExistente -> {
                serieExistente.setNumSerie(dto.getNumSerie());
                serieExistente.setEstadoSerie(dto.getEstadoSerie());
                serieExistente.setIdTipoComprobante(dto.getIdTipoComprobante());
                serieExistente.setIdEmpresa(dto.getIdEmpresa());

                SerieComprobante updatedSerie = serviceSerieComprobante.modificar(serieExistente);
                return ResponseEntity.ok(convertToDto(updatedSerie));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/series-comprobante/{idSerie}")
    public String eliminar(@PathVariable Integer idSerie){
        serviceSerieComprobante.eliminar(idSerie);
        return "Serie de Comprobante eliminada";
    }

    private SerieComprobanteDTO convertToDto(SerieComprobante entity) {
        SerieComprobanteDTO dto = new SerieComprobanteDTO();
        dto.setIdSerie(entity.getIdSerie());
        dto.setNumSerie(entity.getNumSerie());
        dto.setEstadoSerie(entity.getEstadoSerie());
        dto.setIdTipoComprobante(entity.getIdTipoComprobante());
        dto.setIdEmpresa(entity.getIdEmpresa());
        return dto;
    }
}