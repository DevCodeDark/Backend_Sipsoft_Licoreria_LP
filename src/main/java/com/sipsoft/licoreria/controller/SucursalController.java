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

import com.sipsoft.licoreria.dto.SucursalDTO;
import com.sipsoft.licoreria.entity.Empresa;
import com.sipsoft.licoreria.entity.Sucursal;
import com.sipsoft.licoreria.repository.EmpresaRepository;
import com.sipsoft.licoreria.services.ISucursalService;

@RestController
@RequestMapping("/sipsoft")
public class SucursalController {
    @Autowired
    private ISucursalService serviceSucursal;

    @Autowired
    private EmpresaRepository repoEmpresa;

    @GetMapping("/sucursales")
    @Transactional(readOnly = true)
    public List<Sucursal> buscarTodos() {
        return serviceSucursal.buscarTodos();
    }

    @PostMapping("/sucursales")
    @Transactional
    public ResponseEntity<?> guardar(@RequestBody SucursalDTO dto) {
        Sucursal sucursal = new Sucursal();
        sucursal.setUbicacionSucursal(dto.getUbicacionSucursal());
        sucursal.setEstadoSucursal(dto.getEstadoSucursal() != null ? dto.getEstadoSucursal() : 1);

        Empresa empresa = repoEmpresa.findById(dto.getIdEmpresa()).orElse(null);
        sucursal.setIdEmpresa(empresa);

        return ResponseEntity.ok(serviceSucursal.guardar(sucursal));
    }

    @PutMapping("/sucursales")
    @Transactional
    public ResponseEntity<?> modificar(@RequestBody SucursalDTO dto) {
        if (dto.getIdSucursal() == null) {
            return ResponseEntity.badRequest().body("ID no existe");
        }
        Sucursal sucursal = new Sucursal();
        sucursal.setIdSucursal(dto.getIdSucursal());
        sucursal.setUbicacionSucursal(dto.getUbicacionSucursal());
        sucursal.setEstadoSucursal(dto.getEstadoSucursal() != null ? dto.getEstadoSucursal() : 1);

        Empresa empresa = repoEmpresa.findById(dto.getIdEmpresa()).orElse(null);
        sucursal.setIdEmpresa(empresa);

        return ResponseEntity.ok(serviceSucursal.modificar(sucursal));
    }

    @GetMapping("/sucursales/{idSucursal}")
    @Transactional(readOnly = true)
    public Optional<Sucursal> buscarId(@PathVariable("idSucursal") Integer idSucursal) {
        return serviceSucursal.buscarId(idSucursal);
    }

    @DeleteMapping("/sucursales/{idSucursal}")
    @Transactional
    public String eliminar(@PathVariable Integer idSucursal) {
        serviceSucursal.eliminar(idSucursal);
        return "Sucursal eliminada";
    }
}
