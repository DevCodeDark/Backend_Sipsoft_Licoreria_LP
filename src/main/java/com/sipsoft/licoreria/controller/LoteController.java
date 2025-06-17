package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipsoft.licoreria.entity.Lote;
import com.sipsoft.licoreria.dto.LoteDTO;
import com.sipsoft.licoreria.entity.Producto;
import com.sipsoft.licoreria.entity.Almacen;
import com.sipsoft.licoreria.repository.ProductoRepository;
import com.sipsoft.licoreria.repository.AlmacenesRepository;
import com.sipsoft.licoreria.services.ILoteService;

@RestController
@RequestMapping("/sipsoft")
public class LoteController {
    @Autowired
    private ILoteService serviceLote;

    @Autowired
    private ProductoRepository repoProducto;

    @Autowired
    private AlmacenesRepository repoAlmacen;

    @GetMapping("/lotes")
    public List<Lote> buscarTodos() {
        return serviceLote.bucarTodos();
    }

    @PostMapping("/lotes")
    public Lote guardar(@RequestBody LoteDTO dto) {
        Lote lote = new Lote();
        lote.setCodLote(dto.getCodLote());
        lote.setFechaEntradaLote(dto.getFechaEntradaLote());
        lote.setFechaVencimientoLote(dto.getFechaVencimientoLote());
        lote.setStockInicial(dto.getStockInicial());
        lote.setStockActual(dto.getStockActual());
        lote.setFlagLote(dto.getFlagLote());
        lote.setEstadoLote(dto.getEstadoLote());

        Producto producto = repoProducto.findById(dto.getIdProducto()).orElse(null);
        lote.setIdProducto(producto);

        Almacen almacen = repoAlmacen.findById(dto.getIdAlmacen()).orElse(null);
        lote.setIdAlmacen(almacen);

        serviceLote.guardar(lote);
        return lote;
    }

    @PutMapping("/lotes")
    public Lote modificar(@RequestBody LoteDTO dto) {
        Lote lote = new Lote();
        lote.setIdLote(dto.getIdLote());
        lote.setCodLote(dto.getCodLote());
        lote.setFechaEntradaLote(dto.getFechaEntradaLote());
        lote.setFechaVencimientoLote(dto.getFechaVencimientoLote());
        lote.setStockInicial(dto.getStockInicial());
        lote.setStockActual(dto.getStockActual());
        lote.setFlagLote(dto.getFlagLote());
        lote.setEstadoLote(dto.getEstadoLote());

        Producto producto = repoProducto.findById(dto.getIdProducto()).orElse(null);
        lote.setIdProducto(producto);

        Almacen almacen = repoAlmacen.findById(dto.getIdAlmacen()).orElse(null);
        lote.setIdAlmacen(almacen);

        serviceLote.modificar(lote);
        return lote;
    }

    @GetMapping("/lotes/{idLote}")
    public Optional<Lote> buscarId(@PathVariable("idLote") Integer idLote) {
        return serviceLote.buscarId(idLote);
    }

    @DeleteMapping("/lotes/{idLote}")
    public String eliminar(@PathVariable Integer idLote){
        serviceLote.eliminar(idLote);
        return "Lote eliminado";
    }
}
