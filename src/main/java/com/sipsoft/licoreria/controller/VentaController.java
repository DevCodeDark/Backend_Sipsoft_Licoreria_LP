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

import com.sipsoft.licoreria.entity.Venta;
import com.sipsoft.licoreria.dto.VentaDTO;
import com.sipsoft.licoreria.services.IVentaService;

@RestController
@RequestMapping("/sipsoft")
public class VentaController {
    @Autowired
    private IVentaService serviceVenta;
    @GetMapping("/ventas")
    public List<Venta> buscarTodos() {
        return serviceVenta.buscarTodos();
    }    @PostMapping("/ventas")
    public Venta guardar(@RequestBody VentaDTO dto) {
        Venta venta = new Venta();
        venta.setIdCliente(dto.getIdCliente());
        venta.setIdCaja(dto.getIdCaja());
        venta.setIgv(dto.getIgv());
        venta.setFechaVenta(dto.getFechaVenta());
        venta.setMontoTotalVenta(dto.getMontoTotalVenta());
        venta.setFechaAnulacion(dto.getFechaAnulacion());
        venta.setDireccion(dto.getDireccion());
        venta.setReferencia(dto.getReferencia());
        venta.setEstadoVenta(dto.getEstadoVenta());
        venta.setIdUsuario(dto.getIdUsuario());
        venta.setTipoDocumento(dto.getTipoDocumento());

        serviceVenta.guardar(venta);

        // Ya no se guarda detalle ni se actualiza stock aquí
        return venta;
    }    @PutMapping("/ventas")
    public Venta modificar(@RequestBody VentaDTO dto) {
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
        venta.setEstadoVenta(dto.getEstadoVenta());
        venta.setIdUsuario(dto.getIdUsuario());
        venta.setTipoDocumento(dto.getTipoDocumento());

        serviceVenta.modificar(venta);

        return venta;
    }

    @GetMapping("/ventas/{idVenta}")
    public Optional<Venta> buscarId(@PathVariable("idVenta") Integer idVenta) {
        return serviceVenta.buscarId(idVenta);
    }

    @DeleteMapping("/ventas/{idVenta}")
    public String eliminar(@PathVariable Integer idVenta){
        serviceVenta.eliminar(idVenta);
        return "Venta eliminada";
    }
}
