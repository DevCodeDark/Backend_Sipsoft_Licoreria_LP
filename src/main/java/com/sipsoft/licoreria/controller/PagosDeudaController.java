package com.sipsoft.licoreria.controller;

import java.util.List;

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

import com.sipsoft.licoreria.dto.PagosDeudaDTO;
import com.sipsoft.licoreria.entity.PagosDeuda;
import com.sipsoft.licoreria.repository.DeudaProveedorRepository;
import com.sipsoft.licoreria.services.IPagosDeudaService;

@RestController
@RequestMapping("/sipsoft")
public class PagosDeudaController {
    @Autowired
    private IPagosDeudaService servicePagosDeuda;

    @Autowired
    private DeudaProveedorRepository repoDeudaProveedor;

    @GetMapping("/pagos-deuda")
    @Transactional(readOnly = true)
    public ResponseEntity<List<PagosDeudaDTO>> buscarTodos() {
        try {
            List<PagosDeuda> pagosDeuda = servicePagosDeuda.bucarTodos();
            List<PagosDeudaDTO> pagosDeudaDTO = pagosDeuda.stream()
                    .map(this::convertirEntidadADTO)
                    .toList();
            return ResponseEntity.ok(pagosDeudaDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/pagos-deuda")
    @Transactional
    public ResponseEntity<PagosDeudaDTO> guardar(@RequestBody PagosDeudaDTO dto) {
        try {
            PagosDeuda pagosDeuda = convertirDTOAEntidad(dto);
            PagosDeuda pagosDeudaGuardado = servicePagosDeuda.guardar(pagosDeuda);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(convertirEntidadADTO(pagosDeudaGuardado));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/pagos-deuda")
    @Transactional
    public ResponseEntity<PagosDeudaDTO> modificar(@RequestBody PagosDeudaDTO dto) {
        try {
            if (dto.getIdPagosDeuda() == null) {
                return ResponseEntity.badRequest().build();
            }

            PagosDeuda pagosDeuda = convertirDTOAEntidad(dto);
            PagosDeuda pagosDeudaModificado = servicePagosDeuda.modificar(pagosDeuda);
            return ResponseEntity.ok(convertirEntidadADTO(pagosDeudaModificado));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/pagos-deuda/{idPagosDeuda}")
    @Transactional(readOnly = true)
    public ResponseEntity<PagosDeudaDTO> buscarId(@PathVariable("idPagosDeuda") Integer idPagosDeuda) {
        try {
            return servicePagosDeuda.buscarId(idPagosDeuda)
                    .map(pagosDeuda -> ResponseEntity.ok(convertirEntidadADTO(pagosDeuda)))
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/pagos-deuda/{idPagosDeuda}")
    @Transactional
    public ResponseEntity<String> eliminar(@PathVariable Integer idPagosDeuda) {
        try {
            servicePagosDeuda.eliminar(idPagosDeuda);
            return ResponseEntity.ok("Pago Deuda eliminado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el pago de deuda");
        }
    }

    // Métodos de conversión entre entidad y DTO
    private PagosDeudaDTO convertirEntidadADTO(PagosDeuda pagosDeuda) {
        PagosDeudaDTO dto = new PagosDeudaDTO();
        dto.setIdPagosDeuda(pagosDeuda.getIdPagosDeuda());
        dto.setFechaPagoParcialDeuda(pagosDeuda.getFechaPagoParcialDeuda());
        dto.setMontoAbonado(pagosDeuda.getMontoAbonado());
        dto.setObservaciones(pagosDeuda.getObservaciones());
        dto.setEstadoPagosDeuda(pagosDeuda.getEstadoPagosDeuda());
        dto.setIdDeuda(pagosDeuda.getDeudaId());
        return dto;
    }

    private PagosDeuda convertirDTOAEntidad(PagosDeudaDTO dto) {
        PagosDeuda pagosDeuda = new PagosDeuda();
        pagosDeuda.setIdPagosDeuda(dto.getIdPagosDeuda());
        pagosDeuda.setFechaPagoParcialDeuda(dto.getFechaPagoParcialDeuda());
        pagosDeuda.setMontoAbonado(dto.getMontoAbonado());
        pagosDeuda.setObservaciones(dto.getObservaciones());
        pagosDeuda.setEstadoPagosDeuda(dto.getEstadoPagosDeuda() != null ? dto.getEstadoPagosDeuda() : 1);

        // Cargar la relación si el ID está presente
        if (dto.getIdDeuda() != null) {
            pagosDeuda.setIdDeuda(repoDeudaProveedor.findById(dto.getIdDeuda()).orElse(null));
        }

        return pagosDeuda;
    }
}
