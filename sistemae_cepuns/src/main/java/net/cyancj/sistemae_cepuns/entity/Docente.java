package net.cyancj.sistemae_cepuns.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
public class Docente {

    @Id
    @Length(min = 8, max = 8)
    @Column(length = 8, nullable = false)
    private String dni;

    @Column(length = 25, nullable = false)
    private String nombres;

    @Column(length = 30, nullable = false)
    private String apellidos;

    @Column(length = 25, nullable = false)
    private String especialidad;

    @Column(length = 9,nullable = false)
    private String celular;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String direccion;

    public Docente() {
    }

    public Docente(@Length(min = 8, max = 8) String dni, String nombres, String apellidos, String especialidad, String celular, String email, String direccion) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
        this.celular = celular;
        this.email = email;
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
