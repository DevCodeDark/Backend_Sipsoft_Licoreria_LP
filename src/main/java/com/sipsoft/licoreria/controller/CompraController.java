package com.sipsoft.licoreria.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sipsoft.licoreria.dto.CompraDTO;
import com.sipsoft.licoreria.entity.Compra;
import com.sipsoft.licoreria.services.ICompraService;

@RestController
@RequestMapping("/sipsoft")
public class CompraController {
    @Autowired
    private ICompraService serviceCompra;

    @GetMapping("/compras")
    public List<CompraDTO> buscarTodos() {
        return serviceCompra.bucarTodos().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/compras/{idCompra}")
    public ResponseEntity<CompraDTO> buscarId(@PathVariable("idCompra") Integer idCompra) {
        return serviceCompra.buscarId(idCompra)
                .map(compra -> ResponseEntity.ok(convertToDto(compra)))
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/compras")
    public CompraDTO guardar(@RequestBody CompraDTO compraDto) {
        Compra compra = new Compra();
        
        mapDtoToEntityForCreate(compraDto, compra);
        
        // Establecer valores automáticos en la creación
        LocalDateTime now = LocalDateTime.now();
        compra.setFechaCompra(now.toLocalDate());
        compra.setFechaRegistro(now);
        compra.setFechaActualizacion(now);
        compra.setEstadoCompra(1);

        Compra savedCompra = serviceCompra.guardar(compra);
        return convertToDto(savedCompra);
    }

    @PutMapping("/compras")
    public ResponseEntity<CompraDTO> modificar(@RequestBody CompraDTO compraDto) {
        if (compraDto.getIdCompra() == null) {
            return ResponseEntity.badRequest().build();
        }

        return serviceCompra.buscarId(compraDto.getIdCompra())
                .map(compraExistente -> {
                    mapDtoToEntityForUpdate(compraDto, compraExistente);
                    // Actualizar fecha de modificación
                    compraExistente.setFechaActualizacion(LocalDateTime.now());

                    if (compraDto.getEstadoCompra() != null) {
                        compraExistente.setEstadoCompra(compraDto.getEstadoCompra());
                    }

                    Compra updatedCompra = serviceCompra.modificar(compraExistente);
                    return ResponseEntity.ok(convertToDto(updatedCompra));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/compras/{idCompra}")
    public String eliminar(@PathVariable Integer idCompra){
        serviceCompra.eliminar(idCompra);
        return "Compra eliminada";
    }

    // --- Métodos de Ayuda ---

    private CompraDTO convertToDto(Compra compra) {
        CompraDTO dto = new CompraDTO();
        dto.setIdCompra(compra.getIdCompra());
        dto.setGuiaRemisionCompra(compra.getGuiaRemisionCompra());
        dto.setPrecioTotalCompra(compra.getPrecioTotalCompra());
        dto.setFechaCompra(compra.getFechaCompra());
        dto.setIgv(compra.getIgv());
        dto.setEstadoCompra(compra.getEstadoCompra());
        dto.setTipoCompra(compra.getTipoCompra());
        dto.setActivo(compra.getActivo());
        dto.setFechaActualizacion(compra.getFechaActualizacion());
        dto.setFechaRegistro(compra.getFechaRegistro());
        dto.setIdProveedor(compra.getIdProveedor());
        dto.setIdOrden(compra.getIdOrden());
        dto.setIdEmpresa(compra.getIdEmpresa());
        dto.setIdTipoPago(compra.getIdTipoPago());
        return dto;
    }

    private void mapDtoToEntityForCreate(CompraDTO dto, Compra entity) {
        entity.setGuiaRemisionCompra(dto.getGuiaRemisionCompra());
        entity.setPrecioTotalCompra(dto.getPrecioTotalCompra());
        entity.setIgv(dto.getIgv());
        // Se elimina la asignación de 'estadoCompra' desde el DTO
        entity.setTipoCompra(dto.getTipoCompra());
        entity.setActivo(dto.getActivo());
        entity.setIdProveedor(dto.getIdProveedor());
        entity.setIdOrden(dto.getIdOrden());
        entity.setIdEmpresa(dto.getIdEmpresa());
        entity.setIdTipoPago(dto.getIdTipoPago());
    }

    private void mapDtoToEntityForUpdate(CompraDTO dto, Compra entity) {
        entity.setGuiaRemisionCompra(dto.getGuiaRemisionCompra());
        entity.setPrecioTotalCompra(dto.getPrecioTotalCompra());
        entity.setIgv(dto.getIgv());
        entity.setTipoCompra(dto.getTipoCompra());
        entity.setActivo(dto.getActivo());
        entity.setIdProveedor(dto.getIdProveedor());
        entity.setIdOrden(dto.getIdOrden());
        entity.setIdEmpresa(dto.getIdEmpresa());
        entity.setIdTipoPago(dto.getIdTipoPago());
    }
}