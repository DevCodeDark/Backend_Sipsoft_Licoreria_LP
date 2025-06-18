package com.sipsoft.licoreria.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "API Licorería SipSoft",
        version = "1.0.0",
        description = """
                API REST para el sistema de gestión de licorerías.
                Esta API permite gestionar todos los aspectos de una licorería incluyendo:
                inventario, ventas, compras, proveedores, clientes y más.
                
                Para autenticarte, obtén un token desde el endpoint de autenticación
                y úsalo en el botón 'Authorize' con el formato: Bearer {token}
                """,
        contact = @Contact(
            name = "SipSoft - Soporte Técnico",
            email = "soporte@sipsoft.com",
            url = "https://sipsoft.com"
        ),
        license = @License(
            name = "MIT License",
            url = "https://opensource.org/licenses/MIT"
        )
    ),
    servers = {
        @Server(url = "http://localhost:8080", description = "Servidor Local"),
        @Server(url = "http://sipsoft.spring.informaticapp.com:2001", description = "Servidor de Producción")
    }
)
@SecurityScheme(
    name = "bearerAuth",
    description = "Token JWT para autenticación",
    scheme = "bearer",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    in = SecuritySchemeIn.HEADER
)
public class SwaggerConfig {
    // Esta clase solo contiene las anotaciones de configuración
    // No necesita métodos adicionales
}
