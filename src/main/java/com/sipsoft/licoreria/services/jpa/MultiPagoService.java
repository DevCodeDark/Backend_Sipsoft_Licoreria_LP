package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sipsoft.licoreria.entity.MultiPago;
import com.sipsoft.licoreria.repository.MultiPagoRepository;
import com.sipsoft.licoreria.services.IMultiPagoService;

@Service
public class MultiPagoService implements IMultiPagoService {
    @Autowired
    private MultiPagoRepository repoMultiPago;
    
    public List<MultiPago> bucarTodos() {
        return repoMultiPago.findAll();
    }
    
    public MultiPago guardar(MultiPago multiPago) {
        return repoMultiPago.save(multiPago);
    }
    
    public MultiPago modificar(MultiPago multiPago) {
        return repoMultiPago.save(multiPago);
    }
    
    public Optional<MultiPago> buscarId(Integer idMultiPago) {
        return repoMultiPago.findById(idMultiPago);
    }
    
    public void eliminar(Integer idMultiPago) {
        repoMultiPago.deleteById(idMultiPago);
    }
}