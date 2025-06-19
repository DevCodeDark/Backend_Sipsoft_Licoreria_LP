package com.sipsoft.licoreria.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.sipsoft.licoreria.dto.MovimientoStockDTO;
import com.sipsoft.licoreria.entity.Lote;
import com.sipsoft.licoreria.entity.MovimientosStock;
import com.sipsoft.licoreria.entity.TipoMovimientosStock;
import com.sipsoft.licoreria.repository.LoteRepository;
import com.sipsoft.licoreria.repository.TipoMovimientosStockRepository;
import com.sipsoft.licoreria.services.IMovimientosStockService;

@RestController
@RequestMapping("/sipsoft")
public class MovimientosStockController {
    @Autowired
    private IMovimientosStockService serviceMovimientosStock;

    @Autowired
    private LoteRepository repoLote;

    @Autowired
    private TipoMovimientosStockRepository repoTipoMovimientosStock;

    @GetMapping("/movimientos-stock")
    @Transactional(readOnly = true)
    public List<MovimientoStockDTO> buscarTodos() {
        return serviceMovimientosStock.bucarTodos().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/movimientos-stock/{idMovimientoStock}")
    @Transactional(readOnly = true)
    public ResponseEntity<MovimientoStockDTO> buscarId(@PathVariable("idMovimientoStock") Integer idMovimientoStock) {
        return serviceMovimientosStock.buscarId(idMovimientoStock)
                .map(movimiento -> ResponseEntity.ok(convertToDto(movimiento)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/movimientos-stock")
    @Transactional
    public MovimientoStockDTO guardar(@RequestBody MovimientoStockDTO dto) {
        MovimientosStock movimientosStock = new MovimientosStock();
        mapDtoToEntity(dto, movimientosStock);
        
        // Asignar fecha automáticamente si no se proporciona
        if (dto.getFechaMovimientoStock() == null) {
            movimientosStock.setFechaMovimientoStock(LocalDateTime.now());
        }

        MovimientosStock savedMovimiento = serviceMovimientosStock.guardar(movimientosStock);
        return convertToDto(savedMovimiento);
    }

    @PutMapping("/movimientos-stock")
    @Transactional
    public ResponseEntity<MovimientoStockDTO> modificar(@RequestBody MovimientoStockDTO dto) {
        if (dto.getIdMovimientoStock() == null) {
            return ResponseEntity.badRequest().build();
        }

        return serviceMovimientosStock.buscarId(dto.getIdMovimientoStock())
                .map(movimientoExistente -> {
                    mapDtoToEntity(dto, movimientoExistente);
                    MovimientosStock updatedMovimiento = serviceMovimientosStock.modificar(movimientoExistente);
                    return ResponseEntity.ok(convertToDto(updatedMovimiento));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/movimientos-stock/{idMovimientoStock}")
    @Transactional
    public String eliminar(@PathVariable Integer idMovimientoStock) {
        serviceMovimientosStock.eliminar(idMovimientoStock);
        return "Movimiento Stock eliminado";
    }

    // --- Métodos de Ayuda ---

    private MovimientoStockDTO convertToDto(MovimientosStock entity) {
        MovimientoStockDTO dto = new MovimientoStockDTO();
        dto.setIdMovimientoStock(entity.getIdMovimientoStock());
        dto.setCantidadMovimientoStock(entity.getCantidadMovimientoStock());
        dto.setFechaMovimientoStock(entity.getFechaMovimientoStock());
        dto.setIdLote(entity.getIdLote());
        dto.setIdTipoMovimiento(entity.getIdTipoMovimiento());
        return dto;
    }

    private void mapDtoToEntity(MovimientoStockDTO dto, MovimientosStock entity) {
        entity.setCantidadMovimientoStock(dto.getCantidadMovimientoStock());
        entity.setFechaMovimientoStock(dto.getFechaMovimientoStock());
        entity.setIdLote(dto.getIdLote());
        entity.setIdTipoMovimiento(dto.getIdTipoMovimiento());

        // Establecer relaciones por ID
        if (dto.getIdLote() != null) {
            Lote lote = repoLote.findById(dto.getIdLote()).orElse(null);
            entity.setLote(lote);
        }
        if (dto.getIdTipoMovimiento() != null) {
            TipoMovimientosStock tipoMovimiento = repoTipoMovimientosStock.findById(dto.getIdTipoMovimiento()).orElse(null);
            entity.setTipoMovimiento(tipoMovimiento);
        }
    }
}
