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
    public List<TipoMovimientosStock> buscarTodos() {
        return serviceTipoMovimientosStock.bucarTodos();
    }
    @PostMapping("/tipos-movimientos-stock")
    public  ResponseEntity <?>  guardar(@RequestBody TipoMovimientosStockDTO dto) {
        TipoMovimientosStock tipomovimientostock = new TipoMovimientosStock();
        tipomovimientostock.setDescripcionMovimiento(dto.getDescripcionMovimiento());
        
        Empresa empresa = repoEmpresa.findById(dto.getIdEmpresa()).orElse(null);
        
        tipomovimientostock.setIdEmpresa(empresa);

        return ResponseEntity.ok(serviceTipoMovimientosStock.guardar(tipomovimientostock));
    }

    @PutMapping("/tipos-movimientos-stock")
    public ResponseEntity <?> modificar(@RequestBody TipoMovimientosStockDTO dto) {
        if (dto.getIdTipoMovimiento() == null) {
            return ResponseEntity.badRequest().body("ID no existe");            
        }
        TipoMovimientosStock tipomovimientostock = new TipoMovimientosStock();
        tipomovimientostock.setIdTipoMovimiento(dto.getIdTipoMovimiento());
        tipomovimientostock.setDescripcionMovimiento(dto.getDescripcionMovimiento());
        
        tipomovimientostock.setIdEmpresa(new Empresa(dto.getIdEmpresa()));    

        return ResponseEntity.ok(serviceTipoMovimientosStock.modificar(tipomovimientostock));
    }

    @GetMapping("/tipos-movimientos-stock/{idTipoMovimiento}")
    public Optional<TipoMovimientosStock> buscarId(@PathVariable("idTipoMovimiento") Integer idTipoMovimiento) {
        return serviceTipoMovimientosStock.buscarId(idTipoMovimiento);
    }

    @DeleteMapping("/tipos-movimientos-stock/{idTipoMovimiento}")
    public String eliminar(@PathVariable Integer idTipoMovimiento){
        serviceTipoMovimientosStock.eliminar(idTipoMovimiento);
        return "Tipo Movimiento Stock eliminado";
    }
}
