package com.sipsoft.licoreria.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.sipsoft.licoreria.dto.CajaDTO;
import com.sipsoft.licoreria.entity.Caja;
import com.sipsoft.licoreria.services.ICajaService;

@RestController
@RequestMapping("/sipsoft")
public class CajaController {
    @Autowired
    private ICajaService serviceCaja;

    @GetMapping("/cajas")
    @Transactional(readOnly = true)
    public List<CajaDTO> buscarTodos() {
        return serviceCaja.bucarTodos().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/cajas/{idCaja}")
    @Transactional(readOnly = true)
    public ResponseEntity<CajaDTO> buscarId(@PathVariable("idCaja") Integer idCaja) {
        return serviceCaja.buscarId(idCaja)
                .map(caja -> ResponseEntity.ok(convertToDto(caja)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/cajas")
    @Transactional
    public CajaDTO guardar(@RequestBody CajaDTO dto) {
        Caja caja = new Caja();
        caja.setNumCaja(dto.getNumCaja());
        caja.setMontoInicialCaja(dto.getMontoInicialCaja());
        caja.setIdSucursal(dto.getIdSucursal());
        caja.setIdUsuarioApertura(dto.getIdUsuarioApertura());

        // Valores automáticos
        caja.setFechaaperturaCaja(LocalDateTime.now());
        caja.setEstadoCaja(1); // 1 = Abierta

        Caja savedCaja = serviceCaja.guardar(caja);
        return convertToDto(savedCaja);
    }

    @PutMapping("/cajas")
    @Transactional
    public ResponseEntity<CajaDTO> modificar(@RequestBody CajaDTO dto) {
        if (dto.getIdCaja() == null) {
            return ResponseEntity.badRequest().build();
        }

        return serviceCaja.buscarId(dto.getIdCaja())
                .map(cajaExistente -> {
                    cajaExistente.setNumCaja(dto.getNumCaja());
                    cajaExistente.setMontoInicialCaja(dto.getMontoInicialCaja());
                    cajaExistente.setMontoFinalCaja(dto.getMontoFinalCaja());
                    cajaExistente.setFechacierreCaja(dto.getFechacierreCaja());
                    cajaExistente.setIdSucursal(dto.getIdSucursal());
                    cajaExistente.setIdUsuarioApertura(dto.getIdUsuarioApertura());
                    cajaExistente.setIdUsuarioCierre(dto.getIdUsuarioCierre());

                    // Solo actualizar el estado si se proporciona en el DTO, sino mantener el valor
                    // por defecto (1)
                    if (dto.getEstadoCaja() != null) {
                        cajaExistente.setEstadoCaja(dto.getEstadoCaja());
                    } else {
                        cajaExistente.setEstadoCaja(1); // Estado activo por defecto
                    }

                    Caja updatedCaja = serviceCaja.modificar(cajaExistente);
                    return ResponseEntity.ok(convertToDto(updatedCaja));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/cajas/{idCaja}")
    @Transactional
    public String eliminar(@PathVariable Integer idCaja) {
        serviceCaja.eliminar(idCaja);
        return "Caja eliminada";
    }

    private CajaDTO convertToDto(Caja entity) {
        CajaDTO dto = new CajaDTO();
        dto.setIdCaja(entity.getIdCaja());
        dto.setNumCaja(entity.getNumCaja());
        dto.setMontoInicialCaja(entity.getMontoInicialCaja());
        dto.setMontoFinalCaja(entity.getMontoFinalCaja());
        dto.setFechaaperturaCaja(entity.getFechaaperturaCaja());
        dto.setFechacierreCaja(entity.getFechacierreCaja());
        dto.setEstadoCaja(entity.getEstadoCaja());
        dto.setIdSucursal(entity.getIdSucursal());
        dto.setIdUsuarioApertura(entity.getIdUsuarioApertura());
        dto.setIdUsuarioCierre(entity.getIdUsuarioCierre());
        return dto;
    }
}