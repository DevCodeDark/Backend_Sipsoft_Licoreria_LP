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

import com.sipsoft.licoreria.dto.DetalleTrasladoDTO;
import com.sipsoft.licoreria.entity.DetalleTraslado;
import com.sipsoft.licoreria.entity.Lote;
import com.sipsoft.licoreria.entity.Traslado;
import com.sipsoft.licoreria.repository.LoteRepository;
import com.sipsoft.licoreria.repository.TrasladoRepository;
import com.sipsoft.licoreria.services.IDetalleTrasladoService;

@RestController
@RequestMapping("/sipsoft")
public class DetalleTrasladoController {
    @Autowired
    private IDetalleTrasladoService serviceDetalleTraslado;

    @Autowired
    private TrasladoRepository repoTraslado;

    @Autowired
    private LoteRepository repoLote;

    @GetMapping("/detalle-traslado")
    public List<DetalleTraslado> buscarTodos() {
        return serviceDetalleTraslado.bucarTodos();
    }
    @PostMapping("/detalle-traslado")
    public ResponseEntity <?> guardar(@RequestBody DetalleTrasladoDTO dto) {
       DetalleTraslado detalleTraslado = new DetalleTraslado();
       detalleTraslado.setCantidadTraslado(dto.getCantidadTraslado());



        Traslado translado = repoTraslado.findById(dto.getIdTraslado()).orElse(null);
        Lote lote = repoLote.findById(dto.getIdLote()).orElse(null);

        detalleTraslado.setIdTraslado(translado); 
        detalleTraslado.setIdLote(lote);        

        return ResponseEntity.ok(serviceDetalleTraslado.guardar(detalleTraslado));
    }

    @PutMapping("/detalle-traslado")
    public ResponseEntity <?> modificar(@RequestBody DetalleTrasladoDTO dto) {
        if (dto.getIdDetalleTraslado() == null) {
            return ResponseEntity.badRequest().body("ID no existe");            
        }
        DetalleTraslado detalleTraslado = new DetalleTraslado();
        detalleTraslado.setIdDetalleTraslado(dto.getIdDetalleTraslado());
        detalleTraslado.setCantidadTraslado(dto.getCantidadTraslado());

        Traslado translado = repoTraslado.findById(dto.getIdTraslado()).orElse(null);
        Lote lote = repoLote.findById(dto.getIdLote()).orElse(null);
        detalleTraslado.setIdTraslado(translado);
        detalleTraslado.setIdLote(lote);

        return ResponseEntity.ok(serviceDetalleTraslado.modificar(detalleTraslado));
    }

    @GetMapping("/detalle-traslado/{idDetalleTraslado}")
    public Optional<DetalleTraslado> buscarId(@PathVariable("idDetalleTraslado") Integer idDetalleTraslado) {
        return serviceDetalleTraslado.buscarId(idDetalleTraslado);
    }

    @DeleteMapping("/detalle-traslado/{idDetalleTraslado}")
    public String eliminar(@PathVariable Integer idDetalleTraslado){
        serviceDetalleTraslado.eliminar(idDetalleTraslado);
        return "Detalle Traslado eliminado";
    }
}
