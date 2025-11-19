package com.mz.bibliteca_api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mz.bibliteca_api.entity.Materia;
import com.mz.bibliteca_api.iservice.IMateriaService;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {

    @Autowired
    private IMateriaService materiaService;

    @GetMapping
    public List<Materia> listarMaterias() {
        return materiaService.findAll();
    }

    @GetMapping("/{id}")
    public Materia obtenerPorId(@PathVariable Integer id) {
        return materiaService.findById(id);
    }

    @PostMapping
    public Materia crearMateria(@RequestBody Materia materia) {
        return materiaService.save(materia);
    }

    @PutMapping("/{id}")
    public Materia actualizarMateria(@PathVariable Integer id, @RequestBody Materia materia) {
        materia.setId(id);
        return materiaService.save(materia);
    }

    @DeleteMapping("/{id}")
    public void eliminarMateria(@PathVariable Integer id) {
        materiaService.deleteById(id);
    }
}
