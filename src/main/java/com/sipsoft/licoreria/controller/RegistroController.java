package com.sipsoft.licoreria.controller;

import com.sipsoft.licoreria.dto.AuthRequest;
import com.sipsoft.licoreria.dto.TokenResponseDTO;
import com.sipsoft.licoreria.dto.RegistroDTO;
import com.sipsoft.licoreria.dto.RegistroCompletoResponseDTO;
import com.sipsoft.licoreria.entity.Registro;
import com.sipsoft.licoreria.services.IRegistroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sipsoft")
@Tag(name = "Autenticación", description = "Registro de clientes y obtención de token de acceso")
public class RegistroController {
    
    private final IRegistroService registroService;
    
    public RegistroController(IRegistroService registroService) {
        this.registroService = registroService;
    }
    
    @PostMapping("/registros")
    @Operation(summary = "Registrar un nuevo cliente", 
               description = "Crea un nuevo registro de cliente y devuelve el clienteId y la llaveSecreta generados.")    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cliente registrado exitosamente",
                    content = @Content(schema = @Schema(implementation = RegistroCompletoResponseDTO.class))),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
        @ApiResponse(responseCode = "409", description = "El email ya está registrado")
    })
    public ResponseEntity<Object> crear(@RequestBody RegistroDTO dto) {
        if (registroService.existePorEmail(dto.getEmail())) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "El email ya está registrado");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
        }
        
        Registro registro = new Registro();
        registro.setEmail(dto.getEmail());
        registro.setNombre(dto.getNombre());
        registro.setApellido(dto.getApellido());        Registro registroGuardado = registroService.guardar(registro);
        
        RegistroCompletoResponseDTO response = new RegistroCompletoResponseDTO(
            registroGuardado.getEmail(),
            registroGuardado.getNombre(),
            registroGuardado.getApellido(),
            "", // accessToken vacío al registrarse
            registroGuardado.getClienteId(), 
            registroGuardado.getLlaveSecreta() // Devolver el hash en lugar del texto plano
        );
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/token")
    @Operation(summary = "Obtener token de acceso", 
               description = "Autentica al cliente con su clienteId y llaveSecreta para obtener un token de acceso (JWT).")    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Token generado exitosamente",
                    content = @Content(schema = @Schema(implementation = TokenResponseDTO.class))),
        @ApiResponse(responseCode = "401", description = "Credenciales inválidas")
    })
    public ResponseEntity<Object> generarToken(@RequestBody AuthRequest request) {
        String token = registroService.generarToken(request.getClienteId(), request.getLlaveSecreta());
        
        if (token != null) {
            return ResponseEntity.ok(new TokenResponseDTO(token));
        }
        
        Map<String, String> error = new HashMap<>();
        error.put("error", "Credenciales inválidas");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }
}
