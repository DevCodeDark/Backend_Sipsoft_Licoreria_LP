package com.sipsoft.licoreria.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipsoft.licoreria.dto.UsuarioDTO;
import com.sipsoft.licoreria.entity.Usuario;
import com.sipsoft.licoreria.security.JwtUtil;
import com.sipsoft.licoreria.services.IUsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/sipsoft")
@Tag(name = "Autenticación y Usuarios", description = "Endpoints para la gestión de usuarios y la obtención de tokens de acceso.")
public class UsuarioController {
    @Autowired
    private IUsuarioService serviceUsuario;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;    @GetMapping("/usuarios")
    @Operation(summary = "Obtener todos los usuarios", security = @SecurityRequirement(name = "bearerAuth"))
    public List<Usuario> buscarTodos() {
        return serviceUsuario.bucarTodos();
    }
      /**
     * Endpoint para crear un nuevo usuario.
     * @param usuarioDto DTO con la información del usuario a crear.
     * @return El usuario creado con sus credenciales generadas.
     */
    @PostMapping("/usuarios")
    @Operation(summary = "Crear un nuevo usuario", security = @SecurityRequirement(name = "bearerAuth"))
    public Usuario guardar(@RequestBody UsuarioDTO usuarioDto) {
        Usuario usuario = new Usuario();
        
        // Mapeo de campos desde el DTO
        usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
        usuario.setApellidoUsuario(usuarioDto.getApellidoUsuario());
        usuario.setTelefonoUsuario(usuarioDto.getTelefonoUsuario());
        usuario.setDniUsuario(usuarioDto.getDniUsuario());
        usuario.setEmailUsuario(usuarioDto.getEmailUsuario());
        usuario.setIdRol(usuarioDto.getIdRol());
        usuario.setIdEmpresa(usuarioDto.getIdEmpresa());

        // Cifrar la contraseña
        if (usuarioDto.getContrasenaUsuario() != null && !usuarioDto.getContrasenaUsuario().isEmpty()) {
            usuario.setContrasenaUsuario(passwordEncoder.encode(usuarioDto.getContrasenaUsuario()));
        }

        // Generar credenciales (clienteId, llaveSecreta, accessToken)
        String claveOriginal = usuarioDto.getEmailUsuario() + usuarioDto.getNombreUsuario() + usuarioDto.getApellidoUsuario();
        usuario.generarCredenciales(claveOriginal);
        
        // Establecer estado por defecto
        usuario.setEstadoUsuario(1);

        return serviceUsuario.guardar(usuario);
    }    /**
     * Endpoint para modificar un usuario existente.
     * @param usuarioDto DTO con la información a actualizar.
     * @return El usuario modificado o un mensaje de error si no se encuentra.
     */
    @PutMapping("/usuarios")
    @Operation(summary = "Modificar un usuario existente", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<?> modificar(@RequestBody UsuarioDTO usuarioDto) {
        if (usuarioDto.getIdUsuario() == null) {
            return ResponseEntity.badRequest().body("El idUsuario es requerido para modificar.");
        }
        
        Optional<Usuario> usuarioOpt = serviceUsuario.buscarId(usuarioDto.getIdUsuario());
        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("No se encontró el Usuario con ID: " + usuarioDto.getIdUsuario());
        }

        Usuario usuarioExistente = usuarioOpt.get();

        // Mapeo de campos desde el DTO
        usuarioExistente.setNombreUsuario(usuarioDto.getNombreUsuario());
        usuarioExistente.setApellidoUsuario(usuarioDto.getApellidoUsuario());
        usuarioExistente.setTelefonoUsuario(usuarioDto.getTelefonoUsuario());
        usuarioExistente.setDniUsuario(usuarioDto.getDniUsuario());
        usuarioExistente.setEmailUsuario(usuarioDto.getEmailUsuario());
        usuarioExistente.setIdRol(usuarioDto.getIdRol());
        usuarioExistente.setIdEmpresa(usuarioDto.getIdEmpresa());

        // Actualizar contraseña solo si se proporciona una nueva
        if (usuarioDto.getContrasenaUsuario() != null && !usuarioDto.getContrasenaUsuario().isEmpty()) {
            usuarioExistente.setContrasenaUsuario(passwordEncoder.encode(usuarioDto.getContrasenaUsuario()));
        }
        
        Usuario usuarioModificado = serviceUsuario.modificar(usuarioExistente);
        return ResponseEntity.ok(usuarioModificado);
    }    @GetMapping("/usuarios/{idUsuario}")
    @Operation(summary = "Buscar usuario por ID", security = @SecurityRequirement(name = "bearerAuth"))
    public Optional<Usuario> buscarId(@PathVariable("idUsuario") Integer idUsuario) {
        return serviceUsuario.buscarId(idUsuario);
    }

    @DeleteMapping("/usuarios/{idUsuario}")
    @Operation(summary = "Eliminar usuario por ID", security = @SecurityRequirement(name = "bearerAuth"))
    public String eliminar(@PathVariable Integer idUsuario){
        serviceUsuario.eliminar(idUsuario);
        return "Usuario eliminado";
    }
        // --- ANOTACIÓN ACTUALIZADA ---
    @Operation(
        summary = "Genera un Token de Autenticación (JWT)",
        description = "Este endpoint autentica a un usuario y devuelve un token JWT para ser usado en las cabeceras de las demás peticiones. \n\n" +
                      "**Para obtener un token, se deben seguir los siguientes pasos:**\n" +
                      "1. **Crear una Empresa:** Realizar un `POST` a `/sipsoft/empresas`.\n" +
                      "2. **Crear un Rol:** Realizar un `POST` a `/sipsoft/roles`, asociándolo al `idEmpresa` recién creado.\n" +
                      "3. **Crear un Usuario:** Realizar un `POST` a `/sipsoft/usuarios`, asociándolo al `idRol` y `idEmpresa` correspondientes. El sistema generará automáticamente un `cliente_id` y una `llave_secreta`.\n" +
                      "4. **Solicitar el Token:** Usar el `cliente_id` y la `llave_secreta` generados en el paso anterior para hacer `POST` a este endpoint y obtener el token.",
        // Se añade la definición del Request Body
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Credenciales del usuario para la generación del token.",
            required = true,
            content = @Content(
                mediaType = "application/json",
                // Se define el esquema del JSON
                schema = @Schema(
                    type = "object",
                    example = "{\"cliente_id\": \"string\", \"llave_secreta\": \"string\"}"
                ),
                // Se provee un ejemplo claro
                examples = {
                    @ExampleObject(
                        name = "Ejemplo de Petición",
                        summary = "Formato del cuerpo de la solicitud",
                        value = "{\n  \"cliente_id\": \"5f4e3d2c1b0a...\",\n  \"llave_secreta\": \"...\"\n}"
                    )
                }
            )
        )
    )
    
    @PostMapping("/token")
    public ResponseEntity<?> obtenerToken(@RequestBody Map<String, String> credenciales) {
        String clienteId = credenciales.get("cliente_id");
        String llaveSecreta = credenciales.get("llave_secreta");
        
        Optional<Usuario> user = serviceUsuario.bucarTodos().stream()
            .filter(u -> u.getClienteId().equals(clienteId))
            .findFirst();
            
        if (user.isPresent() && passwordEncoder.matches(llaveSecreta, user.get().getLlaveSecreta())) {
            String token = jwtUtil.generarToken(clienteId);

            Usuario usuario = user.get();
            usuario.setAccessToken(token);
            serviceUsuario.guardar(usuario);

            return ResponseEntity.ok(Collections.singletonMap("token", token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
    }
}