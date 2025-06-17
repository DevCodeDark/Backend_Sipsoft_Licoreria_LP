package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.Cliente;
import com.sipsoft.licoreria.repository.ClienteRepository;
import com.sipsoft.licoreria.services.IClienteService;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    private ClienteRepository repoCliente;
    
    public List<Cliente> bucarTodos() {
        return repoCliente.findAll();
    }
    
    public Cliente guardar(Cliente cliente) {
        return repoCliente.save(cliente);
    }
    
    public Cliente modificar(Cliente cliente) {
        return repoCliente.save(cliente);
    }
    
    public Optional<Cliente> buscarId(Integer idCliente) {
        return repoCliente.findById(idCliente);
    }
    
    public void eliminar(Integer idCliente) {
        repoCliente.deleteById(idCliente);
    }
}
