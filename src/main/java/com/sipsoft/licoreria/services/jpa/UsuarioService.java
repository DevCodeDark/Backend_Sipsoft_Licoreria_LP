package com.sipsoft.licoreria.services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipsoft.licoreria.entity.Usuario;
import com.sipsoft.licoreria.repository.UsuarioRepository;
import com.sipsoft.licoreria.services.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    private UsuarioRepository repoUsuario;
    
    public List<Usuario> bucarTodos() {
        return repoUsuario.findAll();
    }
    
    public Usuario guardar(Usuario usuario) {
        return repoUsuario.save(usuario);
    }
    
    public Usuario modificar(Usuario usuario) {
        return repoUsuario.save(usuario);
    }
    
    public Optional<Usuario> buscarId(Integer idUsuario) {
        return repoUsuario.findById(idUsuario);
    }
    
    public void eliminar(Integer idUsuario) {
        repoUsuario.deleteById(idUsuario);
    }
}