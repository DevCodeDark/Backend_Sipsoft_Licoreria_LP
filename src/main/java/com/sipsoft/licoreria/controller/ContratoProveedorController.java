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

import com.sipsoft.licoreria.dto.ContratoProveedorDTO;
import com.sipsoft.licoreria.entity.ContratoProveedor;
import com.sipsoft.licoreria.entity.Proveedor;
import com.sipsoft.licoreria.repository.ProveedorRepository;
import com.sipsoft.licoreria.services.IContratoProveedorService;

@RestController
@RequestMapping("/sipsoft")
public class ContratoProveedorController {
    @Autowired
    private IContratoProveedorService serviceContratoProveedor;

    @Autowired
    private ProveedorRepository repoProveedor;

    @GetMapping("/contratos-proveedor")
    public List<ContratoProveedor> buscarTodos() {
        return serviceContratoProveedor.bucarTodos();
    }
    @PostMapping("/contratos-proveedor")
    public ResponseEntity <?> guardar(@RequestBody ContratoProveedorDTO dto) {
       ContratoProveedor contratoProveedor = new ContratoProveedor();
       contratoProveedor.setRutaPdfContratoProveedor(dto.getRutaPdfContratoProveedor());
       contratoProveedor.setFechaInicioContratoProveedor(dto.getFechaInicioContratoProveedor());
       contratoProveedor.setFechaFinContratoProveedor(dto.getFechaFinContratoProveedor());
       contratoProveedor.setDetallesContrato(dto.getDetallesContrato());;



        Proveedor proveedor = repoProveedor.findById(dto.getIdProveedor()).orElse(null);
        
        contratoProveedor.setIdProveedor(proveedor);      


        return ResponseEntity.ok(serviceContratoProveedor.guardar(contratoProveedor));
    }

    @PutMapping("/contratos-proveedor")
    public ResponseEntity <?> modificar(@RequestBody ContratoProveedorDTO dto) {
        if (dto.getIdContratoProveedor() == null) {
            return ResponseEntity.badRequest().body("ID no existe");            
        }
       ContratoProveedor contratoProveedor = new ContratoProveedor();
       contratoProveedor.setIdContratoProveedor(dto.getIdContratoProveedor());
       contratoProveedor.setRutaPdfContratoProveedor(dto.getRutaPdfContratoProveedor());
       contratoProveedor.setFechaInicioContratoProveedor(dto.getFechaInicioContratoProveedor());
       contratoProveedor.setFechaFinContratoProveedor(dto.getFechaFinContratoProveedor());
       contratoProveedor.setDetallesContrato(dto.getDetallesContrato());;



        
        contratoProveedor.setIdProveedor(new Proveedor(dto.getIdProveedor()));      


        return ResponseEntity.ok(serviceContratoProveedor.modificar(contratoProveedor));
    }

    @GetMapping("/contratos-proveedor/{idContratoProveedor}")
    public Optional<ContratoProveedor> buscarId(@PathVariable("idContratoProveedor") Integer idContratoProveedor) {
        return serviceContratoProveedor.buscarId(idContratoProveedor);
    }

    @DeleteMapping("/contratos-proveedor/{idContratoProveedor}")
    public String eliminar(@PathVariable Integer idContratoProveedor){
        serviceContratoProveedor.eliminar(idContratoProveedor);
        return "Contrato Proveedor eliminado";
    }
}
