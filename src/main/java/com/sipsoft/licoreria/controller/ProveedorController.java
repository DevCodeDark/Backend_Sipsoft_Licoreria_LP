package com.sipsoft.licoreria.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sipsoft.licoreria.dto.ProveedorDTO;
import com.sipsoft.licoreria.entity.Proveedor;
import com.sipsoft.licoreria.services.IProveedorService;

@RestController
@RequestMapping("/sipsoft")
public class ProveedorController {
    @Autowired
    private IProveedorService serviceProveedor;

    /**
     * GET /proveedores
     * @return Lista de todos los proveedores activos formateados como DTO.
     */
    @GetMapping("/proveedores")
    public List<ProveedorDTO> buscarTodos() {
        return serviceProveedor.bucarTodos().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    /**
     * GET /proveedores/{id}
     * @param idProveedor el ID del proveedor a buscar.
     * @return El proveedor encontrado como DTO, o 404 si no existe.
     */
    @GetMapping("/proveedores/{idProveedor}")
    public ResponseEntity<ProveedorDTO> buscarId(@PathVariable("idProveedor") Integer idProveedor) {
        return serviceProveedor.buscarId(idProveedor)
                .map(proveedor -> ResponseEntity.ok(convertToDto(proveedor)))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /proveedores
     * @param proveedorDto DTO con los datos del nuevo proveedor.
     * @return El DTO del proveedor creado con los campos automáticos (ID, fecha, estado).
     */
    @PostMapping("/proveedores")
    public ProveedorDTO guardar(@RequestBody ProveedorDTO proveedorDto) {
        Proveedor proveedor = new Proveedor();
        
        // Mapear datos del DTO a la entidad
        mapDtoToEntity(proveedorDto, proveedor);
        
        // Establecer valores automáticos para la creación
        proveedor.setFechaRegistroProveedor(LocalDate.now());
        proveedor.setEstadoProveedor(1); // 1 = Activo

        Proveedor savedProveedor = serviceProveedor.guardar(proveedor);
        return convertToDto(savedProveedor);
    }

    /**
     * PUT /proveedores
     * @param proveedorDto DTO con los datos a actualizar.
     * @return El DTO del proveedor actualizado, o 404 si no existe.
     */
    @PutMapping("/proveedores")
    public ResponseEntity<ProveedorDTO> modificar(@RequestBody ProveedorDTO proveedorDto) {
        if (proveedorDto.getIdProveedor() == null) {
            return ResponseEntity.badRequest().body(null);
        }

        return serviceProveedor.buscarId(proveedorDto.getIdProveedor())
                .map(proveedorExistente -> {
                    // Mapear datos del DTO a la entidad existente
                    mapDtoToEntity(proveedorDto, proveedorExistente);

                    Proveedor updatedProveedor = serviceProveedor.modificar(proveedorExistente);
                    return ResponseEntity.ok(convertToDto(updatedProveedor));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/proveedores/{idProveedor}")
    public String eliminar(@PathVariable Integer idProveedor){
        serviceProveedor.eliminar(idProveedor);
        return "Proveedor eliminado";
    }

    // --- Métodos de Ayuda ---

    private ProveedorDTO convertToDto(Proveedor proveedor) {
        ProveedorDTO dto = new ProveedorDTO();
        dto.setIdProveedor(proveedor.getIdProveedor());
        dto.setRucProveedor(proveedor.getRucProveedor());
        dto.setNombreProveedor(proveedor.getNombreProveedor());
        dto.setTelefonoMovilProveedor(proveedor.getTelefonoMovilProveedor());
        dto.setEmailProveedor(proveedor.getEmailProveedor());
        dto.setLogoProveedor(proveedor.getLogoProveedor());
        dto.setDireccionProveedor(proveedor.getDireccionProveedor());
        dto.setEstadoProveedor(proveedor.getEstadoProveedor());
        dto.setTelefonoFijoProveedor(proveedor.getTelefonoFijoProveedor());
        dto.setNumeroContactoProveedor(proveedor.getNumeroContactoProveedor());
        dto.setFechaRegistroProveedor(proveedor.getFechaRegistroProveedor());
        dto.setIdEmpresa(proveedor.getIdEmpresa());
        return dto;
    }

    private void mapDtoToEntity(ProveedorDTO dto, Proveedor entity) {
        entity.setRucProveedor(dto.getRucProveedor());
        entity.setNombreProveedor(dto.getNombreProveedor());
        entity.setTelefonoMovilProveedor(dto.getTelefonoMovilProveedor());
        entity.setEmailProveedor(dto.getEmailProveedor());
        entity.setLogoProveedor(dto.getLogoProveedor());
        entity.setDireccionProveedor(dto.getDireccionProveedor());
        entity.setTelefonoFijoProveedor(dto.getTelefonoFijoProveedor());
        entity.setNumeroContactoProveedor(dto.getNumeroContactoProveedor());
        entity.setIdEmpresa(dto.getIdEmpresa());
    }
}