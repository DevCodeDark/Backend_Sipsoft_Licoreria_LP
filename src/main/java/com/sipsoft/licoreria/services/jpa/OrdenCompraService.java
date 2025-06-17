package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sipsoft.licoreria.entity.OrdenCompra;
import com.sipsoft.licoreria.repository.OrdenCompraRepository;
import com.sipsoft.licoreria.services.IOrdenCompraService;

@Service
public class OrdenCompraService implements IOrdenCompraService {
    @Autowired
    private OrdenCompraRepository repoOrdenCompra;
    
    public List<OrdenCompra> bucarTodos() {
        return repoOrdenCompra.findAll();
    }
    
    public OrdenCompra guardar(OrdenCompra ordenCompra) {
        return repoOrdenCompra.save(ordenCompra);
    }
    
    public OrdenCompra modificar(OrdenCompra ordenCompra) {
        return repoOrdenCompra.save(ordenCompra);
    }
    
    public Optional<OrdenCompra> buscarId(Integer idOrden) {
        return repoOrdenCompra.findById(idOrden);
    }
    
    public void eliminar(Integer idOrden) {
        repoOrdenCompra.deleteById(idOrden);
    }
}