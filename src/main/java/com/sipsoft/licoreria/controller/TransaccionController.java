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

import com.sipsoft.licoreria.dto.TransaccionDTO;
import com.sipsoft.licoreria.entity.Caja;
import com.sipsoft.licoreria.entity.TipoPago;
import com.sipsoft.licoreria.entity.Transaccion;
import com.sipsoft.licoreria.entity.Usuario;
import com.sipsoft.licoreria.repository.CajaRepository;
import com.sipsoft.licoreria.repository.TipoPagoRepository;
import com.sipsoft.licoreria.repository.UsuarioRepository;
import com.sipsoft.licoreria.services.ITransaccionService;

@RestController
@RequestMapping("/sipsoft")
public class TransaccionController {
    @Autowired
    private ITransaccionService serviceTransaccion;

    @Autowired
    private TipoPagoRepository repoPago;

    @Autowired
    private UsuarioRepository repoUsuario;

    @Autowired
    private CajaRepository repoCaja;

    @GetMapping("/transacciones")
    @Transactional(readOnly = true)
    public ResponseEntity<List<TransaccionDTO>> buscarTodos() {
        try {
            List<Transaccion> transacciones = serviceTransaccion.buscarTodos();
            List<TransaccionDTO> transaccionesDTO = transacciones.stream()
                    .map(this::convertirEntidadADTO)
                    .toList();
            return ResponseEntity.ok(transaccionesDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/transacciones")
    @Transactional
    public ResponseEntity<TransaccionDTO> guardar(@RequestBody TransaccionDTO dto) {
        try {
            Transaccion transaccion = new Transaccion();
            transaccion.setMotivoTransaccion(dto.getMotivoTransaccion());
            transaccion.setMontoTransaccion(dto.getMontoTransaccion());
            transaccion.setTipo(dto.getTipo());
            transaccion.setEstado(dto.getEstado() != null ? dto.getEstado() : 1);
            transaccion.setFechaTransaccion(dto.getFechaTransaccion());

            if (dto.getIdTipoPago() != null) {
                TipoPago tipoPago = repoPago.findById(dto.getIdTipoPago()).orElse(null);
                transaccion.setIdTipoPago(tipoPago);
            }

            if (dto.getIdUsuario() != null) {
                Usuario usuario = repoUsuario.findById(dto.getIdUsuario()).orElse(null);
                transaccion.setIdUsuario(usuario);
            }

            if (dto.getIdCaja() != null) {
                Caja caja = repoCaja.findById(dto.getIdCaja()).orElse(null);
                transaccion.setIdCaja(caja);
            }

            Transaccion guardada = serviceTransaccion.guardar(transaccion);
            TransaccionDTO resultDto = convertirEntidadADTO(guardada);
            return ResponseEntity.status(HttpStatus.CREATED).body(resultDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/transacciones")
    @Transactional
    public ResponseEntity<TransaccionDTO> modificar(@RequestBody TransaccionDTO dto) {
        try {
            if (dto.getIdTransaccion() == null) {
                return ResponseEntity.badRequest().build();
            }
            Transaccion transaccion = new Transaccion();
            transaccion.setIdTransaccion(dto.getIdTransaccion());
            transaccion.setMotivoTransaccion(dto.getMotivoTransaccion());
            transaccion.setMontoTransaccion(dto.getMontoTransaccion());
            transaccion.setTipo(dto.getTipo());
            transaccion.setEstado(dto.getEstado() != null ? dto.getEstado() : 1);
            transaccion.setFechaTransaccion(dto.getFechaTransaccion());

            if (dto.getIdTipoPago() != null) {
                TipoPago tipoPago = repoPago.findById(dto.getIdTipoPago()).orElse(null);
                transaccion.setIdTipoPago(tipoPago);
            }

            if (dto.getIdUsuario() != null) {
                Usuario usuario = repoUsuario.findById(dto.getIdUsuario()).orElse(null);
                transaccion.setIdUsuario(usuario);
            }

            if (dto.getIdCaja() != null) {
                Caja caja = repoCaja.findById(dto.getIdCaja()).orElse(null);
                transaccion.setIdCaja(caja);
            }

            Transaccion modificada = serviceTransaccion.modificar(transaccion);
            TransaccionDTO resultDto = convertirEntidadADTO(modificada);
            return ResponseEntity.ok(resultDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/transacciones/{idTransaccion}")
    @Transactional(readOnly = true)
    public ResponseEntity<TransaccionDTO> buscarId(@PathVariable("idTransaccion") Integer idTransaccion) {
        try {
            Optional<Transaccion> transaccion = serviceTransaccion.buscarId(idTransaccion);
            if (transaccion.isPresent()) {
                TransaccionDTO dto = convertirEntidadADTO(transaccion.get());
                return ResponseEntity.ok(dto);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/transacciones/{idTransaccion}")
    @Transactional
    public String eliminar(@PathVariable Integer idTransaccion) {
        serviceTransaccion.eliminar(idTransaccion);
        return "Transaccion eliminada";
    } // Métodos de conversión

    private TransaccionDTO convertirEntidadADTO(Transaccion entidad) {
        TransaccionDTO dto = new TransaccionDTO();
        dto.setIdTransaccion(entidad.getIdTransaccion());
        dto.setMotivoTransaccion(entidad.getMotivoTransaccion());
        dto.setMontoTransaccion(entidad.getMontoTransaccion());
        dto.setTipo(entidad.getTipo());
        dto.setEstado(entidad.getEstado());
        dto.setFechaTransaccion(entidad.getFechaTransaccion());
        dto.setIdTipoPago(entidad.getTipoPagoId());
        dto.setIdUsuario(entidad.getUsuarioId());
        dto.setIdCaja(entidad.getCajaId());
        return dto;
    }
}
