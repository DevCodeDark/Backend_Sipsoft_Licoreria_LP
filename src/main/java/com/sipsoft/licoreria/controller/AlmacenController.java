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

import com.sipsoft.licoreria.dto.AlmacenDTO;
import com.sipsoft.licoreria.entity.Almacen;
import com.sipsoft.licoreria.entity.Sucursal;
import com.sipsoft.licoreria.repository.SucursalRepository;
import com.sipsoft.licoreria.services.IAlmacenesService;

@RestController
@RequestMapping("/sipsoft")
public class AlmacenController {
    @Autowired
    private IAlmacenesService serviceAlmacenes;

    @Autowired
    private SucursalRepository repoSucursal; //AQUI

    @GetMapping("/almacenes")
    public List<Almacen> buscarTodos() {
        return serviceAlmacenes.bucarTodos();
    }
    @PostMapping("/almacenes") //AQUI
    public ResponseEntity <?> guardar(@RequestBody AlmacenDTO dto) {
        Almacen almacen = new Almacen();
        almacen.setDescripcionAlmacen(dto.getDescripcionAlmacen());
        
        Sucursal sucursal = repoSucursal.findById(dto.getIdSucursal()).orElse(null);
        almacen.setIdSucursal(sucursal);
        

        return ResponseEntity.ok(serviceAlmacenes.guardar(almacen));
    }

    @PutMapping("/almacenes")
    public ResponseEntity <?> modificar(@RequestBody AlmacenDTO dto) {
        if (dto.getIdAlmacen() == null) {
            return ResponseEntity.badRequest().body("ID no existe");            
        }
        Almacen almacen = new Almacen();
        almacen.setDescripcionAlmacen(dto.getDescripcionAlmacen());
        almacen.setIdAlmacen(dto.getIdAlmacen());
        
        almacen.setIdSucursal(new Sucursal(dto.getIdSucursal()));

        return ResponseEntity.ok(serviceAlmacenes.modificar(almacen));
    }

    @GetMapping("/almacenes/{idAlmacen}")
    public Optional<Almacen> buscarId(@PathVariable("idAlmacen") Integer idAlmacen) {
        return serviceAlmacenes.buscarId(idAlmacen);
    }

    @DeleteMapping("/almacenes/{idAlmacen}")
    public String eliminar(@PathVariable Integer idAlmacen){
        serviceAlmacenes.eliminar(idAlmacen);
        return "Almacen eliminado";
    }
}
