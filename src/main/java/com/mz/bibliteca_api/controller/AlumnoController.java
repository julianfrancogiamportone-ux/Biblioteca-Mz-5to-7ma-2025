package com.mz.bibliteca_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mz.bibliteca_api.entity.Alumno;
import com.mz.bibliteca_api.iservice.IAlumnoService;

@RestController
@RequestMapping("/api/alumnos")
class AlumnoController {
    
    @Autowired
    private IAlumnoService aiService;

    @GetMapping
    public List<Alumno> listar() { return aiService.findAllAlumnos(); }

    @GetMapping("/{id}")
    public Alumno obtener(@PathVariable Long id) {
        final Optional<Alumno> resultado = aiService.findAlumnosById(id);
        
        if (resultado.isPresent()) {
            return resultado.get();
        } else {
            return new Alumno();
        }
    }

    @PostMapping
    public Alumno crear(@RequestBody Alumno alumno) { return aiService.saveAlumnos(alumno); }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        aiService.deleteAlumnos(id);
    }
  }