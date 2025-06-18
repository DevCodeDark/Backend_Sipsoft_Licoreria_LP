package com.sipsoft.licoreria.services.jpa;

import com.sipsoft.licoreria.entity.Registro;
import com.sipsoft.licoreria.repository.RegistroRepository;
import com.sipsoft.licoreria.security.JwtUtil;
import com.sipsoft.licoreria.services.IRegistroService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.SecretKey;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class RegistroService implements IRegistroService {
    
    private final RegistroRepository registroRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    
    public RegistroService(RegistroRepository registroRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.registroRepository = registroRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Registro> buscarTodos() {
        return registroRepository.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Registro> buscarPorId(Integer id) {
        return registroRepository.findById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Registro> buscarPorEmail(String email) {
        return registroRepository.findByEmail(email);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Registro> buscarPorAccessToken(String accessToken) {
        return registroRepository.findByAccessToken(accessToken);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Registro> buscarPorClienteId(String clienteId) {
        return registroRepository.findByClienteId(clienteId);
    }    @Override
    public Registro guardar(Registro registro) {
        // Generar clienteId con formato hash de 64 caracteres
        registro.setClienteId(generarHashHex());
        
        // Generar llave secreta basada en email+nombre+apellido y hashearla
        String llaveSecretaPlana = registro.getEmail() + registro.getNombre() + registro.getApellido();
        String llaveSecretaHasheada = passwordEncoder.encode(llaveSecretaPlana);
        registro.setLlaveSecreta(llaveSecretaHasheada);
        
        // Para la respuesta, devolver la llave SIN hashear (email+nombre+apellido)
        registro.setLlaveSecretaPlana(llaveSecretaPlana);

        return registroRepository.save(registro);
    }
    
    /**
     * Genera un hash hexadecimal de 64 caracteres usando SHA-256
     */
    private String generarHashHex() {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            SecureRandom random = new SecureRandom();
            byte[] randomBytes = new byte[32];
            random.nextBytes(randomBytes);
            byte[] hash = digest.digest(randomBytes);
            
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Fallback a UUID si hay problemas con SHA-256
            return UUID.randomUUID().toString().replace("-", "") + 
                   UUID.randomUUID().toString().replace("-", "").substring(0, 32);
        }
    }
    
    @Override
    public Registro actualizar(Registro registro) {
        return registroRepository.save(registro);
    }
    
    @Override
    public void eliminar(Integer id) {
        registroRepository.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public boolean existePorEmail(String email) {
        return registroRepository.existsByEmail(email);
    }    @Override
    public String generarToken(String clienteId, String llaveSecreta) {
        System.out.println("=== DEBUG AUTENTICACIÓN ===");
        System.out.println("ClienteId recibido: " + clienteId);
        System.out.println("LlaveSecreta recibida: " + llaveSecreta);
        
        Optional<Registro> registroOpt = registroRepository.findByClienteId(clienteId);
        if (registroOpt.isPresent()) {
            Registro registro = registroOpt.get();
            System.out.println("Registro encontrado - Email: " + registro.getEmail());
            System.out.println("Nombre: " + registro.getNombre() + ", Apellido: " + registro.getApellido());
            
            // Reconstruir la llave secreta esperada
            String llaveEsperada = registro.getEmail() + registro.getNombre() + registro.getApellido();
            System.out.println("Llave esperada: " + llaveEsperada);
            System.out.println("Llave recibida: " + llaveSecreta);
            System.out.println("Son iguales: " + llaveEsperada.equals(llaveSecreta));
            
            if (passwordEncoder.matches(llaveSecreta, registro.getLlaveSecreta())) {
                System.out.println("✓ Credenciales válidas - Generando token");
                
                // Usar JwtUtil para generar el token con la información completa
                String token = jwtUtil.generarTokenCompleto(registro.getEmail(), registro.getClienteId());
                
                registro.setAccessToken(token);
                registroRepository.save(registro);
                return token;
            } else {
                System.out.println("✗ Credenciales inválidas - Hash no coincide");
            }
        } else {
            System.out.println("✗ ClienteId no encontrado en la base de datos");
        }
        return null;
    }
}
