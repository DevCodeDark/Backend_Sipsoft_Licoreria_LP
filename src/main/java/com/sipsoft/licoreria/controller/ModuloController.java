package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.Optional;

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

import com.sipsoft.licoreria.dto.ModuloDTO;
import com.sipsoft.licoreria.entity.Modulo;
import com.sipsoft.licoreria.services.IModuloService;

@RestController
@RequestMapping("/sipsoft")
public class ModuloController {
    @Autowired
    private IModuloService serviceModulo;

    @GetMapping("/modulos")
    @Transactional(readOnly = true)
    public List<Modulo> buscarTodos() {
        return serviceModulo.bucarTodos();
    }

    @PostMapping("/modulos")
    @Transactional
    public Modulo guardar(@RequestBody ModuloDTO moduloDto) {
        Modulo modulo = new Modulo();
        modulo.setIdSegmento(moduloDto.getIdSegmento());
        modulo.setUrlModulo(moduloDto.getUrlModulo());
        modulo.setNombreModulo(moduloDto.getNombreModulo());
        modulo.setEstadoModulo(1);

        return serviceModulo.guardar(modulo);
    }

    @PutMapping("/modulos")
    @Transactional
    public ResponseEntity<?> modificar(@RequestBody ModuloDTO moduloDto) {
        if (moduloDto.getIdModulo() == null) {
            return ResponseEntity.badRequest().body("El idModulo es requerido para modificar.");
        }

        Optional<Modulo> moduloOpt = serviceModulo.buscarId(moduloDto.getIdModulo());
        if (moduloOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("No se encontró el Módulo con ID: " + moduloDto.getIdModulo());
        }

        Modulo moduloExistente = moduloOpt.get();
        moduloExistente.setIdSegmento(moduloDto.getIdSegmento());
        moduloExistente.setUrlModulo(moduloDto.getUrlModulo());
        moduloExistente.setNombreModulo(moduloDto.getNombreModulo());

        Modulo moduloModificado = serviceModulo.modificar(moduloExistente);
        return ResponseEntity.ok(moduloModificado);
    }

    @GetMapping("/modulos/{idModulo}")
    @Transactional(readOnly = true)
    public Optional<Modulo> buscarId(@PathVariable("idModulo") Integer idModulo) {
        return serviceModulo.buscarId(idModulo);
    }

    @DeleteMapping("/modulos/{idModulo}")
    @Transactional
    public String eliminar(@PathVariable Integer idModulo) {
        serviceModulo.eliminar(idModulo);
        return "Modulo eliminado";
    }
}