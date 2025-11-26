package com.mz.bibliteca_api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mz.bibliteca_api.entity.Editorial;
import com.mz.bibliteca_api.iservice.IEditorialService;

@RestController
@RequestMapping("/api/editoriales")
@CrossOrigin(origins = "*")
public class EditorialController {

    @Autowired
    private IEditorialService eService;

    @GetMapping
    public List<Editorial> listarEditoriales() {
        return eService.findAll();
    }
     
    @GetMapping("/{id}")
    public Editorial obtenerPorId(@PathVariable Integer id) {
        return eService.findById(id).orElse(null);
    }


    @PostMapping
    public Editorial crearEditorial(@RequestBody Editorial editorial) {
        return eService.save(editorial);
    }

    @DeleteMapping("/{id}")
    public void eliminarEditorial(@PathVariable Integer id) {
        eService.deleteById(id);
    }
}
