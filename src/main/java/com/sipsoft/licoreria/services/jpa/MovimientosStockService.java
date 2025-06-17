package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.MovimientosStock;
import com.sipsoft.licoreria.repository.MovimientosStockRepository;
import com.sipsoft.licoreria.services.IMovimientosStockService;

@Service
public class MovimientosStockService implements IMovimientosStockService {
    @Autowired
    private MovimientosStockRepository repoMovimientosStock;
    
    public List<MovimientosStock> bucarTodos() {
        return repoMovimientosStock.findAll();
    }
    
    public MovimientosStock guardar(MovimientosStock movimientosStock) {
        return repoMovimientosStock.save(movimientosStock);
    }
    
    public MovimientosStock modificar(MovimientosStock movimientosStock) {
        return repoMovimientosStock.save(movimientosStock);
    }
    
    public Optional<MovimientosStock> buscarId(Integer idMovimientoStock) {
        return repoMovimientosStock.findById(idMovimientoStock);
    }
    
    public void eliminar(Integer idMovimientoStock) {
        repoMovimientosStock.deleteById(idMovimientoStock);
    }
}
