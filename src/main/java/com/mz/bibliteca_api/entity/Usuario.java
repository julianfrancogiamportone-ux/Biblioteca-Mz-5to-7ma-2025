package com.mz.bibliteca_api.entity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String role;
    @OneToOne
    private Alumno asAlumno;
    @OneToOne
    private Profesor asProfesor;

    public Usuario() {}
    
    public Usuario(String username, String password, String role, Alumno asAlumno, Profesor asProfesor) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.username = username;
        this.password = encoder.encode(password);
        this.role = role;
        this.asAlumno = asAlumno;
        this.asProfesor = asProfesor;
    }

    public Long getId() {
        return id;
    }

    public void resetId() {
        this.id = null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean comparePasswords(String pasword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(pasword, getPassword());
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Alumno getAsAlumno() {
        return asAlumno;
    }

    public void setAsAlumno(Alumno asAlumno) {
        this.asAlumno = asAlumno;
    }

    public Profesor getAsProfesor() {
        return asProfesor;
    }

    public void setAsProfesor(Profesor asProfesor) {
        this.asProfesor = asProfesor;
    }

    
}
