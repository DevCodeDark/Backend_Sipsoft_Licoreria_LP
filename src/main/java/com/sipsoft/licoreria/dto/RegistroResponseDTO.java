package com.sipsoft.licoreria.dto;

public class RegistroResponseDTO {
    private String clienteId;
    private String llaveSecreta;

    public RegistroResponseDTO(String clienteId, String llaveSecreta) {
        this.clienteId = clienteId;
        this.llaveSecreta = llaveSecreta;
    }

    // Getters y Setters
    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getLlaveSecreta() {
        return llaveSecreta;
    }

    public void setLlaveSecreta(String llaveSecreta) {
        this.llaveSecreta = llaveSecreta;
    }
}
