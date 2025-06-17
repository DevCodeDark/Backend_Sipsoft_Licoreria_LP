package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.PagosDeuda;
import com.sipsoft.licoreria.repository.PagosDeudaRepository;
import com.sipsoft.licoreria.services.IPagosDeudaService;

@Service
public class PagosDeudaService implements IPagosDeudaService {
    @Autowired
    private PagosDeudaRepository repoPagosDeuda;
    
    public List<PagosDeuda> bucarTodos() {
        return repoPagosDeuda.findAll();
    }
    
    public PagosDeuda guardar(PagosDeuda pagosDeuda) {
        return repoPagosDeuda.save(pagosDeuda);
    }
    
    public PagosDeuda modificar(PagosDeuda pagosDeuda) {
        return repoPagosDeuda.save(pagosDeuda);
    }
    
    public Optional<PagosDeuda> buscarId(Integer idPagosDeuda) {
        return repoPagosDeuda.findById(idPagosDeuda);
    }
    
    public void eliminar(Integer idPagosDeuda) {
        repoPagosDeuda.deleteById(idPagosDeuda);
    }
}
