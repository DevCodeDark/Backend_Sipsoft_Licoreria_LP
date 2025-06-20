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

import com.sipsoft.licoreria.dto.TipoNotificacionesDTO;
import com.sipsoft.licoreria.entity.TipoNotificaciones;
import com.sipsoft.licoreria.services.ITipoNotificacionesService;

@RestController
@RequestMapping("/sipsoft")
public class TipoNotificacionesController {
    @Autowired
    private ITipoNotificacionesService serviceTipoNotificaciones;


    @GetMapping("/tipos-notificaciones")
    @Transactional(readOnly = true)
    public List<TipoNotificaciones> buscarTodos() {
        return serviceTipoNotificaciones.buscarTodos();
    }    @PostMapping("/tipos-notificaciones")
    @Transactional
    public ResponseEntity <?> guardar(@RequestBody TipoNotificacionesDTO dto) {
        TipoNotificaciones tiponoti = new TipoNotificaciones();
        tiponoti.setDescripcionNotificacion(dto.getDescripcionNotificacion());
        tiponoti.setEstadoTipoNotificacion(dto.getEstadoTipoNotificacion() != null ? dto.getEstadoTipoNotificacion() : 1);

        return ResponseEntity.ok(serviceTipoNotificaciones.guardar(tiponoti));
    }    @PutMapping("/tipos-notificaciones")
    @Transactional
    public ResponseEntity <?> modificar(@RequestBody TipoNotificacionesDTO dto) {
        if (dto.getIdTipoNotificacion() == null) {
            return ResponseEntity.badRequest().body("ID no existe");            
        }
        TipoNotificaciones tiponoti = new TipoNotificaciones();
        tiponoti.setIdTipoNotificacion(dto.getIdTipoNotificacion());
        tiponoti.setDescripcionNotificacion(dto.getDescripcionNotificacion());
        tiponoti.setEstadoTipoNotificacion(dto.getEstadoTipoNotificacion() != null ? dto.getEstadoTipoNotificacion() : 1);

        return ResponseEntity.ok(serviceTipoNotificaciones.modificar(tiponoti));
    }    @GetMapping("/tipos-notificaciones/{idTipoNotificacion}")
    @Transactional(readOnly = true)
    public Optional<TipoNotificaciones> buscarId(@PathVariable("idTipoNotificacion") Integer idTipoNotificacion) {
        return serviceTipoNotificaciones.buscarId(idTipoNotificacion);
    }    @DeleteMapping("/tipos-notificaciones/{idTipoNotificacion}")
    @Transactional
    public String eliminar(@PathVariable Integer idTipoNotificacion){
        serviceTipoNotificaciones.eliminar(idTipoNotificacion);
        return "Tipo Notificacion eliminado";
    }
}
