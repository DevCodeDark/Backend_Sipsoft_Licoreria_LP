package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sipsoft.licoreria.entity.SegmentoModulo;
import com.sipsoft.licoreria.repository.SegmentoModuloRepository;
import com.sipsoft.licoreria.services.ISegmentoModuloService;

@Service
@Transactional
public class SegmentoModuloService implements ISegmentoModuloService {
    
    private final SegmentoModuloRepository segmentoModuloRepository;
    
    public SegmentoModuloService(SegmentoModuloRepository segmentoModuloRepository) {
        this.segmentoModuloRepository = segmentoModuloRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SegmentoModulo> buscarTodos() {
        return segmentoModuloRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<SegmentoModulo> buscarActivos() {
        return segmentoModuloRepository.findAllActive();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SegmentoModulo> buscarPorId(Integer id) {
        return segmentoModuloRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SegmentoModulo> buscarPorIdActivo(Integer id) {
        return segmentoModuloRepository.findByIdAndActive(id);
    }

    @Override
    public SegmentoModulo guardar(SegmentoModulo segmentoModulo) {
        if (segmentoModulo.getEstadoSegmento() == null) {
            segmentoModulo.setEstadoSegmento(1);
        }
        return segmentoModuloRepository.save(segmentoModulo);
    }

    @Override
    public SegmentoModulo actualizar(SegmentoModulo segmentoModulo) {
        return segmentoModuloRepository.save(segmentoModulo);
    }

    @Override
    public void eliminar(Integer id) {
        segmentoModuloRepository.deleteById(id);
    }

    @Override
    public void eliminarLogico(Integer id) {
        Optional<SegmentoModulo> segmentoModuloOpt = segmentoModuloRepository.findById(id);
        if (segmentoModuloOpt.isPresent()) {
            SegmentoModulo segmentoModulo = segmentoModuloOpt.get();
            segmentoModulo.setEstadoSegmento(0);
            segmentoModuloRepository.save(segmentoModulo);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SegmentoModulo> buscarPorDescripcion(String descripcion) {
        return segmentoModuloRepository.findByDescripcionIgnoreCaseAndActive(descripcion);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SegmentoModulo> buscarPorDescripcionContiene(String descripcion) {
        return segmentoModuloRepository.findByDescripcionContainingIgnoreCaseAndActive(descripcion);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existePorDescripcion(String descripcion) {
        return segmentoModuloRepository.findByDescripcionIgnoreCaseAndActive(descripcion).isPresent();
    }

    @Override
    @Transactional(readOnly = true)
    public List<SegmentoModulo> buscarActivosConModulos() {
        return segmentoModuloRepository.findAllActiveWithActiveModulos();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SegmentoModulo> buscarPorIdActivoConModulos(Integer id) {
        return segmentoModuloRepository.findByIdActiveWithActiveModulos(id);
    }
}
