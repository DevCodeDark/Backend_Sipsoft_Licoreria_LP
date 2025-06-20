package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipsoft.licoreria.dto.TipoPagoDTO;
import com.sipsoft.licoreria.entity.Empresa;
import com.sipsoft.licoreria.entity.TipoPago;
import com.sipsoft.licoreria.repository.EmpresaRepository;
import com.sipsoft.licoreria.services.ITipoPagoService;

@RestController
@RequestMapping("/sipsoft")
public class TipoPagoController {
    @Autowired
    private ITipoPagoService serviceTipoPago;

    @Autowired
    EmpresaRepository repoEmpresa;

    @GetMapping("/tipos-pago")
    @Transactional(readOnly = true)
    public ResponseEntity<List<TipoPagoDTO>> buscarTodos() {
        try {
            List<TipoPago> tiposPago = serviceTipoPago.buscarTodos();
            List<TipoPagoDTO> tiposPagoDTO = tiposPago.stream()
                    .map(this::convertirEntidadADTO)
                    .toList();
            return ResponseEntity.ok(tiposPagoDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/tipos-pago")
    @Transactional
    public ResponseEntity<TipoPagoDTO> guardar(@RequestBody TipoPagoDTO dto) {
        try {
            TipoPago tipoPago = new TipoPago();
            tipoPago.setDescripcionPago(dto.getDescripcionPago());
            tipoPago.setEstadoTipoPago(dto.getEstadoTipoPago() != null ? dto.getEstadoTipoPago() : 1);

            if (dto.getIdEmpresa() != null) {
                Empresa empresa = repoEmpresa.findById(dto.getIdEmpresa()).orElse(null);
                tipoPago.setIdEmpresa(empresa);
            }

            TipoPago guardado = serviceTipoPago.guardar(tipoPago);
            TipoPagoDTO resultDto = convertirEntidadADTO(guardado);
            return ResponseEntity.status(HttpStatus.CREATED).body(resultDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/tipos-pago")
    @Transactional
    public ResponseEntity<TipoPagoDTO> modificar(@RequestBody TipoPagoDTO dto) {
        try {
            if (dto.getIdTipoPago() == null) {
                return ResponseEntity.badRequest().build();
            }
            TipoPago tipoPago = new TipoPago();
            tipoPago.setIdTipoPago(dto.getIdTipoPago());
            tipoPago.setDescripcionPago(dto.getDescripcionPago());
            tipoPago.setEstadoTipoPago(dto.getEstadoTipoPago() != null ? dto.getEstadoTipoPago() : 1);

            if (dto.getIdEmpresa() != null) {
                Empresa empresa = repoEmpresa.findById(dto.getIdEmpresa()).orElse(null);
                tipoPago.setIdEmpresa(empresa);
            }

            TipoPago modificado = serviceTipoPago.modificar(tipoPago);
            TipoPagoDTO resultDto = convertirEntidadADTO(modificado);
            return ResponseEntity.ok(resultDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/tipos-pago/{idTipoPago}")
    @Transactional(readOnly = true)
    public ResponseEntity<TipoPagoDTO> buscarId(@PathVariable("idTipoPago") Integer idTipoPago) {
        try {
            Optional<TipoPago> tipoPago = serviceTipoPago.buscarId(idTipoPago);
            if (tipoPago.isPresent()) {
                TipoPagoDTO dto = convertirEntidadADTO(tipoPago.get());
                return ResponseEntity.ok(dto);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/tipos-pago/{idTipoPago}")
    @Transactional
    public String eliminar(@PathVariable Integer idTipoPago) {
        serviceTipoPago.eliminar(idTipoPago);
        return "Tipo Pago eliminado";
    }

    // Métodos de conversión
    private TipoPagoDTO convertirEntidadADTO(TipoPago entidad) {
        TipoPagoDTO dto = new TipoPagoDTO();
        dto.setIdTipoPago(entidad.getIdTipoPago());
        dto.setDescripcionPago(entidad.getDescripcionPago());
        dto.setEstadoTipoPago(entidad.getEstadoTipoPago());
        dto.setIdEmpresa(entidad.getEmpresaId());
        return dto;
    }
}
