package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.UnidadMedida;
import com.sipsoft.licoreria.repository.UnidadMedidaRepository;
import com.sipsoft.licoreria.services.IUnidadMedidaService;

@Service
public class UnidadMedidaService implements IUnidadMedidaService {
    @Autowired
    private UnidadMedidaRepository repoUnidadMedida;
    
    public List<UnidadMedida> bucarTodos() {
        return repoUnidadMedida.findAll();
    }
    
    public UnidadMedida guardar(UnidadMedida unidadMedida) {
        return repoUnidadMedida.save(unidadMedida);
    }
    
    public UnidadMedida modificar(UnidadMedida unidadMedida) {
        return repoUnidadMedida.save(unidadMedida);
    }
    
    public Optional<UnidadMedida> buscarId(Integer idUnidadMedida) {
        return repoUnidadMedida.findById(idUnidadMedida);
    }
    
    public void eliminar(Integer idUnidadMedida) {
        repoUnidadMedida.deleteById(idUnidadMedida);
    }
}
