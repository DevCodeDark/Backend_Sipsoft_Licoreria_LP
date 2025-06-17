package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.DeudaProveedor;
import com.sipsoft.licoreria.repository.DeudaProveedorRepository;
import com.sipsoft.licoreria.services.IDeudaProveedorService;

@Service
public class DeudaProveedorService implements IDeudaProveedorService {
    @Autowired
    private DeudaProveedorRepository repoDeudaProveedor;
    
    public List<DeudaProveedor> bucarTodos() {
        return repoDeudaProveedor.findAll();
    }
    
    public DeudaProveedor guardar(DeudaProveedor deudaProveedor) {
        return repoDeudaProveedor.save(deudaProveedor);
    }
    
    public DeudaProveedor modificar(DeudaProveedor deudaProveedor) {
        return repoDeudaProveedor.save(deudaProveedor);
    }
    
    public Optional<DeudaProveedor> buscarId(Integer idDeuda) {
        return repoDeudaProveedor.findById(idDeuda);
    }
    
    public void eliminar(Integer idDeuda) {
        repoDeudaProveedor.deleteById(idDeuda);
    }
}
