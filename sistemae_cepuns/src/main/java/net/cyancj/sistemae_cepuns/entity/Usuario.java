package net.cyancj.sistemae_cepuns.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String usuario;

    @Column(nullable = false)
    private String clave;

    @Column(length = 25, nullable = false)
    private String nombres;

    @Column(length = 30, nullable = false)
    private String apellidos;

    @Column(length = 20, nullable = false)
    private String rol;

    @Column(length = 1, nullable = false)
    private int estado;

    @Column(nullable = false)
    private Boolean admin;


    public Usuario() {
    }

    public Usuario(Long id, String usuario, String clave, String nombres, String apellidos, String rol, int estado, Boolean admin) {
        this.id = id;
        this.usuario = usuario;
        this.clave = clave;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.rol = rol;
        this.estado = estado;
        this.admin = admin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @JsonIgnore
    @JsonProperty(value = "clave")
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @JsonIgnore
    @JsonProperty(value = "estado")
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @JsonIgnore
    @JsonProperty(value = "admin")
    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}
