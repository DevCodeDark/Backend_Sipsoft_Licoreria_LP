package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.Categoria;
import com.sipsoft.licoreria.repository.CategoriaRepository;
import com.sipsoft.licoreria.services.ICategoriaService;

@Service
public class CategoriaService implements ICategoriaService {
    @Autowired
    private CategoriaRepository repoCategoria;
    
    public List<Categoria> bucarTodos() {
        return repoCategoria.findAll();
    }
    
    public Categoria guardar(Categoria categoria) {
        return repoCategoria.save(categoria);
    }
    
    public Categoria modificar(Categoria categoria) {
        return repoCategoria.save(categoria);
    }
    
    public Optional<Categoria> buscarId(Integer idCategoria) {
        return repoCategoria.findById(idCategoria);
    }
    
    public void eliminar(Integer idCategoria) {
        repoCategoria.deleteById(idCategoria);
    }
}
