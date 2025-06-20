package com.sipsoft.licoreria.controller;

import java.util.List;

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

import com.sipsoft.licoreria.dto.NotificacionesDTO;
import com.sipsoft.licoreria.entity.Notificaciones;
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
    private ProductoRepository repoProducto;

    @Autowired
    private TipoNotificacionesRepository repoTipoNoti;

    @Autowired
    private ContratoProveedorRepository repoContratoProv;

    @GetMapping("/notificaciones")
    @Transactional(readOnly = true)
    public ResponseEntity<List<NotificacionesDTO>> buscarTodos() {
        try {
            List<Notificaciones> notificaciones = serviceNotificaciones.bucarTodos();
            List<NotificacionesDTO> notificacionesDTO = notificaciones.stream()
                    .map(this::convertirEntidadADTO)
                    .toList();
            return ResponseEntity.ok(notificacionesDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/notificaciones")
    @Transactional
    public ResponseEntity<NotificacionesDTO> guardar(@RequestBody NotificacionesDTO dto) {
        try {
            Notificaciones notificacion = convertirDTOAEntidad(dto);
            Notificaciones notificacionGuardada = serviceNotificaciones.guardar(notificacion);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(convertirEntidadADTO(notificacionGuardada));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/notificaciones")
    @Transactional
    public ResponseEntity<NotificacionesDTO> modificar(@RequestBody NotificacionesDTO dto) {
        try {
            if (dto.getIdNotificacion() == null) {
                return ResponseEntity.badRequest().build();
            }

            Notificaciones notificacion = convertirDTOAEntidad(dto);
            Notificaciones notificacionModificada = serviceNotificaciones.modificar(notificacion);
            return ResponseEntity.ok(convertirEntidadADTO(notificacionModificada));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/notificaciones/{idNotificacion}")
    @Transactional(readOnly = true)
    public ResponseEntity<NotificacionesDTO> buscarId(@PathVariable("idNotificacion") Integer idNotificacion) {
        try {
            return serviceNotificaciones.buscarId(idNotificacion)
                    .map(notificacion -> ResponseEntity.ok(convertirEntidadADTO(notificacion)))
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/notificaciones/{idNotificacion}")
    @Transactional
    public ResponseEntity<String> eliminar(@PathVariable Integer idNotificacion) {
        try {
            serviceNotificaciones.eliminar(idNotificacion);
            return ResponseEntity.ok("Notificacion eliminada");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar la notificación");
        }
    }

    // Métodos de conversión entre entidad y DTO
    private NotificacionesDTO convertirEntidadADTO(Notificaciones notificacion) {
        NotificacionesDTO dto = new NotificacionesDTO();
        dto.setIdNotificacion(notificacion.getIdNotificacion());
        dto.setFechaNotificacion(notificacion.getFechaNotificacion());
        dto.setMensaje(notificacion.getMensaje());
        dto.setEstadoNotificacion(notificacion.getEstadoNotificacion());
        dto.setIdProducto(notificacion.getProductoId());
        dto.setIdContratoProveedor(notificacion.getContratoProveedorId());
        dto.setIdTipoNotificacion(notificacion.getTipoNotificacionId());
        return dto;
    }

    private Notificaciones convertirDTOAEntidad(NotificacionesDTO dto) {
        Notificaciones notificacion = new Notificaciones();
        notificacion.setIdNotificacion(dto.getIdNotificacion());
        notificacion.setFechaNotificacion(dto.getFechaNotificacion());
        notificacion.setMensaje(dto.getMensaje());
        notificacion.setEstadoNotificacion(dto.getEstadoNotificacion() != null ? dto.getEstadoNotificacion() : 1);

        // Cargar las relaciones si los IDs están presentes
        if (dto.getIdProducto() != null) {
            notificacion.setIdProducto(repoProducto.findById(dto.getIdProducto()).orElse(null));
        }
        if (dto.getIdContratoProveedor() != null) {
            notificacion.setIdContratoProveedor(repoContratoProv.findById(dto.getIdContratoProveedor()).orElse(null));
        }
        if (dto.getIdTipoNotificacion() != null) {
            notificacion.setIdTipoNotificacion(repoTipoNoti.findById(dto.getIdTipoNotificacion()).orElse(null));
        }

        return notificacion;
    }
}
