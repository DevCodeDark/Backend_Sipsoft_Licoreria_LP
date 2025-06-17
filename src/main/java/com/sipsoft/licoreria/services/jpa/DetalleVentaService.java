package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sipsoft.licoreria.entity.DetalleVenta;
import com.sipsoft.licoreria.repository.DetalleVentaRepository;
import com.sipsoft.licoreria.services.IDetalleVentaService;

@Service
public class DetalleVentaService implements IDetalleVentaService {
    @Autowired
    private DetalleVentaRepository repoDetalleVenta;
    
    public List<DetalleVenta> bucarTodos() {
        return repoDetalleVenta.findAll();
    }
    
    public DetalleVenta guardar(DetalleVenta detalleVenta) {
        return repoDetalleVenta.save(detalleVenta);
    }
    
    public DetalleVenta modificar(DetalleVenta detalleVenta) {
        return repoDetalleVenta.save(detalleVenta);
    }
    
    public Optional<DetalleVenta> buscarId(Integer idDetalleVenta) {
        return repoDetalleVenta.findById(idDetalleVenta);
    }
    
    public void eliminar(Integer idDetalleVenta) {
        repoDetalleVenta.deleteById(idDetalleVenta);
    }
}