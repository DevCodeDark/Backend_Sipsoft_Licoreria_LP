package com.sipsoft.licoreria.controller;

import com.sipsoft.licoreria.dto.AuthRequest;
import com.sipsoft.licoreria.dto.TokenResponseDTO;
import com.sipsoft.licoreria.dto.RegistroDTO;
import com.sipsoft.licoreria.dto.RegistroCompletoResponseDTO;
import com.sipsoft.licoreria.dto.RegistroResponseDTO;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/sipsoft")
@Transactional(readOnly = true)
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
            registroGuardado.getClienteId(), 
            registroGuardado.getLlaveSecreta() // Devolver la llave secreta solo al registrarse
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
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);    }
      @GetMapping("/registros")
    @Operation(summary = "Obtener todos los registros", 
               description = "Devuelve una lista de todos los registros de clientes sin información sensible.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de registros obtenida exitosamente",
                    content = @Content(schema = @Schema(implementation = RegistroResponseDTO.class))),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })    public ResponseEntity<List<RegistroResponseDTO>> obtenerTodos() {
        List<Registro> registros = registroService.buscarTodos();
        List<RegistroResponseDTO> response = registros.stream().map(registro -> 
            new RegistroResponseDTO(
                registro.getIdRegistro(),
                registro.getEmail(),
                registro.getNombre(),
                registro.getApellido(),
                registro.getClienteId(),
                registro.getLlaveSecreta()
            )
        ).toList();
          return ResponseEntity.ok(response);
    }
    
    @GetMapping("/registros/{id}")
    @Operation(summary = "Obtener registro por ID", 
               description = "Devuelve un registro específico por su ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Registro encontrado exitosamente",
                    content = @Content(schema = @Schema(implementation = RegistroResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "Registro no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<Object> obtenerPorId(@PathVariable Integer id) {
        Optional<Registro> registroOpt = registroService.buscarPorId(id);
        
        if (registroOpt.isEmpty()) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Registro no encontrado con ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        
        Registro registro = registroOpt.get();
        RegistroResponseDTO response = new RegistroResponseDTO(
            registro.getIdRegistro(),
            registro.getEmail(),
            registro.getNombre(),
            registro.getApellido(),
            registro.getClienteId(),
            registro.getLlaveSecreta()
        );
        
        return ResponseEntity.ok(response);
    }
    
    @PutMapping("/registros/{id}")
    @Operation(summary = "Actualizar registro", 
               description = "Actualiza los datos de un registro existente.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Registro actualizado exitosamente",
                    content = @Content(schema = @Schema(implementation = RegistroResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "Registro no encontrado"),
        @ApiResponse(responseCode = "409", description = "El email ya está registrado por otro usuario"),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    })
    public ResponseEntity<Object> actualizar(@PathVariable Integer id, @RequestBody RegistroDTO dto) {
        Optional<Registro> registroOpt = registroService.buscarPorId(id);
        
        if (registroOpt.isEmpty()) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Registro no encontrado con ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        
        // Verificar si el email ya existe en otro registro
        Optional<Registro> emailExistente = registroService.buscarPorEmail(dto.getEmail());
        if (emailExistente.isPresent() && !emailExistente.get().getIdRegistro().equals(id)) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "El email ya está registrado por otro usuario");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
        }
          Registro registro = registroOpt.get();
        registro.setEmail(dto.getEmail());
        registro.setNombre(dto.getNombre());
        registro.setApellido(dto.getApellido());
        
        Registro registroActualizado = registroService.actualizar(registro);
        
        RegistroResponseDTO response = new RegistroResponseDTO(
            registroActualizado.getIdRegistro(),
            registroActualizado.getEmail(),
            registroActualizado.getNombre(),
            registroActualizado.getApellido(),
            registroActualizado.getClienteId(),
            registroActualizado.getLlaveSecreta()
        );
        
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/registros/{id}")
    @Operation(summary = "Eliminar registro", 
               description = "Elimina un registro por su ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Registro eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Registro no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<Object> eliminar(@PathVariable Integer id) {
        Optional<Registro> registroOpt = registroService.buscarPorId(id);
        
        if (registroOpt.isEmpty()) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Registro no encontrado con ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        
        registroService.eliminar(id);
        
        Map<String, String> response = new HashMap<>();
        response.put("message", "Registro eliminado exitosamente");
        return ResponseEntity.ok(response);
    }
}
