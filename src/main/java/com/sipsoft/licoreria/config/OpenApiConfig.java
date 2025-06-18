package com.sipsoft.licoreria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;

import java.util.Arrays;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "bearerAuth";
        
        return new OpenAPI()
                .addServersItem(new Server().url("http://sipsoft.spring.informaticapp.com:2000").description("Servidor de Producción"))
                .addServersItem(new Server().url("http://localhost:8080").description("Servidor Local"))                .info(new Info()
                        .title("API Licorería SipSoft")
                        .description("""
                                   API REST para el sistema de gestión de licorerías.
                                   Esta API permite gestionar todos los aspectos de una licorería incluyendo:
                                   inventario, ventas, compras, proveedores, clientes y más.
                                   
                                   **Autenticación:** Para autenticarte, primero obtén un token desde el endpoint
                                   `/sipsoft/token` y luego úsalo en el botón 'Authorize' con el formato: `Bearer tu_token_aquí`
                                   """)
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("SipSoft - Soporte Técnico")
                                .email("soporte@sipsoft.com")
                                .url("https://sipsoft.com"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")))
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name(securitySchemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .description("Token JWT para autenticación. Formato: Bearer {token}")))
                .tags(Arrays.asList(
                    new Tag().name("Autenticación").description("Endpoints para autenticación y autorización"),
                    new Tag().name("Almacén").description("Gestión de almacenes y ubicaciones"),
                    new Tag().name("Productos").description("Gestión de productos e inventario"),
                    new Tag().name("Categorías").description("Gestión de categorías de productos"),
                    new Tag().name("Ventas").description("Gestión de ventas y facturación"),
                    new Tag().name("Compras").description("Gestión de compras y órdenes de compra"),
                    new Tag().name("Proveedores").description("Gestión de proveedores y contratos"),
                    new Tag().name("Clientes").description("Gestión de clientes"),
                    new Tag().name("Usuarios").description("Gestión de usuarios del sistema"),
                    new Tag().name("Roles y Permisos").description("Gestión de roles y permisos"),
                    new Tag().name("Empresa").description("Configuración de la empresa"),
                    new Tag().name("Sucursales").description("Gestión de sucursales"),
                    new Tag().name("Reportes").description("Reportes y estadísticas"),
                    new Tag().name("Configuración").description("Configuraciones del sistema")
                ));
    }
}
