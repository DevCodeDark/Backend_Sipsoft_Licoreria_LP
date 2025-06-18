package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sipsoft.licoreria.entity.TipoRol;
import com.sipsoft.licoreria.repository.TipoRolRepository;
import com.sipsoft.licoreria.services.ITipoRolService;

@Service
@Transactional
public class TipoRolService implements ITipoRolService {
    
    private final TipoRolRepository tipoRolRepository;
    
    public TipoRolService(TipoRolRepository tipoRolRepository) {
        this.tipoRolRepository = tipoRolRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoRol> buscarTodos() {
        return tipoRolRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoRol> buscarActivos() {
        return tipoRolRepository.findAllActive();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoRol> buscarPorId(Integer id) {
        return tipoRolRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoRol> buscarPorIdActivo(Integer id) {
        return tipoRolRepository.findByIdAndActive(id);
    }

    @Override
    public TipoRol guardar(TipoRol tipoRol) {
        if (tipoRol.getEstadoTipoRol() == null) {
            tipoRol.setEstadoTipoRol(1);
        }
        return tipoRolRepository.save(tipoRol);
    }

    @Override
    public TipoRol actualizar(TipoRol tipoRol) {
        return tipoRolRepository.save(tipoRol);
    }

    @Override
    public void eliminar(Integer id) {
        tipoRolRepository.deleteById(id);
    }

    @Override
    public void eliminarLogico(Integer id) {
        Optional<TipoRol> tipoRolOpt = tipoRolRepository.findById(id);
        if (tipoRolOpt.isPresent()) {
            TipoRol tipoRol = tipoRolOpt.get();
            tipoRol.setEstadoTipoRol(0);
            tipoRolRepository.save(tipoRol);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoRol> buscarPorNombre(String tipoRol) {
        return tipoRolRepository.findByTipoRolIgnoreCaseAndActive(tipoRol);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoRol> buscarPorNombreContiene(String tipoRol) {
        return tipoRolRepository.findByTipoRolContainingIgnoreCaseAndActive(tipoRol);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existePorNombre(String tipoRol) {
        return tipoRolRepository.findByTipoRolIgnoreCaseAndActive(tipoRol).isPresent();
    }
}
