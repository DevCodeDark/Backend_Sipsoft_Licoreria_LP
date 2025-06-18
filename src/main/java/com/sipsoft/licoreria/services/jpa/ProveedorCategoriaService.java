package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sipsoft.licoreria.entity.ProveedorCategoria;
import com.sipsoft.licoreria.repository.ProveedorCategoriaRepository;
import com.sipsoft.licoreria.services.IProveedorCategoriaService;

@Service
public class ProveedorCategoriaService implements IProveedorCategoriaService {
    
    @Autowired
    private ProveedorCategoriaRepository repoProveedorCategoria;
    
    @Override
    public List<ProveedorCategoria> findAll() {
        return repoProveedorCategoria.findAll();
    }
    
    @Override
    public ProveedorCategoria save(ProveedorCategoria proveedorCategoria) {
        return repoProveedorCategoria.save(proveedorCategoria);
    }
    
    @Override
    public Optional<ProveedorCategoria> findById(Integer id) {
        return repoProveedorCategoria.findById(id);
    }
    
    @Override
    public void deleteById(Integer id) {
        repoProveedorCategoria.deleteById(id);
    }
}