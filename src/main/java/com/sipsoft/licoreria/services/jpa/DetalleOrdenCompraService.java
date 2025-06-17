package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sipsoft.licoreria.entity.DetalleOrdenCompra;
import com.sipsoft.licoreria.repository.DetalleOrdenCompraRepository;
import com.sipsoft.licoreria.services.IDetalleOrdenCompraService;

@Service
public class DetalleOrdenCompraService implements IDetalleOrdenCompraService {
    @Autowired
    private DetalleOrdenCompraRepository repoDetalleOrdenCompra;
    
    public List<DetalleOrdenCompra> bucarTodos() {
        return repoDetalleOrdenCompra.findAll();
    }
    
    public DetalleOrdenCompra guardar(DetalleOrdenCompra detalleOrdenCompra) {
        return repoDetalleOrdenCompra.save(detalleOrdenCompra);
    }
    
    public DetalleOrdenCompra modificar(DetalleOrdenCompra detalleOrdenCompra) {
        return repoDetalleOrdenCompra.save(detalleOrdenCompra);
    }
    
    public Optional<DetalleOrdenCompra> buscarId(Integer idDetalleOrden) {
        return repoDetalleOrdenCompra.findById(idDetalleOrden);
    }
    
    public void eliminar(Integer idDetalleOrden) {
        repoDetalleOrdenCompra.deleteById(idDetalleOrden);
    }
}