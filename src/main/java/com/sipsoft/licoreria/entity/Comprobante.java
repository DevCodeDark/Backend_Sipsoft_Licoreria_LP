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
@Table(name = "comprobante")
@SQLDelete(sql = "UPDATE comprobante SET estadoComprobante = 0 WHERE idComprobante = ?")
@Where(clause = "estadoComprobante = 1")
public class Comprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComprobante;
    private String correlativoComprobante;
    private Integer estadoComprobante = 1;
    private String direccionEmpresa;
    private LocalDate fechaEmision;
    private String nombreComprobante;
    private String numComprobante;
    private String telefonoEmpresa;
    private Integer idVenta;
    private Integer idSerie;
    private Integer idCaja;
    private Integer idCompra;
    private Integer idTipoComprobante;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idVenta", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Venta venta;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSerie", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private SerieComprobante serieComprobante;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCaja", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Caja caja;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCompra", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Compra compra;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoComprobante", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TipoComprobante tipoComprobante;

    // --- Constructores, Getters y Setters ---

    public Comprobante() {
    }

    public Integer getIdComprobante() { 
        return idComprobante; 
    }
    public void setIdComprobante(Integer idComprobante) { 
        this.idComprobante = idComprobante; 
    }
    public String getCorrelativoComprobante() { 
        return correlativoComprobante; 
    }
    public void setCorrelativoComprobante(String correlativoComprobante) { 
        this.correlativoComprobante = correlativoComprobante; 
    }
    public Integer getEstadoComprobante() { 
        return estadoComprobante; 
    }
    public void setEstadoComprobante(Integer estadoComprobante) { 
        this.estadoComprobante = estadoComprobante; 
    }
    public String getDireccionEmpresa() { 
        return direccionEmpresa; 
    }
    public void setDireccionEmpresa(String direccionEmpresa) { 
        this.direccionEmpresa = direccionEmpresa; 
    }
    public LocalDate getFechaEmision() { 
        return fechaEmision; 
    }
    public void setFechaEmision(LocalDate fechaEmision) { 
        this.fechaEmision = fechaEmision; 
    }
    public String getNombreComprobante() { 
        return nombreComprobante; 
    }
    public void setNombreComprobante(String nombreComprobante) { 
        this.nombreComprobante = nombreComprobante; 
    }
    public String getNumComprobante() { 
        return numComprobante; 
    }
    public void setNumComprobante(String numComprobante) { 
        this.numComprobante = numComprobante; 
    }
    public String getTelefonoEmpresa() { 
        return telefonoEmpresa; 
    }
    public void setTelefonoEmpresa(String telefonoEmpresa) { 
        this.telefonoEmpresa = telefonoEmpresa; 
    }
    public Integer getIdVenta() { 
        return idVenta; 
    }
    public void setIdVenta(Integer idVenta) { 
        this.idVenta = idVenta; 
    }
    public Integer getIdSerie() { 
        return idSerie; 
    }
    public void setIdSerie(Integer idSerie) { 
        this.idSerie = idSerie; 
    }
    public Integer getIdCaja() { 
        return idCaja; 
    }
    public void setIdCaja(Integer idCaja) { 
        this.idCaja = idCaja; 
    }
    public Integer getIdCompra() { 
        return idCompra; 
    }
    public void setIdCompra(Integer idCompra) { 
        this.idCompra = idCompra; 
    }
    public Integer getIdTipoComprobante() { 
        return idTipoComprobante; 
    }
    public void setIdTipoComprobante(Integer idTipoComprobante) { 
        this.idTipoComprobante = idTipoComprobante; 
    }
    public Venta getVenta() { 
        return venta; 
    }
    public void setVenta(Venta venta) { 
        this.venta = venta; 
    }
    public SerieComprobante getSerieComprobante() { 
        return serieComprobante; 
    }
    public void setSerieComprobante(SerieComprobante serieComprobante) { 
        this.serieComprobante = serieComprobante; 
    }
    public Caja getCaja() { 
        return caja; 
    }
    public void setCaja(Caja caja) { 
        this.caja = caja; 
    }
    public Compra getCompra() { 
        return compra; 
    }
    public void setCompra(Compra compra) { 
        this.compra = compra; 
    }
    public TipoComprobante getTipoComprobante() { 
        return tipoComprobante; 
    }
    public void setTipoComprobante(TipoComprobante tipoComprobante) { 
        this.tipoComprobante = tipoComprobante; 
    }
}