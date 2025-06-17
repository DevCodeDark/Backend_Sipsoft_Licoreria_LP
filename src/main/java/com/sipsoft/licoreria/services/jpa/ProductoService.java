package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.Producto;
import com.sipsoft.licoreria.repository.ProductoRepository;
import com.sipsoft.licoreria.services.IProductoService;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private ProductoRepository repoProducto;
    
    public List<Producto> bucarTodos() {
        return repoProducto.findAll();
    }
    
    public Producto guardar(Producto producto) {
        return repoProducto.save(producto);
    }
    
    public Producto modificar(Producto producto) {
        return repoProducto.save(producto);
    }
    
    public Optional<Producto> buscarId(Integer idProducto) {
        return repoProducto.findById(idProducto);
    }
    
    public void eliminar(Integer idProducto) {
        repoProducto.deleteById(idProducto);
    }
}
