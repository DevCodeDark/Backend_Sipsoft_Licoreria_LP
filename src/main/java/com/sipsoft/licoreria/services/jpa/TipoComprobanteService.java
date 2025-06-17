package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.TipoComprobante;
import com.sipsoft.licoreria.repository.TipoComprobanteRepository;
import com.sipsoft.licoreria.services.ITipoComprobanteService;

@Service
public class TipoComprobanteService implements ITipoComprobanteService {
    @Autowired
    private TipoComprobanteRepository repoTipoComprobante;
    
    public List<TipoComprobante> bucarTodos() {
        return repoTipoComprobante.findAll();
    }
    
    public void guardar(TipoComprobante tipoComprobante) {
        repoTipoComprobante.save(tipoComprobante);
    }
    
    public void modificar(TipoComprobante tipoComprobante) {
        repoTipoComprobante.save(tipoComprobante);
    }
    
    public Optional<TipoComprobante> buscarId(Integer idTipoComprobante) {
        return repoTipoComprobante.findById(idTipoComprobante);
    }
    
    public void eliminar(Integer idTipoComprobante) {
        repoTipoComprobante.deleteById(idTipoComprobante);
    }
}
