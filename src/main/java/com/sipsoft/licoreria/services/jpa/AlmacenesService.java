package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.Almacen;
import com.sipsoft.licoreria.repository.AlmacenesRepository;
import com.sipsoft.licoreria.services.IAlmacenesService;

@Service
public class AlmacenesService implements IAlmacenesService {
    @Autowired
    private AlmacenesRepository repoAlmacenes;
    public List<Almacen> bucarTodos() {
        return repoAlmacenes.findAll();
    }
    //AQUI
    public Almacen guardar(Almacen almacen) {
       return repoAlmacenes.save(almacen);
    }
    //AQUI
    public Almacen modificar(Almacen almacen) {
        return repoAlmacenes.save(almacen);
    }
    public Optional<Almacen> buscarId(Integer idAlmacen) {
        return repoAlmacenes.findById(idAlmacen);
    }
    public void eliminar(Integer idAlmacen) {
        repoAlmacenes.deleteById(idAlmacen);
    }
}
