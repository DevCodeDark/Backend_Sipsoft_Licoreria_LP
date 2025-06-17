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

import com.sipsoft.licoreria.dto.DeudaProveedorDTO;
import com.sipsoft.licoreria.entity.Compra;
import com.sipsoft.licoreria.entity.DeudaProveedor;
import com.sipsoft.licoreria.repository.CompraRepository;
import com.sipsoft.licoreria.services.IDeudaProveedorService;

@RestController
@RequestMapping("/sipsoft")
public class DeudaProveedorController {
    @Autowired
    private IDeudaProveedorService serviceDeudaProveedor;

    @Autowired
    private CompraRepository repoCompra;

    @GetMapping("/deuda-proveedor")
    public List<DeudaProveedor> buscarTodos() {
        return serviceDeudaProveedor.bucarTodos();
    }
    @PostMapping("/deuda-proveedor")
    public ResponseEntity <?> guardar(@RequestBody DeudaProveedorDTO dto) {
       DeudaProveedor deudaProveedor = new DeudaProveedor();
       deudaProveedor.setFechaDeuda(dto.getFechaDeuda());
       deudaProveedor.setMontoDeuda(dto.getMontoDeuda());
       deudaProveedor.setMontoPagado(dto.getMontoPagado());
       deudaProveedor.setFechaLimiteDeuda(dto.getFechaLimiteDeuda());



        Compra compra = repoCompra.findById(dto.getIdCompra()).orElse(null);

        deudaProveedor.setIdCompra(compra); 

        return ResponseEntity.ok(serviceDeudaProveedor.guardar(deudaProveedor));
    }


    @PutMapping("/deuda-proveedor")
    public ResponseEntity <?> modificar(@RequestBody DeudaProveedorDTO dto) {
        if (dto.getIdDeuda() == null) {
            return ResponseEntity.badRequest().body("ID no existe");            
        }
        DeudaProveedor deudaProveedor = new DeudaProveedor();
        deudaProveedor.setIdDeuda(dto.getIdDeuda());
        deudaProveedor.setFechaDeuda(dto.getFechaDeuda());
        deudaProveedor.setMontoDeuda(dto.getMontoDeuda());
        deudaProveedor.setMontoPagado(dto.getMontoPagado());
        deudaProveedor.setFechaLimiteDeuda(dto.getFechaLimiteDeuda());

        Compra compra = repoCompra.findById(dto.getIdCompra()).orElse(null);
        deudaProveedor.setIdCompra(compra);

        return ResponseEntity.ok(serviceDeudaProveedor.modificar(deudaProveedor));
    }

    @GetMapping("/deuda-proveedor/{idDeuda}")
    public Optional<DeudaProveedor> buscarId(@PathVariable("idDeuda") Integer idDeuda) {
        return serviceDeudaProveedor.buscarId(idDeuda);
    }

    @DeleteMapping("/deuda-proveedor/{idDeuda}")
    public String eliminar(@PathVariable Integer idDeuda){
        serviceDeudaProveedor.eliminar(idDeuda);
        return "Deuda Proveedor eliminada";
    }
}
