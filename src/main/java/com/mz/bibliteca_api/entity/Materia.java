package com.mz.bibliteca_api.entity;


  import jakarta.persistence.GeneratedValue;
  import jakarta.persistence.GenerationType;
  import jakarta.persistence.Id;

public class Materia{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

      public Materia() {}
      public Materia(String nombre) {
      this.nombre = nombre;
    }
       public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

