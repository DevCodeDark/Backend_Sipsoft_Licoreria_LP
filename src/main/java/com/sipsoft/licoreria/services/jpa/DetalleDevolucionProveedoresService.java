package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sipsoft.licoreria.entity.DetalleDevolucionProveedores;
import com.sipsoft.licoreria.repository.DetalleDevolucionProveedoresRepository;
import com.sipsoft.licoreria.services.IDetalleDevolucionProveedoresService;

@Service
public class DetalleDevolucionProveedoresService implements IDetalleDevolucionProveedoresService {
    @Autowired
    private DetalleDevolucionProveedoresRepository repoDetalleDevolucionProveedores;
    
    public List<DetalleDevolucionProveedores> bucarTodos() {
        return repoDetalleDevolucionProveedores.findAll();
    }
    
    public DetalleDevolucionProveedores guardar(DetalleDevolucionProveedores detalleDevolucionProveedores) {
        return repoDetalleDevolucionProveedores.save(detalleDevolucionProveedores);
    }
    
    public DetalleDevolucionProveedores modificar(DetalleDevolucionProveedores detalleDevolucionProveedores) {
        return repoDetalleDevolucionProveedores.save(detalleDevolucionProveedores);
    }
    
    public Optional<DetalleDevolucionProveedores> buscarId(Integer idDetalleDevolucion) {
        return repoDetalleDevolucionProveedores.findById(idDetalleDevolucion);
    }
    
    public void eliminar(Integer idDetalleDevolucion) {
        repoDetalleDevolucionProveedores.deleteById(idDetalleDevolucion);
    }
}