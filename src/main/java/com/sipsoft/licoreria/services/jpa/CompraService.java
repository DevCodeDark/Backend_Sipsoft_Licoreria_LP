package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sipsoft.licoreria.entity.Compra;
import com.sipsoft.licoreria.repository.CompraRepository;
import com.sipsoft.licoreria.services.ICompraService;

@Service
public class CompraService implements ICompraService {
    @Autowired
    private CompraRepository repoCompra;
    
    public List<Compra> bucarTodos() {
        return repoCompra.findAll();
    }
    
    public Compra guardar(Compra compra) {
        return repoCompra.save(compra);
    }
    
    public Compra modificar(Compra compra) {
        return repoCompra.save(compra);
    }
    
    public Optional<Compra> buscarId(Integer idCompra) {
        return repoCompra.findById(idCompra);
    }
    
    public void eliminar(Integer idCompra) {
        repoCompra.deleteById(idCompra);
    }
}