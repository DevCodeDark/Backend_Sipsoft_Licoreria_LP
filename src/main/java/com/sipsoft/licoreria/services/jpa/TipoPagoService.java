package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.TipoPago;
import com.sipsoft.licoreria.repository.TipoPagoRepository;
import com.sipsoft.licoreria.services.ITipoPagoService;

@Service
public class TipoPagoService implements ITipoPagoService {
    @Autowired
    private TipoPagoRepository repoTipoPago;
    
    public List<TipoPago> bucarTodos() {
        return repoTipoPago.findAll();
    }
    
    public TipoPago guardar(TipoPago tipoPago) {
        return repoTipoPago.save(tipoPago);
    }
    
    public TipoPago modificar(TipoPago tipoPago) {
        return repoTipoPago.save(tipoPago);
    }
    
    public Optional<TipoPago> buscarId(Integer idTipoPago) {
        return repoTipoPago.findById(idTipoPago);
    }
    
    public void eliminar(Integer idTipoPago) {
        repoTipoPago.deleteById(idTipoPago);
    }
}
