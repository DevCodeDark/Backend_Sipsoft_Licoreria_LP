package com.sipsoft.licoreria.entity;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
@Table(name = "usuario")
@SQLDelete(sql = "UPDATE usuario SET estadoUsuario = 0 WHERE idUsuario = ?")
@Where(clause = "estadoUsuario = 1")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    private String clienteId;
    private String llaveSecreta;
    private String accessToken;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String telefonoUsuario;
    private String dniUsuario;
    private String emailUsuario;
    private String contrasenaUsuario;
    private Integer estadoUsuario = 1;
    private Integer idRol;
    private Integer idEmpresa; 
       
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idRol", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnore
    private Rol rol;    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "idEmpresa", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnore
    private Empresa empresa;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.idUsuario = id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getClienteId() {
        return clienteId;
    }

    // Genera cliente_id usando SHA-256 basado en datos del usuario
    public void setClienteId(String clienteId) {
        String datos = nombreUsuario + apellidoUsuario + emailUsuario;
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(datos.getBytes());
        byte[] digest = md.digest();
        String result = new BigInteger(1, digest).toString(16).toLowerCase();
        clienteId = result;
        this.clienteId = clienteId;
    }

    public String getLlaveSecreta() {
        return llaveSecreta;
    }

    // Encripta la llave secreta usando BCrypt
    public void setLlaveSecreta(String llaveSecreta) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.llaveSecreta = encoder.encode(llaveSecreta);
    }

    public String getAccessToken() {
        return accessToken;
    }

    // Genera access_token combinando llave_secreta + clienteId
    public void setAccessToken(String accessToken) {
        if (this.llaveSecreta != null && this.clienteId != null) {
            String datos = this.llaveSecreta + this.clienteId;
            MessageDigest md = null;
            try {
                md = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            md.update(datos.getBytes());
            byte[] digest = md.digest();
            String tokenGenerado = new BigInteger(1, digest).toString(16).toLowerCase();
            this.accessToken = tokenGenerado;
        } else {
            this.accessToken = accessToken;
        }
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public Integer getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(Integer estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    // Método helper para generar automáticamente cliente_id, llave_secreta y access_token
    public void generarCredenciales(String llaveSecretaOriginal) {
        // Generar cliente_id
        this.setClienteId("");

        // Encriptar llave secreta
        this.setLlaveSecreta(llaveSecretaOriginal);

        // Generar access_token
        this.setAccessToken("");
    }

    @Override
    public String toString() {
        return "Usuario [idUsuario=" + idUsuario + ", clienteId=" + clienteId + ", llaveSecreta=" + llaveSecreta
                + ", accessToken=" + accessToken + ", nombreUsuario=" + nombreUsuario + ", apellidoUsuario="
                + apellidoUsuario + ", telefonoUsuario=" + telefonoUsuario + ", dniUsuario=" + dniUsuario
                + ", emailUsuario=" + emailUsuario + ", contrasenaUsuario=" + contrasenaUsuario + ", estadoUsuario="
                + estadoUsuario + ", idRol=" + idRol + ", idEmpresa=" + idEmpresa + "]";
    } 
}
