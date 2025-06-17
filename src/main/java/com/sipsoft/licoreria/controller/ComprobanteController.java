package com.sipsoft.licoreria.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sipsoft.licoreria.dto.ComprobanteDTO;
import com.sipsoft.licoreria.entity.Comprobante;
import com.sipsoft.licoreria.services.IComprobanteService;

@RestController
@RequestMapping("/sipsoft")
public class ComprobanteController {
    @Autowired
    private IComprobanteService serviceComprobante;

    @GetMapping("/comprobantes")
    public List<ComprobanteDTO> buscarTodos() {
        return serviceComprobante.bucarTodos().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/comprobantes/{idComprobante}")
    public ResponseEntity<ComprobanteDTO> buscarId(@PathVariable("idComprobante") Integer idComprobante) {
        return serviceComprobante.buscarId(idComprobante)
                .map(comprobante -> ResponseEntity.ok(convertToDto(comprobante)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/comprobantes")
    public ComprobanteDTO guardar(@RequestBody ComprobanteDTO dto) {
        Comprobante comprobante = new Comprobante();
        mapDtoToEntity(dto, comprobante);
        
        // Valores automáticos
        comprobante.setFechaEmision(LocalDate.now());
        comprobante.setEstadoComprobante(1); // 1 = Activo
        
        Comprobante savedComprobante = serviceComprobante.guardar(comprobante);
        return convertToDto(savedComprobante);
    }

    @PutMapping("/comprobantes")
    public ResponseEntity<ComprobanteDTO> modificar(@RequestBody ComprobanteDTO dto) {
        if (dto.getIdComprobante() == null) {
            return ResponseEntity.badRequest().build();
        }

        return serviceComprobante.buscarId(dto.getIdComprobante())
                .map(comprobanteExistente -> {
                    mapDtoToEntity(dto, comprobanteExistente);
                    comprobanteExistente.setFechaEmision(LocalDate.now());
                    Comprobante updatedComprobante = serviceComprobante.modificar(comprobanteExistente);
                    return ResponseEntity.ok(convertToDto(updatedComprobante));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/comprobantes/{idComprobante}")
    public String eliminar(@PathVariable Integer idComprobante){
        serviceComprobante.eliminar(idComprobante);
        return "Comprobante eliminado";
    }

    // --- Métodos de Ayuda ---

    private ComprobanteDTO convertToDto(Comprobante entity) {
        ComprobanteDTO dto = new ComprobanteDTO();
        dto.setIdComprobante(entity.getIdComprobante());
        dto.setCorrelativoComprobante(entity.getCorrelativoComprobante());
        dto.setEstadoComprobante(entity.getEstadoComprobante());
        dto.setDireccionEmpresa(entity.getDireccionEmpresa());
        dto.setFechaEmision(entity.getFechaEmision());
        dto.setNombreComprobante(entity.getNombreComprobante());
        dto.setNumComprobante(entity.getNumComprobante());
        dto.setTelefonoEmpresa(entity.getTelefonoEmpresa());
        dto.setIdVenta(entity.getIdVenta());
        dto.setIdSerie(entity.getIdSerie());
        dto.setIdCaja(entity.getIdCaja());
        dto.setIdCompra(entity.getIdCompra());
        dto.setIdTipoComprobante(entity.getIdTipoComprobante());
        return dto;
    }

    private void mapDtoToEntity(ComprobanteDTO dto, Comprobante entity) {
        entity.setCorrelativoComprobante(dto.getCorrelativoComprobante());
        entity.setDireccionEmpresa(dto.getDireccionEmpresa());
        entity.setNombreComprobante(dto.getNombreComprobante());
        entity.setNumComprobante(dto.getNumComprobante());
        entity.setTelefonoEmpresa(dto.getTelefonoEmpresa());
        entity.setIdVenta(dto.getIdVenta());
        entity.setIdSerie(dto.getIdSerie());
        entity.setIdCaja(dto.getIdCaja());
        entity.setIdCompra(dto.getIdCompra());
        entity.setIdTipoComprobante(dto.getIdTipoComprobante());
    }
}