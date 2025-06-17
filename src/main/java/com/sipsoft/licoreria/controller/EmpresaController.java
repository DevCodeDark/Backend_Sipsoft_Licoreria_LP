package com.sipsoft.licoreria.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipsoft.licoreria.dto.EmpresaDTO;
import com.sipsoft.licoreria.entity.Empresa;
import com.sipsoft.licoreria.services.IEmpresaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/sipsoft")
@Tag(name = "Empresas", description = "Gestión de empresas del sistema")
public class EmpresaController {
    @Autowired
    private IEmpresaService serviceEmpresa;    @GetMapping("/empresas")
    @Operation(summary = "Obtener todas las empresas", security = @SecurityRequirement(name = "bearerAuth"))
    public List<Empresa> buscarTodos() {
        return serviceEmpresa.bucarTodos();
    }

    /**
     * Endpoint para crear una nueva empresa.
     * @param empresaDto DTO con la información de la empresa a crear.
     * @return La entidad Empresa creada y guardada.
     */
    @PostMapping("/empresas")
    public Empresa guardar(@RequestBody EmpresaDTO empresaDto) {
        Empresa empresa = new Empresa();
        empresa.setNombreEmpresa(empresaDto.getNombreEmpresa());
        empresa.setRucEmpresa(empresaDto.getRucEmpresa());
        empresa.setLogoEmpresa(empresaDto.getLogoEmpresa());
        empresa.setFecharegistroEmpresa(LocalDateTime.now()); // Establece la fecha de registro
        empresa.setEstadoEmpresa(1); // Establece el estado por defecto
        return serviceEmpresa.guardar(empresa);
    }

    /**
     * Endpoint para modificar una empresa existente.
     * @param empresaDto DTO con los datos a actualizar.
     * @return La entidad Empresa actualizada o un mensaje de error si no se encuentra.
     */
    @PutMapping("/empresas")
    public ResponseEntity<?> modificar(@RequestBody EmpresaDTO empresaDto) {
        if (empresaDto.getIdEmpresa() == null) {
            return ResponseEntity.badRequest().body("El idEmpresa es requerido para modificar.");
        }
        
        Optional<Empresa> empresaOpt = serviceEmpresa.buscarId(empresaDto.getIdEmpresa());
        if (empresaOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("No se encontró la empresa con ID: " + empresaDto.getIdEmpresa());
        }

        Empresa empresaExistente = empresaOpt.get();
        empresaExistente.setNombreEmpresa(empresaDto.getNombreEmpresa());
        empresaExistente.setRucEmpresa(empresaDto.getRucEmpresa());
        empresaExistente.setLogoEmpresa(empresaDto.getLogoEmpresa());
        
        Empresa empresaModificada = serviceEmpresa.modificar(empresaExistente);
        return ResponseEntity.ok(empresaModificada);
    }

    @GetMapping("/empresas/{idEmpresa}")
    public Optional<Empresa> buscarId(@PathVariable("idEmpresa") Integer idEmpresa) {
        return serviceEmpresa.buscarId(idEmpresa);
    }

    @DeleteMapping("/empresas/{idEmpresa}")
    public String eliminar(@PathVariable Integer idEmpresa){
        serviceEmpresa.eliminar(idEmpresa);
        return "Empresa eliminada";
    }
}