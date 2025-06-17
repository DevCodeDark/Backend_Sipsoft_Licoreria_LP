package com.sipsoft.licoreria.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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
@Table(name = "categoria")
@SQLDelete(sql = "UPDATE categoria SET estadoCategoria = 0 WHERE idCategoria = ?")
@Where(clause = "estadoCategoria = 1")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;
    private String nombreCategoria;
    private Integer estadoCategoria = 1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpresa")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empresa idEmpresa;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public Integer getEstadoCategoria() {
        return estadoCategoria;
    }

    public void setEstadoCategoria(Integer estadoCategoria) {
        this.estadoCategoria = estadoCategoria;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public String toString() {
        return "Categoria [idCategoria=" + idCategoria + ", nombreCategoria=" + nombreCategoria + ", estadoCategoria="
                + estadoCategoria + ", idEmpresa=" + idEmpresa + "]";
    }
}
