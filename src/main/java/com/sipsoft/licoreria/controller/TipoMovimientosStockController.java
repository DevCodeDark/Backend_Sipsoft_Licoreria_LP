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

import com.sipsoft.licoreria.dto.TipoMovimientosStockDTO;
import com.sipsoft.licoreria.entity.Empresa;
import com.sipsoft.licoreria.entity.TipoMovimientosStock;
import com.sipsoft.licoreria.repository.EmpresaRepository;
import com.sipsoft.licoreria.services.ITipoMovimientosStockService;

@RestController
@RequestMapping("/sipsoft")
public class TipoMovimientosStockController {
    @Autowired
    private ITipoMovimientosStockService serviceTipoMovimientosStock;

    @Autowired
    private EmpresaRepository repoEmpresa;

    @GetMapping("/tipos-movimientos-stock")
    @Transactional(readOnly = true)
    public ResponseEntity<List<TipoMovimientosStockDTO>> buscarTodos() {
        try {
            List<TipoMovimientosStock> tipoMovimientos = serviceTipoMovimientosStock.buscarTodos();
            List<TipoMovimientosStockDTO> tipoMovimientosDTO = tipoMovimientos.stream()
                    .map(this::convertirEntidadADTO)
                    .toList();
            return ResponseEntity.ok(tipoMovimientosDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/tipos-movimientos-stock")
    @Transactional
    public ResponseEntity<TipoMovimientosStockDTO> guardar(@RequestBody TipoMovimientosStockDTO dto) {
        try {
            TipoMovimientosStock tipomovimientostock = new TipoMovimientosStock();
            tipomovimientostock.setDescripcionMovimiento(dto.getDescripcionMovimiento());

            if (dto.getIdEmpresa() != null) {
                Empresa empresa = repoEmpresa.findById(dto.getIdEmpresa()).orElse(null);
                tipomovimientostock.setIdEmpresa(empresa);
            }

            TipoMovimientosStock guardado = serviceTipoMovimientosStock.guardar(tipomovimientostock);
            TipoMovimientosStockDTO resultDto = convertirEntidadADTO(guardado);
            return ResponseEntity.status(HttpStatus.CREATED).body(resultDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/tipos-movimientos-stock")
    @Transactional
    public ResponseEntity<TipoMovimientosStockDTO> modificar(@RequestBody TipoMovimientosStockDTO dto) {
        try {
            if (dto.getIdTipoMovimiento() == null) {
                return ResponseEntity.badRequest().build();
            }
            TipoMovimientosStock tipomovimientostock = new TipoMovimientosStock();
            tipomovimientostock.setIdTipoMovimiento(dto.getIdTipoMovimiento());
            tipomovimientostock.setDescripcionMovimiento(dto.getDescripcionMovimiento());

            if (dto.getIdEmpresa() != null) {
                Empresa empresa = repoEmpresa.findById(dto.getIdEmpresa()).orElse(null);
                tipomovimientostock.setIdEmpresa(empresa);
            }

            TipoMovimientosStock modificado = serviceTipoMovimientosStock.modificar(tipomovimientostock);
            TipoMovimientosStockDTO resultDto = convertirEntidadADTO(modificado);
            return ResponseEntity.ok(resultDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/tipos-movimientos-stock/{idTipoMovimiento}")
    @Transactional(readOnly = true)
    public ResponseEntity<TipoMovimientosStockDTO> buscarId(
            @PathVariable("idTipoMovimiento") Integer idTipoMovimiento) {
        try {
            Optional<TipoMovimientosStock> tipoMovimiento = serviceTipoMovimientosStock.buscarId(idTipoMovimiento);
            if (tipoMovimiento.isPresent()) {
                TipoMovimientosStockDTO dto = convertirEntidadADTO(tipoMovimiento.get());
                return ResponseEntity.ok(dto);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/tipos-movimientos-stock/{idTipoMovimiento}")
    @Transactional
    public String eliminar(@PathVariable Integer idTipoMovimiento) {
        serviceTipoMovimientosStock.eliminar(idTipoMovimiento);
        return "Tipo Movimiento Stock eliminado";
    }

    // Métodos de conversión
    private TipoMovimientosStockDTO convertirEntidadADTO(TipoMovimientosStock entidad) {
        TipoMovimientosStockDTO dto = new TipoMovimientosStockDTO();
        dto.setIdTipoMovimiento(entidad.getIdTipoMovimiento());
        dto.setDescripcionMovimiento(entidad.getDescripcionMovimiento());
        dto.setIdEmpresa(entidad.getEmpresaId());
        return dto;
    }
}
