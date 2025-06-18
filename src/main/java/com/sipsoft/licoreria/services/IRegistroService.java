package com.sipsoft.licoreria.services;

import com.sipsoft.licoreria.entity.Registro;
import java.util.List;
import java.util.Optional;

public interface IRegistroService {
    
    List<Registro> buscarTodos();
    
    Optional<Registro> buscarPorId(Integer id);
    
    Optional<Registro> buscarPorEmail(String email);
    
    Optional<Registro> buscarPorAccessToken(String accessToken);
    
    Optional<Registro> buscarPorClienteId(String clienteId);
    
    Registro guardar(Registro registro);
    
    Registro actualizar(Registro registro);
    
    void eliminar(Integer id);
    
    boolean existePorEmail(String email);

    String generarToken(String clienteId, String llaveSecreta);
}
