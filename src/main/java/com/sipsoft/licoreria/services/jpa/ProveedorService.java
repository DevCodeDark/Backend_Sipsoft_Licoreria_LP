package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sipsoft.licoreria.entity.Proveedor;
import com.sipsoft.licoreria.repository.ProveedorRepository;
import com.sipsoft.licoreria.services.IProveedorService;

@Service
public class ProveedorService implements IProveedorService {
    @Autowired
    private ProveedorRepository repoProveedor;
    
    public List<Proveedor> bucarTodos() {
        return repoProveedor.findAll();
    }
    
    public Proveedor guardar(Proveedor proveedor) {
        return repoProveedor.save(proveedor);
    }
    
    public Proveedor modificar(Proveedor proveedor) {
        return repoProveedor.save(proveedor);
    }
    
    public Optional<Proveedor> buscarId(Integer idProveedor) {
        return repoProveedor.findById(idProveedor);
    }
    
    public void eliminar(Integer idProveedor) {
        repoProveedor.deleteById(idProveedor);
    }
}