package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sipsoft.licoreria.dto.MultiPagoDTO;
import com.sipsoft.licoreria.entity.MultiPago;
import com.sipsoft.licoreria.services.IMultiPagoService;

@RestController
@RequestMapping("/sipsoft")
public class MultiPagoController {
    @Autowired
    private IMultiPagoService serviceMultiPago;

    @GetMapping("/multi-pago")
    public List<MultiPagoDTO> buscarTodos() {
        return serviceMultiPago.bucarTodos().stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
    }

    @GetMapping("/multi-pago/{idMultiPago}")
    public ResponseEntity<MultiPagoDTO> buscarId(@PathVariable("idMultiPago") Integer idMultiPago) {
        return serviceMultiPago.buscarId(idMultiPago)
            .map(pago -> ResponseEntity.ok(convertToDto(pago)))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/multi-pago")
    public MultiPagoDTO guardar(@RequestBody MultiPagoDTO dto) {
        MultiPago pago = new MultiPago();
        pago.setMontoPagado(dto.getMontoPagado());
        pago.setIdVenta(dto.getIdVenta());
        pago.setIdTipoPago(dto.getIdTipoPago());
        
        MultiPago savedPago = serviceMultiPago.guardar(pago);
        return convertToDto(savedPago);
    }

    @PutMapping("/multi-pago")
    public ResponseEntity<MultiPagoDTO> modificar(@RequestBody MultiPagoDTO dto) {
        if (dto.getIdMultiPago() == null) {
            return ResponseEntity.badRequest().build();
        }

        return serviceMultiPago.buscarId(dto.getIdMultiPago())
            .map(pagoExistente -> {
                pagoExistente.setMontoPagado(dto.getMontoPagado());
                pagoExistente.setIdVenta(dto.getIdVenta());
                pagoExistente.setIdTipoPago(dto.getIdTipoPago());

                MultiPago updatedPago = serviceMultiPago.modificar(pagoExistente);
                return ResponseEntity.ok(convertToDto(updatedPago));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/multi-pago/{idMultiPago}")
    public String eliminar(@PathVariable Integer idMultiPago){
        serviceMultiPago.eliminar(idMultiPago);
        return "Multi Pago eliminado";
    }
    
    private MultiPagoDTO convertToDto(MultiPago entity) {
        MultiPagoDTO dto = new MultiPagoDTO();
        dto.setIdMultiPago(entity.getIdMultiPago());
        dto.setMontoPagado(entity.getMontoPagado());
        dto.setIdVenta(entity.getIdVenta());
        dto.setIdTipoPago(entity.getIdTipoPago());
        return dto;
    }
}