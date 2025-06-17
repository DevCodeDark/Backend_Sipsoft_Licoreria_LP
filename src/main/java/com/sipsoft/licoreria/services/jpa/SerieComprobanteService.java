package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sipsoft.licoreria.entity.SerieComprobante;
import com.sipsoft.licoreria.repository.SerieComprobanteRepository;
import com.sipsoft.licoreria.services.ISerieComprobanteService;

@Service
public class SerieComprobanteService implements ISerieComprobanteService {
    @Autowired
    private SerieComprobanteRepository repoSerieComprobante;
    
    public List<SerieComprobante> bucarTodos() {
        return repoSerieComprobante.findAll();
    }
    
    public SerieComprobante guardar(SerieComprobante serieComprobante) {
        return repoSerieComprobante.save(serieComprobante);
    }
    
    public SerieComprobante modificar(SerieComprobante serieComprobante) {
        return repoSerieComprobante.save(serieComprobante);
    }
    
    public Optional<SerieComprobante> buscarId(Integer idSerie) {
        return repoSerieComprobante.findById(idSerie);
    }
    
    public void eliminar(Integer idSerie) {
        repoSerieComprobante.deleteById(idSerie);
    }
}