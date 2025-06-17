package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.Lote;
import com.sipsoft.licoreria.repository.LoteRepository;
import com.sipsoft.licoreria.services.ILoteService;

@Service
public class LoteService implements ILoteService {
    @Autowired
    private LoteRepository repoLote;
    
    public List<Lote> bucarTodos() {
        return repoLote.findAll();
    }
    
    public Lote guardar(Lote lote) {
        return repoLote.save(lote);
    }
    
    public Lote modificar(Lote lote) {
        return repoLote.save(lote);
    }
    
    public Optional<Lote> buscarId(Integer idLote) {
        return repoLote.findById(idLote);
    }
    
    public void eliminar(Integer idLote) {
        repoLote.deleteById(idLote);
    }
}
