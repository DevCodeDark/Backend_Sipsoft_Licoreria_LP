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

import com.sipsoft.licoreria.dto.NotificacionesDTO;
import com.sipsoft.licoreria.entity.ContratoProveedor;
import com.sipsoft.licoreria.entity.Notificaciones;
import com.sipsoft.licoreria.entity.Producto;
import com.sipsoft.licoreria.entity.TipoNotificaciones;
import com.sipsoft.licoreria.repository.ContratoProveedorRepository;
import com.sipsoft.licoreria.repository.ProductoRepository;
import com.sipsoft.licoreria.repository.TipoNotificacionesRepository;
import com.sipsoft.licoreria.services.INotificacionesService;

@RestController
@RequestMapping("/sipsoft")
public class NotificacionesController {
    @Autowired
    private INotificacionesService serviceNotificaciones;

    @Autowired
    private ProductoRepository repoProducto; // AQUI

    @Autowired
    private TipoNotificacionesRepository repoTipoNoti; // AQUI

    @Autowired
    private ContratoProveedorRepository repoContratoProv; // AQUI

    @GetMapping("/notificaciones")
    @Transactional(readOnly = true)
    public List<Notificaciones> buscarTodos() {
        return serviceNotificaciones.bucarTodos();
    }

    @PostMapping("/notificaciones")
    @Transactional
    public ResponseEntity<?> guardar(@RequestBody NotificacionesDTO dto) {
        Notificaciones notificacion = new Notificaciones();
        notificacion.setFechaNotificacion(dto.getFechaNotificacion());
        notificacion.setMensaje(dto.getMensaje());

        Producto producto = repoProducto.findById(dto.getIdProducto()).orElse(null);
        notificacion.setIdProducto(producto);

        TipoNotificaciones tiponotificaciones = repoTipoNoti.findById(dto.getIdTipoNotificacion()).orElse(null);
        notificacion.setIdTipoNotificacion(tiponotificaciones);

        ContratoProveedor contratoproveedor = repoContratoProv.findById(dto.getIdContratoProveedor()).orElse(null);
        notificacion.setIdContratoProveedor(contratoproveedor);

        return ResponseEntity.ok(serviceNotificaciones.guardar(notificacion));
    }

    @PutMapping("/notificaciones")
    @Transactional
    public ResponseEntity<?> modificar(@RequestBody NotificacionesDTO dto) {
        if (dto.getIdNotificacion() == null) {
            return ResponseEntity.badRequest().body("ID no existe");
        }

        Notificaciones notificaciones = new Notificaciones();
        notificaciones.setFechaNotificacion(dto.getFechaNotificacion());
        notificaciones.setIdNotificacion(dto.getIdNotificacion());
        notificaciones.setMensaje(dto.getMensaje());

        Producto producto = repoProducto.findById(dto.getIdProducto()).orElse(null);
        notificaciones.setIdProducto(producto);

        TipoNotificaciones tiponotificaciones = repoTipoNoti.findById(dto.getIdTipoNotificacion()).orElse(null);
        notificaciones.setIdTipoNotificacion(tiponotificaciones);

        ContratoProveedor contratoproveedor = repoContratoProv.findById(dto.getIdContratoProveedor()).orElse(null);
        notificaciones.setIdContratoProveedor(contratoproveedor);

        return ResponseEntity.ok(serviceNotificaciones.modificar(notificaciones));

    }

    @GetMapping("/notificaciones/{idNotificacion}")
    @Transactional(readOnly = true)
    public Optional<Notificaciones> buscarId(@PathVariable("idNotificacion") Integer idNotificacion) {
        return serviceNotificaciones.buscarId(idNotificacion);
    }

    @DeleteMapping("/notificaciones/{idNotificacion}")
    @Transactional
    public String eliminar(@PathVariable Integer idNotificacion) {
        serviceNotificaciones.eliminar(idNotificacion);
        return "Notificacion eliminada";
    }
}
