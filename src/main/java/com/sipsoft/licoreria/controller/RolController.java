package com.sipsoft.licoreria.controller;

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

import com.sipsoft.licoreria.dto.RolDTO;
import com.sipsoft.licoreria.entity.Rol;
import com.sipsoft.licoreria.services.IRolService;

@RestController
@RequestMapping("/sipsoft")
public class RolController {
    @Autowired
    private IRolService serviceRol;

    @GetMapping("/roles")
    public List<Rol> buscarTodos() {
        return serviceRol.bucarTodos();
    }

    /**
     * Endpoint para crear un nuevo rol.
     * @param rolDto DTO con la información del rol a crear.
     * @return El rol creado y guardado.
     */
    @PostMapping("/roles")
    public Rol guardar(@RequestBody RolDTO rolDto) {
        Rol rol = new Rol();
        rol.setNombreRol(rolDto.getNombreRol());
        rol.setDescripcionRol(rolDto.getDescripcionRol());
        rol.setIdEmpresa(rolDto.getIdEmpresa());
        rol.setEstadoRol(1); // Se establece el estado activo por defecto
        
        return serviceRol.guardar(rol);
    }

    /**
     * Endpoint para modificar un rol existente.
     * @param rolDto DTO con la información a actualizar.
     * @return El rol modificado o un mensaje de error si no se encuentra.
     */
    @PutMapping("/roles")
    public ResponseEntity<?> modificar(@RequestBody RolDTO rolDto) {
        if (rolDto.getIdRol() == null) {
            return ResponseEntity.badRequest().body("El idRol es requerido para modificar.");
        }
        
        Optional<Rol> rolOpt = serviceRol.buscarId(rolDto.getIdRol());
        if (rolOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("No se encontró el Rol con ID: " + rolDto.getIdRol());
        }

        Rol rolExistente = rolOpt.get();
        rolExistente.setNombreRol(rolDto.getNombreRol());
        rolExistente.setDescripcionRol(rolDto.getDescripcionRol());
        rolExistente.setIdEmpresa(rolDto.getIdEmpresa());

        Rol rolModificado = serviceRol.modificar(rolExistente);
        return ResponseEntity.ok(rolModificado);
    }

    @GetMapping("/roles/{idRol}")
    public Optional<Rol> buscarId(@PathVariable("idRol") Integer idRol) {
        return serviceRol.buscarId(idRol);
    }

    @DeleteMapping("/roles/{idRol}")
    public String eliminar(@PathVariable Integer idRol){
        serviceRol.eliminar(idRol);
        return "Rol eliminado";
    }
}