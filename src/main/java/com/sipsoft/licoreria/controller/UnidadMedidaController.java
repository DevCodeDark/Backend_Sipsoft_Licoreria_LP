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

import com.sipsoft.licoreria.entity.UnidadMedida;
import com.sipsoft.licoreria.dto.UnidadMedidaDTO;
import com.sipsoft.licoreria.entity.Empresa;
import com.sipsoft.licoreria.repository.EmpresaRepository;
import com.sipsoft.licoreria.services.IUnidadMedidaService;

@RestController
@RequestMapping("/sipsoft")
public class UnidadMedidaController {
    @Autowired
    private IUnidadMedidaService serviceUnidadMedida;

    @Autowired
    private EmpresaRepository repoEmpresa;

    @GetMapping("/unidades-medida")
    @Transactional(readOnly = true)
    public ResponseEntity<List<UnidadMedidaDTO>> buscarTodos() {
        try {
            List<UnidadMedida> unidades = serviceUnidadMedida.buscarTodos();
            List<UnidadMedidaDTO> unidadesDTO = unidades.stream()
                    .map(this::convertirEntidadADTO)
                    .toList();
            return ResponseEntity.ok(unidadesDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/unidades-medida")
    @Transactional
    public ResponseEntity<UnidadMedidaDTO> guardar(@RequestBody UnidadMedidaDTO dto) {
        try {
            UnidadMedida unidad = new UnidadMedida();
            unidad.setNombreUnidadMedida(dto.getNombreUnidadMedida());
            unidad.setAbreviaturaUnidadMedida(dto.getAbreviaturaUnidadMedida());
            unidad.setEstadoUnidadMedida(dto.getEstadoUnidadMedida());

            if (dto.getIdEmpresa() != null) {
                Empresa empresa = repoEmpresa.findById(dto.getIdEmpresa()).orElse(null);
                unidad.setIdEmpresa(empresa);
            }

            UnidadMedida guardado = serviceUnidadMedida.guardar(unidad);
            UnidadMedidaDTO resultDto = convertirEntidadADTO(guardado);
            return ResponseEntity.status(HttpStatus.CREATED).body(resultDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/unidades-medida")
    @Transactional
    public ResponseEntity<UnidadMedidaDTO> modificar(@RequestBody UnidadMedidaDTO dto) {
        try {
            if (dto.getIdUnidadMedida() == null) {
                return ResponseEntity.badRequest().build();
            }

            UnidadMedida unidad = new UnidadMedida();
            unidad.setIdUnidadMedida(dto.getIdUnidadMedida());
            unidad.setNombreUnidadMedida(dto.getNombreUnidadMedida());
            unidad.setAbreviaturaUnidadMedida(dto.getAbreviaturaUnidadMedida());
            unidad.setEstadoUnidadMedida(dto.getEstadoUnidadMedida());

            if (dto.getIdEmpresa() != null) {
                Empresa empresa = repoEmpresa.findById(dto.getIdEmpresa()).orElse(null);
                unidad.setIdEmpresa(empresa);
            }

            UnidadMedida modificado = serviceUnidadMedida.modificar(unidad);
            UnidadMedidaDTO resultDto = convertirEntidadADTO(modificado);
            return ResponseEntity.ok(resultDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/unidades-medida/{idUnidadMedida}")
    @Transactional(readOnly = true)
    public ResponseEntity<UnidadMedidaDTO> buscarId(@PathVariable("idUnidadMedida") Integer idUnidadMedida) {
        try {
            Optional<UnidadMedida> unidad = serviceUnidadMedida.buscarId(idUnidadMedida);
            if (unidad.isPresent()) {
                UnidadMedidaDTO dto = convertirEntidadADTO(unidad.get());
                return ResponseEntity.ok(dto);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/unidades-medida/{idUnidadMedida}")
    @Transactional
    public String eliminar(@PathVariable Integer idUnidadMedida) {
        serviceUnidadMedida.eliminar(idUnidadMedida);
        return "Unidad Medida eliminada";
    }

    // Métodos de conversión
    private UnidadMedidaDTO convertirEntidadADTO(UnidadMedida entidad) {
        UnidadMedidaDTO dto = new UnidadMedidaDTO();
        dto.setIdUnidadMedida(entidad.getIdUnidadMedida());
        dto.setNombreUnidadMedida(entidad.getNombreUnidadMedida());
        dto.setAbreviaturaUnidadMedida(entidad.getAbreviaturaUnidadMedida());
        dto.setEstadoUnidadMedida(entidad.getEstadoUnidadMedida());
        dto.setIdEmpresa(entidad.getEmpresaId());
        return dto;
    }
}
