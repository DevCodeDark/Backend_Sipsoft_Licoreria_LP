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

import com.sipsoft.licoreria.dto.ClienteDTO;
import com.sipsoft.licoreria.entity.Cliente;
import com.sipsoft.licoreria.entity.Empresa;
import com.sipsoft.licoreria.repository.EmpresaRepository;
import com.sipsoft.licoreria.services.IClienteService;

@RestController
@RequestMapping("/sipsoft")
public class ClienteController {
    @Autowired
    private IClienteService serviceCliente;

    @Autowired
    private EmpresaRepository repoEmpresa;

    @GetMapping("/clientes")
    public List<Cliente> buscarTodos() {
        return serviceCliente.bucarTodos();
    }
    @PostMapping("/clientes")
    public ResponseEntity <?> guardar(@RequestBody ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNumDocumento(dto.getNumDocumento());
        cliente.setRazonSocial(dto.getRazonSocial());
        cliente.setNombreCliente(dto.getNombreCliente());
        cliente.setApellidoCliente(dto.getApellidoCliente());
        cliente.setTelefonoCliente(dto.getTelefonoCliente());
        cliente.setFrecuenciaCompra(dto.getFrecuenciaCompra());
        cliente.setMontoTotalComprado(dto.getMontoTotalComprado());
        cliente.setNombreRazonSocial(dto.getNombreRazonSocial());
        cliente.setTipoCliente(dto.getTipoCliente());


        Empresa empresa = repoEmpresa.findById(dto.getIdEmpresa()).orElse(null);
        
        cliente.setIdEmpresa(empresa);      


        return ResponseEntity.ok(serviceCliente.guardar(cliente));
    }

    @PutMapping("/clientes")
    public ResponseEntity <?> modificar(@RequestBody ClienteDTO dto) {
        if (dto.getIdCliente() == null) {
            return ResponseEntity.badRequest().body("ID no existe");            
        }
        Cliente cliente = new Cliente();
        cliente.setIdCliente(dto.getIdCliente());
        cliente.setNumDocumento(dto.getNumDocumento());
        cliente.setRazonSocial(dto.getRazonSocial());
        cliente.setNombreCliente(dto.getNombreCliente());
        cliente.setApellidoCliente(dto.getApellidoCliente());
        cliente.setTelefonoCliente(dto.getTelefonoCliente());
        cliente.setFrecuenciaCompra(dto.getFrecuenciaCompra());
        cliente.setMontoTotalComprado(dto.getMontoTotalComprado());
        cliente.setNombreRazonSocial(dto.getNombreRazonSocial());
        cliente.setTipoCliente(dto.getTipoCliente());      
        
        cliente.setIdEmpresa(new Empresa(dto.getIdEmpresa()));    


        return ResponseEntity.ok(serviceCliente.modificar(cliente));
    }

    @GetMapping("/clientes/{idCliente}")
    public Optional<Cliente> buscarId(@PathVariable("idCliente") Integer idCliente) {
        return serviceCliente.buscarId(idCliente);
    }

    @DeleteMapping("/clientes/{idCliente}")
    public String eliminar(@PathVariable Integer idCliente){
        serviceCliente.eliminar(idCliente);
        return "Cliente eliminado";
    }
}
