package com.mz.bibliteca_api.entity;

import java.time.Year;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private Year cicloLectivo;
    private int division;
    @ManyToMany(mappedBy = "cursos")
    @JsonIgnoreProperties(value = "cursos")
    private Set<Profesor> profesores;

    @OneToMany(mappedBy = "curso")
    @JsonIgnoreProperties(value = "curso")
    /* TODO: En vez de ignorar toda la propiedad curso, solo ignorar al alumno dentro del curso,
        evitando recursion y preservando informacion*/
    private Set<Alumno> alumnos;

    public Curso() {}

    public Curso(Year cicloLectivo, int division, Set<Profesor> profesores, Set<Alumno> alumnos) {
        this.cicloLectivo = cicloLectivo;
        this.division = division;
        this.profesores = profesores;
        this.alumnos = alumnos;
    }

    public long getId() {
        return id;
    }

    public Year getCicloLectivo() {
        return cicloLectivo;
    }

    public void setCicloLectivo(Year cicloLectivo) {
        this.cicloLectivo = cicloLectivo;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public Set<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    
    
}
