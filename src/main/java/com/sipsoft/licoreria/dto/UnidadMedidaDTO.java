package com.sipsoft.licoreria.dto;

public class UnidadMedidaDTO {
    private Integer idUnidadMedida;
    private String nombreUnidadMedida;
    private String abreviaturaUnidadMedida;
    private Integer estadoUnidadMedida = 1;
    private Integer idEmpresa;

    public Integer getIdUnidadMedida() { return idUnidadMedida; }
    public void setIdUnidadMedida(Integer idUnidadMedida) { this.idUnidadMedida = idUnidadMedida; }
    public String getNombreUnidadMedida() { return nombreUnidadMedida; }
    public void setNombreUnidadMedida(String nombreUnidadMedida) { this.nombreUnidadMedida = nombreUnidadMedida; }
    public String getAbreviaturaUnidadMedida() { return abreviaturaUnidadMedida; }
    public void setAbreviaturaUnidadMedida(String abreviaturaUnidadMedida) { this.abreviaturaUnidadMedida = abreviaturaUnidadMedida; }
    public Integer getEstadoUnidadMedida() { return estadoUnidadMedida; }
    public void setEstadoUnidadMedida(Integer estadoUnidadMedida) { this.estadoUnidadMedida = estadoUnidadMedida; }
    public Integer getIdEmpresa() { return idEmpresa; }
    public void setIdEmpresa(Integer idEmpresa) { this.idEmpresa = idEmpresa; }

    @Override
    public String toString() {
        return "UnidadMedidaDTO [idUnidadMedida=" + idUnidadMedida + ", nombreUnidadMedida=" + nombreUnidadMedida
                + ", abreviaturaUnidadMedida=" + abreviaturaUnidadMedida + ", estadoUnidadMedida=" + estadoUnidadMedida
                + ", idEmpresa=" + idEmpresa + "]";
    }
}
