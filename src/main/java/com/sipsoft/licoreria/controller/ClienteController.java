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

import com.sipsoft.licoreria.dto.ClienteDTO;
import com.sipsoft.licoreria.entity.Cliente;
import com.sipsoft.licoreria.services.IClienteService;

@RestController
@RequestMapping("/sipsoft")
public class ClienteController {
    @Autowired
    private IClienteService serviceCliente;

    @GetMapping("/clientes")
    @Transactional(readOnly = true)
    public List<Cliente> buscarTodos() {
        return serviceCliente.bucarTodos();
    }

    @PostMapping("/clientes")
    @Transactional
    public ResponseEntity<Cliente> guardar(@RequestBody ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setIdEmpresa(dto.getIdEmpresa());
        cliente.setNumDocumento(dto.getNumDocumento());
        cliente.setNombreCliente(dto.getNombreCliente());
        cliente.setApellidoCliente(dto.getApellidoCliente());
        cliente.setTelefonoCliente(dto.getTelefonoCliente());
        cliente.setTipoCliente(dto.getTipoCliente());
        cliente.setEstadoCliente(dto.getEstadoCliente());

        return ResponseEntity.ok(serviceCliente.guardar(cliente));
    }

    @PutMapping("/clientes")
    @Transactional
    public ResponseEntity<Object> modificar(@RequestBody ClienteDTO dto) {
        if (dto.getIdCliente() == null) {
            return ResponseEntity.badRequest().body("ID no existe");
        }
        Cliente cliente = new Cliente();
        cliente.setIdCliente(dto.getIdCliente());
        cliente.setIdEmpresa(dto.getIdEmpresa());
        cliente.setNumDocumento(dto.getNumDocumento());
        cliente.setNombreCliente(dto.getNombreCliente());
        cliente.setApellidoCliente(dto.getApellidoCliente());
        cliente.setTelefonoCliente(dto.getTelefonoCliente());
        cliente.setTipoCliente(dto.getTipoCliente());
        cliente.setEstadoCliente(dto.getEstadoCliente());

        return ResponseEntity.ok(serviceCliente.modificar(cliente));
    }

    @GetMapping("/clientes/{idCliente}")
    @Transactional(readOnly = true)
    public Optional<Cliente> buscarId(@PathVariable("idCliente") Integer idCliente) {
        return serviceCliente.buscarId(idCliente);
    }

    @DeleteMapping("/clientes/{idCliente}")
    @Transactional
    public String eliminar(@PathVariable Integer idCliente) {
        serviceCliente.eliminar(idCliente);
        return "Cliente eliminado";
    }
}
