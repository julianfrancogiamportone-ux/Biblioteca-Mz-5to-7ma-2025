package com.mz.bibliteca_api.entity;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String nombre;

    @ManyToMany()
    @JsonIgnoreProperties(value = "libros")
    /* TODO: En vez de ignorar toda la propiedad libros, solo ignorar al libro dentro del autor,
        evitando recursion y preservando informacion*/
    private Set<Autor> autores;

    private Date fechaPublicacion;

    @ManyToOne()
    @JoinColumn(name = "editorial_id")
    @JsonIgnoreProperties(value = "libros")
    private Editorial editorial;

    private String descripcion;
    private String urlImagen;

    @ManyToMany()
    @JsonIgnoreProperties(value = "libros")
    /* TODO: En vez de ignorar toda la propiedad libros, solo ignorar al libro dentro de la materia,
        evitando recursion y preservando informacion*/
    private Set<Materia> materias;

    private Integer paginas;

    public Libro() {}
    
    public Libro(String nombre, Set<Autor> autores, Date fechaPublicacion, Editorial editorial, String descripcion,
            String urlImagen, Set<Materia> materias, Integer paginas) {
        this.nombre = nombre;
        this.autores = autores;
        this.fechaPublicacion = fechaPublicacion;
        this.editorial = editorial;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.materias = materias;
        this.paginas = paginas;
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

    public Set<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Set<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(Set<Materia> materias) {
        this.materias = materias;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    
    
}