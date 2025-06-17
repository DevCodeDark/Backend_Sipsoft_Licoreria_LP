package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.Sucursal;
import com.sipsoft.licoreria.repository.SucursalRepository;
import com.sipsoft.licoreria.services.ISucursalService;

@Service
public class SucursalService implements ISucursalService {
    @Autowired
    private SucursalRepository repoSucursal;
    
    public List<Sucursal> bucarTodos() {
        return repoSucursal.findAll();
    }
    
    public Sucursal guardar(Sucursal sucursal) {
        return repoSucursal.save(sucursal);
    }
    
    public Sucursal modificar(Sucursal sucursal) {
        return repoSucursal.save(sucursal);
    }
    
    public Optional<Sucursal> buscarId(Integer idSucursal) {
        return repoSucursal.findById(idSucursal);
    }
    
    public void eliminar(Integer idSucursal) {
        repoSucursal.deleteById(idSucursal);
    }
}
