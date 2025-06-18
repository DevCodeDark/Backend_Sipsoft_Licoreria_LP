package com.sipsoft.licoreria.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO simple para respuesta de token")
public class TokenResponseDTO {
    
    @Schema(description = "Token de acceso JWT")
    private String accessToken;

    public TokenResponseDTO() {}

    public TokenResponseDTO(String accessToken) {
        this.accessToken = accessToken;
    }

    // Getter y Setter
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
