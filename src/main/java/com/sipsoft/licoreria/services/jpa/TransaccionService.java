package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.Transaccion;
import com.sipsoft.licoreria.repository.TransaccionRepository;
import com.sipsoft.licoreria.services.ITransaccionService;

@Service
public class TransaccionService implements ITransaccionService {
    @Autowired
    private TransaccionRepository repoTransaccion;
    
    public List<Transaccion> bucarTodos() {
        return repoTransaccion.findAll();
    }
    
    public Transaccion guardar(Transaccion transaccion) {
        return repoTransaccion.save(transaccion);
    }
    
    public Transaccion modificar(Transaccion transaccion) {
        return repoTransaccion.save(transaccion);
    }
    
    public Optional<Transaccion> buscarId(Integer idTransaccion) {
        return repoTransaccion.findById(idTransaccion);
    }
    
    public void eliminar(Integer idTransaccion) {
        repoTransaccion.deleteById(idTransaccion);
    }
}
