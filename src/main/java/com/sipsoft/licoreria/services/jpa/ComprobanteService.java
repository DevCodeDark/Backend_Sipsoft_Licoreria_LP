package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sipsoft.licoreria.entity.Comprobante;
import com.sipsoft.licoreria.repository.ComprobanteRepository;
import com.sipsoft.licoreria.services.IComprobanteService;

@Service
public class ComprobanteService implements IComprobanteService {
    @Autowired
    private ComprobanteRepository repoComprobante;
    
    public List<Comprobante> bucarTodos() {
        return repoComprobante.findAll();
    }
    
    public Comprobante guardar(Comprobante comprobante) {
        return repoComprobante.save(comprobante);
    }
    
    public Comprobante modificar(Comprobante comprobante) {
        return repoComprobante.save(comprobante);
    }
    
    public Optional<Comprobante> buscarId(Integer idComprobante) {
        return repoComprobante.findById(idComprobante);
    }
    
    public void eliminar(Integer idComprobante) {
        repoComprobante.deleteById(idComprobante);
    }
}