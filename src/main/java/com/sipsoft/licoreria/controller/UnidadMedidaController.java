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
    public List<UnidadMedida> buscarTodos() {
        return serviceUnidadMedida.bucarTodos();
    }

    @PostMapping("/unidades-medida")
    public UnidadMedida guardar(@RequestBody UnidadMedidaDTO dto) {
        UnidadMedida unidad = new UnidadMedida();
        unidad.setNombreUnidadMedida(dto.getNombreUnidadMedida());
        unidad.setAbreviaturaUnidadMedida(dto.getAbreviaturaUnidadMedida());
        unidad.setEstadoUnidadMedida(dto.getEstadoUnidadMedida());
        Empresa empresa = repoEmpresa.findById(dto.getIdEmpresa()).orElse(null);
        unidad.setIdEmpresa(empresa);
        serviceUnidadMedida.guardar(unidad);
        return unidad;
    }

    @PutMapping("/unidades-medida")
    public UnidadMedida modificar(@RequestBody UnidadMedidaDTO dto) {
        UnidadMedida unidad = new UnidadMedida();
        unidad.setIdUnidadMedida(dto.getIdUnidadMedida());
        unidad.setNombreUnidadMedida(dto.getNombreUnidadMedida());
        unidad.setAbreviaturaUnidadMedida(dto.getAbreviaturaUnidadMedida());
        unidad.setEstadoUnidadMedida(dto.getEstadoUnidadMedida());
        Empresa empresa = repoEmpresa.findById(dto.getIdEmpresa()).orElse(null);
        unidad.setIdEmpresa(empresa);
        serviceUnidadMedida.modificar(unidad);
        return unidad;
    }

    @GetMapping("/unidades-medida/{idUnidadMedida}")
    public Optional<UnidadMedida> buscarId(@PathVariable("idUnidadMedida") Integer idUnidadMedida) {
        return serviceUnidadMedida.buscarId(idUnidadMedida);
    }

    @DeleteMapping("/unidades-medida/{idUnidadMedida}")
    public String eliminar(@PathVariable Integer idUnidadMedida){
        serviceUnidadMedida.eliminar(idUnidadMedida);
        return "Unidad Medida eliminada";
    }
}
