package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipsoft.licoreria.entity.TipoComprobante;
import com.sipsoft.licoreria.services.ITipoComprobanteService;

@RestController
@RequestMapping("/sipsoft")
public class TipoComprobanteController {
    @Autowired
    private ITipoComprobanteService serviceTipoComprobante;

    @GetMapping("/tipos-comprobante")
    @Transactional(readOnly = true)
    public List<TipoComprobante> buscarTodos() {
        return serviceTipoComprobante.buscarTodos();
    }    @PostMapping("/tipos-comprobante")
    @Transactional
    public TipoComprobante guardar(@RequestBody TipoComprobante tipoComprobante) {
        serviceTipoComprobante.guardar(tipoComprobante);
        return tipoComprobante;
    }    @PutMapping("/tipos-comprobante")
    @Transactional
    public TipoComprobante modificar(@RequestBody TipoComprobante tipoComprobante) {
        serviceTipoComprobante.modificar(tipoComprobante);
        return tipoComprobante;
    }    @GetMapping("/tipos-comprobante/{idTipoComprobante}")
    @Transactional(readOnly = true)
    public Optional<TipoComprobante> buscarId(@PathVariable("idTipoComprobante") Integer idTipoComprobante) {
        return serviceTipoComprobante.buscarId(idTipoComprobante);
    }    @DeleteMapping("/tipos-comprobante/{idTipoComprobante}")
    @Transactional
    public String eliminar(@PathVariable Integer idTipoComprobante){
        serviceTipoComprobante.eliminar(idTipoComprobante);
        return "Tipo Comprobante eliminado";
    }
}
