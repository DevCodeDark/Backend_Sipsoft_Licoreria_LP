package com.sipsoft.licoreria.entity;

import java.time.LocalDate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedor")
@SQLDelete(sql = "UPDATE proveedor SET estadoProveedor = 0 WHERE idProveedor = ?")
@Where(clause = "estadoProveedor = 1")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProveedor;
    private String rucProveedor;
    private String nombreProveedor;
    private String telefonoMovilProveedor;
    private String emailProveedor;
    private String logoProveedor;
    private String direccionProveedor;
    private Integer estadoProveedor = 1;
    private String telefonoFijoProveedor;
    private String numeroContactoProveedor;
    private LocalDate fechaRegistroProveedor;
    private Integer idEmpresa;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpresa", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empresa empresa;

    public Proveedor() {
    }
    
    public Proveedor(Integer id){
        this.idProveedor = id;
    }

    // Getters y Setters
    public Integer getIdProveedor() {
        return idProveedor;
    }
    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }
    public String getRucProveedor() {
        return rucProveedor;
    }
    public void setRucProveedor(String rucProveedor) {
        this.rucProveedor = rucProveedor;
    }
    public String getNombreProveedor() {
        return nombreProveedor;
    }
    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }
    public String getTelefonoMovilProveedor() {
        return telefonoMovilProveedor;
    }
    public void setTelefonoMovilProveedor(String telefonoMovilProveedor) {
        this.telefonoMovilProveedor = telefonoMovilProveedor;
    }
    public String getEmailProveedor() {
        return emailProveedor;
    }
    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }
    public String getLogoProveedor() {
        return logoProveedor;
    }
    public void setLogoProveedor(String logoProveedor) {
        this.logoProveedor = logoProveedor;
    }
    public String getDireccionProveedor() {
        return direccionProveedor;
    }
    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }
    public Integer getEstadoProveedor() {
        return estadoProveedor;
    }
    public void setEstadoProveedor(Integer estadoProveedor) {
        this.estadoProveedor = estadoProveedor;
    }
    public String getTelefonoFijoProveedor() {
        return telefonoFijoProveedor;
    }
    public void setTelefonoFijoProveedor(String telefonoFijoProveedor) {
        this.telefonoFijoProveedor = telefonoFijoProveedor;
    }
    public String getNumeroContactoProveedor() {
        return numeroContactoProveedor;
    }
    public void setNumeroContactoProveedor(String numeroContactoProveedor) {
        this.numeroContactoProveedor = numeroContactoProveedor;
    }
    public LocalDate getFechaRegistroProveedor() {
        return fechaRegistroProveedor;
    }
    public void setFechaRegistroProveedor(LocalDate fechaRegistroProveedor) {
        this.fechaRegistroProveedor = fechaRegistroProveedor;
    }
    public Empresa getEmpresa() {
        return empresa;
    }
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }
    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public String toString() {
        return "Proveedor [idProveedor=" + idProveedor + ", rucProveedor=" + rucProveedor + ", nombreProveedor="
                + nombreProveedor + ", telefonoMovilProveedor=" + telefonoMovilProveedor + ", emailProveedor="
                + emailProveedor + ", logoProveedor=" + logoProveedor + ", direccionProveedor=" + direccionProveedor
                + ", estadoProveedor=" + estadoProveedor + ", telefonoFijoProveedor=" + telefonoFijoProveedor
                + ", numeroContactoProveedor=" + numeroContactoProveedor + ", fechaRegistroProveedor="
                + fechaRegistroProveedor + ", idEmpresa=" + idEmpresa + "]";
    }
}