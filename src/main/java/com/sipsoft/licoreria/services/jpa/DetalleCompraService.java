package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sipsoft.licoreria.entity.DetalleCompra;
import com.sipsoft.licoreria.repository.DetalleCompraRepository;
import com.sipsoft.licoreria.services.IDetalleCompraService;

@Service
public class DetalleCompraService implements IDetalleCompraService {
    @Autowired
    private DetalleCompraRepository repoDetalleCompra;
    
    public List<DetalleCompra> bucarTodos() {
        return repoDetalleCompra.findAll();
    }
    
    public DetalleCompra guardar(DetalleCompra detalleCompra) {
        return repoDetalleCompra.save(detalleCompra);
    }
    
    public DetalleCompra modificar(DetalleCompra detalleCompra) {
        return repoDetalleCompra.save(detalleCompra);
    }
    
    public Optional<DetalleCompra> buscarId(Integer idDetalleCompra) {
        return repoDetalleCompra.findById(idDetalleCompra);
    }
    
    public void eliminar(Integer idDetalleCompra) {
        repoDetalleCompra.deleteById(idDetalleCompra);
    }
}