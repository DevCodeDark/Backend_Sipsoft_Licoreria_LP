package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.ContratoProveedor;
import com.sipsoft.licoreria.repository.ContratoProveedorRepository;
import com.sipsoft.licoreria.services.IContratoProveedorService;

@Service
public class ContratoProveedorService implements IContratoProveedorService {
    @Autowired
    private ContratoProveedorRepository repoContratoProveedor;
    
    public List<ContratoProveedor> bucarTodos() {
        return repoContratoProveedor.findAll();
    }
    
    public ContratoProveedor guardar(ContratoProveedor contratoProveedor) {
        return repoContratoProveedor.save(contratoProveedor);
    }
    
    public ContratoProveedor modificar(ContratoProveedor contratoProveedor) {
        return repoContratoProveedor.save(contratoProveedor);
    }
    
    public Optional<ContratoProveedor> buscarId(Integer idContratoProveedor) {
        return repoContratoProveedor.findById(idContratoProveedor);
    }
    
    public void eliminar(Integer idContratoProveedor) {
        repoContratoProveedor.deleteById(idContratoProveedor);
    }
}
