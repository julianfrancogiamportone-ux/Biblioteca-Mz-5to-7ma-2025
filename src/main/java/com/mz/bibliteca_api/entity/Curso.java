package com.mz.bibliteca_api.entity;

import java.time.Year;
//import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.ManyToOne;


/*  
    Nota: Parte del código se encuentra comentada debido a que aun no se han implementado
    las entidades Libro, Profesor y Alumno, una vez implementadas es necesario descomentar el mismo.
*/

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private Year cicloLectivo;
    private int division;
    //@ManyToMany()
    //private Set<Libro> librosReservados;
    //@ManyToMany()
    //private Set<Profesor> profesores;
    //@ManyToOne()
    //private Set<Alumno> alumnos;

    public Curso() {}

    //public Curso(Year cicloLectivo, int division, Set<Libro> librosReservados, Set<Profesor> profesores, Set<Alumno> alumnos) {
    public Curso(Year cicloLectivo, int division) {
    this.cicloLectivo = cicloLectivo;
        this.division = division;
        //this.librosReservados = librosReservados;
        //this.profesor = profesores;
        //this.alumnos = alumnos;
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

    //public Set<Libro> getLibrosReservados() {
    //    return librosReservados;
    //}

    //public void setLibrosReservados(Set<Libro> librosReservados) {
    //    this.librosReservados = librosReservados;
    //}

    //public Set<Profesor> getProfesores() {
    //    return profesores;
    //}

    //public void setProfesores(Set<Profesor> profesores) {
    //    this.profesores = profesores;
    //}

    //public Set<Alumno> getAlumnos() {
    //    return profesor;
    //}

    //public void setAlumnos(Set<Alumno> alumnos) {
    //    this.alumnos = alumnos;
    //}
    
}
