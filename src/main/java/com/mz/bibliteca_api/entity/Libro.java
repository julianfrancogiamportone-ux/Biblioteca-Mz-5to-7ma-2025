package com.mz.bibliteca_api.entity;

import java.util.Date;
//import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.OneToMany;

// TODO: Descomentar una vez se hayan implementado las entidades Autor, Editorial y Materia.

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String nombre;
    //@ManyToMany(mappedBy="books")
    //private Set<Autor> autores;
    private Date fechaPublicacion;
    //@OneToMany(mappedBy = "books")
    //private Editorial editorial;
    private String descripcion;
    private String urlImagen;
    //@ManyToMany(mappedBy="books")
    //private Set<Materia> materias;
    private Integer paginas;

    //public Libro(Set<Autor> autores, String descripcion, Editorial editorial, Date fechaPublicacion, Set<Materia> materias, String nombre, Integer paginas) {
    public Libro(String description, String urlImagen, Date fechaPublicacion, String nombre, Integer pages) {
        //this.autores = autores;
        this.descripcion = description;
        this.urlImagen = urlImagen;
        //this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
        //this.materias = materias;
        this.nombre = nombre;
        this.paginas = pages;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //public Set<Autor> getAutores() {
    //    return autores;
    //}

    //public void setAutores(Set<Autor> autores) {
    //    this.autores = autores;
    //}

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    //public Editorial getEditorial() {
    //    return editorial;
    //}

    //public void setEditorial(Editorial editorial) {
    //    this.editorial = editorial;
    //}

    public String getDescription() {
        return descripcion;
    }

    public void setDescription(String description) {
        this.descripcion = description;
    }

    //public Set<Materia> getMaterias() {
    //    return materias;
    //}

    //public void setMaterias(Set<Materia> materias) {
    //    this.materias = materias;
    //}

    public Integer getPages() {
        return paginas;
    }

    public void setPages(Integer pages) {
        this.paginas = pages;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

}