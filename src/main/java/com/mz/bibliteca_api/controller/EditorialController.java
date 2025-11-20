package com.mz.bibliteca_api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mz.bibliteca_api.entity.Editorial;
import com.mz.bibliteca_api.iservice.IEditorialService;

@RestController
@RequestMapping("/api/editoriales")
public class EditorialController {

    @Autowired
    private IEditorialService editorialService;

    @GetMapping
    public List<Editorial> listarEditoriales() {
        return editorialService.findAll();
    }
     
    @GetMapping("/{id}")
    public Editorial obtenerPorId(@PathVariable Integer id) {
        return editorialService.findById(id).orElse(null);
    }


    @PostMapping
    public Editorial crearEditorial(@RequestBody Editorial editorial) {
        return editorialService.save(editorial);
    }

    @DeleteMapping("/{id}")
    public void eliminarEditorial(@PathVariable Integer id) {
        editorialService.deleteById(id);
    }
}
