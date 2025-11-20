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

import com.mz.bibliteca_api.entity.Profesor;
import com.mz.bibliteca_api.iservice.IProfesorService;

@RestController
@RequestMapping("/api/profesores")
class ProfesorController {
    @Autowired
    private IProfesorService aiService;

    @GetMapping
    public List<Profesor> listar() { return aiService.findAllprofesor(); }

    @GetMapping("/{id}")
    public Profesor obtener(@PathVariable Long id) {
        final Optional<Profesor> resultado = aiService.findprofesorById(id);
        if (resultado.isPresent()) {
            return resultado.get();
        } else {
            return new Profesor();
        }
    }

    @PostMapping
    public Profesor crear(@RequestBody Profesor profesor) { return aiService.saveProfesor(profesor); }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {}

}