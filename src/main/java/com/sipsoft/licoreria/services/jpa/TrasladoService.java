package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sipsoft.licoreria.entity.Traslado;
import com.sipsoft.licoreria.repository.TrasladoRepository;
import com.sipsoft.licoreria.services.ITrasladoService;

@Service
public class TrasladoService implements ITrasladoService {
    @Autowired
    private TrasladoRepository repoTraslado;
    
    public List<Traslado> bucarTodos() {
        return repoTraslado.findAll();
    }
    
    public Traslado guardar(Traslado traslado) {
        return repoTraslado.save(traslado);
    }
    
    public Traslado modificar(Traslado traslado) {
        return repoTraslado.save(traslado);
    }
    
    public Optional<Traslado> buscarId(Integer idTraslado) {
        return repoTraslado.findById(idTraslado);
    }
    
    public void eliminar(Integer idTraslado) {
        repoTraslado.deleteById(idTraslado);
    }
}