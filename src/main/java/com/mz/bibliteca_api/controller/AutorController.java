package com.mz.bibliteca_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mz.bibliteca_api.entity.Autor;
import com.mz.bibliteca_api.iservice.IAutorService;

@RestController
@RequestMapping("/api/autores")
class AutorController {
    @Autowired
    private IAutorService aService;

    //public AutorController(IAutorService aiService) {
    //    this.aService = aiService;
    //}

    @GetMapping
    public List<Autor> listar() { return aService.findAllAuthors(); }

    @GetMapping("/{id}")
    public Autor obtener(@PathVariable Long id) {
        final Optional<Autor> resultado = aService.findAuthorById(id);
        if (resultado.isPresent()) {
            return resultado.get();
        } else {
            return new Autor();
        }
    }

    @PostMapping
    public Autor crear(@RequestBody Autor autor) { return aService.saveAuthor(autor); }
}