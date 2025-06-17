package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.Venta;
import com.sipsoft.licoreria.repository.VentaRepository;
import com.sipsoft.licoreria.services.IVentaService;

@Service
public class VentaService implements IVentaService {
    @Autowired
    private VentaRepository repoVenta;
    
    public List<Venta> bucarTodos() {
        return repoVenta.findAll();
    }
    
    public Venta guardar(Venta venta) {
        return repoVenta.save(venta);
    }
    
    public Venta modificar(Venta venta) {
        return repoVenta.save(venta);
    }
    
    public Optional<Venta> buscarId(Integer idVenta) {
        return repoVenta.findById(idVenta);
    }
    
    public void eliminar(Integer idVenta) {
        repoVenta.deleteById(idVenta);
    }
}
