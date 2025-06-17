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

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "bearerAuth";
        
        return new OpenAPI()
                .addServersItem(new Server().url("http://sipsoft.spring.informaticapp.com:2000").description("Servidor de Producción"))
                .addServersItem(new Server().url("http://localhost:2000").description("Servidor Local"))
                .info(new Info()
                        .title("API Licorería SipSoft")
                        .description("API REST para el sistema de gestión de licorerías. Para autenticarte, primero obtén un token desde el endpoint /sipsoft/token y luego úsalo en el botón 'Authorize' con el formato: Bearer tu_token_aquí")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("SipSoft")
                                .email("soporte@sipsoft.com"))
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
                                .description("Ingresa tu token JWT aquí. Formato: Bearer tu_token_aquí")));
    }
}
