package com.mz.bibliteca_api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mz.bibliteca_api.entity.Materia;
import com.mz.bibliteca_api.iservice.IMateriaService;

@RestController
@RequestMapping("/api/materias")
@CrossOrigin(origins = "*")
public class MateriaController {

    @Autowired
    private IMateriaService mService;

    @GetMapping
    public List<Materia> listarMaterias() {
        return mService.findAll();
    }

    @GetMapping("/{id}")
    public Materia obtenerPorId(@PathVariable Integer id) {
        return mService.findById(id);
    }

    @PostMapping
    public Materia crearMateria(@RequestBody Materia materia) {
        return mService.save(materia);
    }

    @DeleteMapping("/{id}")
    public void eliminarMateria(@PathVariable Integer id) {
        mService.deleteById(id);
    }
}
