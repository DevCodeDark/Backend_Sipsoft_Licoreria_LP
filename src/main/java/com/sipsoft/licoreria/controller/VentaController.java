package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.Optional;

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

import com.sipsoft.licoreria.entity.Venta;
import com.sipsoft.licoreria.dto.VentaDTO;
import com.sipsoft.licoreria.services.IVentaService;

@RestController
@RequestMapping("/sipsoft")
public class VentaController {
    @Autowired
    private IVentaService serviceVenta;

    @GetMapping("/ventas")
    @Transactional(readOnly = true)
    public ResponseEntity<List<VentaDTO>> buscarTodos() {
        try {
            List<Venta> ventas = serviceVenta.buscarTodos();
            List<VentaDTO> ventasDTO = ventas.stream()
                    .map(this::convertirEntidadADTO)
                    .toList();
            return ResponseEntity.ok(ventasDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/ventas")
    @Transactional
    public ResponseEntity<VentaDTO> guardar(@RequestBody VentaDTO dto) {
        try {
            Venta venta = new Venta();
            venta.setIdCliente(dto.getIdCliente());
            venta.setIdCaja(dto.getIdCaja());
            venta.setIgv(dto.getIgv());
            venta.setFechaVenta(dto.getFechaVenta());
            venta.setMontoTotalVenta(dto.getMontoTotalVenta());
            venta.setFechaAnulacion(dto.getFechaAnulacion());
            venta.setDireccion(dto.getDireccion());
            venta.setReferencia(dto.getReferencia());
            venta.setIdUsuario(dto.getIdUsuario());
            venta.setTipoDocumento(dto.getTipoDocumento());

            Venta ventaGuardada = serviceVenta.guardar(venta);

            // Forzar la actualización de la dirección
            ventaGuardada.setDireccion(dto.getDireccion());
            Venta ventaModificada = serviceVenta.modificar(ventaGuardada);

            VentaDTO resultDto = convertirEntidadADTO(ventaModificada);

            return ResponseEntity.status(HttpStatus.CREATED).body(resultDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/ventas")
    @Transactional
    public ResponseEntity<VentaDTO> modificar(@RequestBody VentaDTO dto) {
        try {
            if (dto.getIdVenta() == null) {
                return ResponseEntity.badRequest().build();
            }

            Venta venta = new Venta();
            venta.setIdVenta(dto.getIdVenta());
            venta.setIdCliente(dto.getIdCliente());
            venta.setIdCaja(dto.getIdCaja());
            venta.setIgv(dto.getIgv());
            venta.setFechaVenta(dto.getFechaVenta());
            venta.setMontoTotalVenta(dto.getMontoTotalVenta());
            venta.setFechaAnulacion(dto.getFechaAnulacion());
            venta.setDireccion(dto.getDireccion());
            venta.setReferencia(dto.getReferencia());
            venta.setIdUsuario(dto.getIdUsuario());
            venta.setTipoDocumento(dto.getTipoDocumento());

            Venta ventaModificada = serviceVenta.modificar(venta);
            VentaDTO resultDto = convertirEntidadADTO(ventaModificada);
            return ResponseEntity.ok(resultDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/ventas/{idVenta}")
    @Transactional(readOnly = true)
    public ResponseEntity<VentaDTO> buscarId(@PathVariable("idVenta") Integer idVenta) {
        try {
            Optional<Venta> venta = serviceVenta.buscarId(idVenta);
            if (venta.isPresent()) {
                VentaDTO dto = convertirEntidadADTO(venta.get());
                return ResponseEntity.ok(dto);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/ventas/{idVenta}")
    @Transactional
    public String eliminar(@PathVariable Integer idVenta) {
        serviceVenta.eliminar(idVenta);
        return "Venta eliminada";
    } // Métodos de conversión

    private VentaDTO convertirEntidadADTO(Venta entidad) {
        VentaDTO dto = new VentaDTO();
        dto.setIdVenta(entidad.getIdVenta());
        dto.setFechaVenta(entidad.getFechaVenta());
        dto.setMontoTotalVenta(entidad.getMontoTotalVenta());        dto.setFechaAnulacion(entidad.getFechaAnulacion());
        dto.setDireccion(entidad.getDireccion());
        dto.setReferencia(entidad.getReferencia());
        dto.setEstadoVenta(entidad.getEstadoVenta());
        dto.setIgv(entidad.getIgv());
        dto.setTipoDocumento(entidad.getTipoDocumento());
        dto.setIdCliente(entidad.getIdCliente());
        dto.setIdCaja(entidad.getIdCaja());
        dto.setIdUsuario(entidad.getIdUsuario());
        return dto;
    }
}
