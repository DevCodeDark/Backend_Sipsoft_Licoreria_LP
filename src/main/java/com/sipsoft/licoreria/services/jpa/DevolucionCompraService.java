package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sipsoft.licoreria.entity.DevolucionCompra;
import com.sipsoft.licoreria.repository.DevolucionCompraRepository;
import com.sipsoft.licoreria.services.IDevolucionCompraService;

@Service
public class DevolucionCompraService implements IDevolucionCompraService {
    @Autowired
    private DevolucionCompraRepository repoDevolucionCompra;
    
    public List<DevolucionCompra> bucarTodos() {
        return repoDevolucionCompra.findAll();
    }
    
    public DevolucionCompra guardar(DevolucionCompra devolucionCompra) {
        return repoDevolucionCompra.save(devolucionCompra);
    }
    
    public DevolucionCompra modificar(DevolucionCompra devolucionCompra) {
        return repoDevolucionCompra.save(devolucionCompra);
    }
    
    public Optional<DevolucionCompra> buscarId(Integer idDevolucionCompra) {
        return repoDevolucionCompra.findById(idDevolucionCompra);
    }
    
    public void eliminar(Integer idDevolucionCompra) {
        repoDevolucionCompra.deleteById(idDevolucionCompra);
    }
}