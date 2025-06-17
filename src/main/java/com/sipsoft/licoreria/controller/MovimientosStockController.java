package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public List<MovimientosStock> buscarTodos() {
        return serviceMovimientosStock.bucarTodos();
    }
    @PostMapping("/movimientos-stock")
    public ResponseEntity <?> guardar(@RequestBody MovimientoStockDTO dto) {
       MovimientosStock movimientosStock = new MovimientosStock();
       movimientosStock.setCantidadMovimientoStock(dto.getCantidadMovimientoStock());
       movimientosStock.setFechaMovimientoStock(dto.getFechaMovimientoStock());

        TipoMovimientosStock tipoMovimientosStock = repoTipoMovimientosStock.findById(dto.getIdTipoMovimiento()).orElse(null);
        Lote lote = repoLote.findById(dto.getIdLote()).orElse(null);

        movimientosStock.setIdTipoMovimiento(tipoMovimientosStock); 
        movimientosStock.setIdLote(lote);        

        return ResponseEntity.ok(serviceMovimientosStock.guardar(movimientosStock));
    }

    @PutMapping("/movimientos-stock")
    public ResponseEntity <?> modificar(@RequestBody MovimientoStockDTO dto) {
        if (dto.getIdMovimientoStock() == null) {
            return ResponseEntity.badRequest().body("ID no existe");            
        }
        MovimientosStock movimientosStock = new MovimientosStock();
        movimientosStock.setIdMovimientoStock(dto.getIdMovimientoStock());
        movimientosStock.setCantidadMovimientoStock(dto.getCantidadMovimientoStock());
        movimientosStock.setFechaMovimientoStock(dto.getFechaMovimientoStock());

        movimientosStock.setIdTipoMovimiento(new TipoMovimientosStock(dto.getIdTipoMovimiento()));
        movimientosStock.setIdLote(new Lote(dto.getIdLote()));        

        return ResponseEntity.ok(serviceMovimientosStock.modificar(movimientosStock));
    }

    @GetMapping("/movimientos-stock/{idMovimientoStock}")
    public Optional<MovimientosStock> buscarId(@PathVariable("idMovimientoStock") Integer idMovimientoStock) {
        return serviceMovimientosStock.buscarId(idMovimientoStock);
    }

    @DeleteMapping("/movimientos-stock/{idMovimientoStock}")
    public String eliminar(@PathVariable Integer idMovimientoStock){
        serviceMovimientosStock.eliminar(idMovimientoStock);
        return "Movimiento Stock eliminado";
    }
}
