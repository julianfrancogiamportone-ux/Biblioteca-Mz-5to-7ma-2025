package com.mz.bibliteca_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mz.bibliteca_api.entity.Autor;
import com.mz.bibliteca_api.repository.AutorRepository;;

@Service
class AutorService {

    private final AutorRepository repository;

    public AutorService(AutorRepository repository) {
        this.repository = repository;
    }

    public List<Autor> listar() { return repository.findAll(); }
    public Autor obtener(Long id) { return repository.findById(id).orElse(null); }
    public Autor guardar(Autor autor) { return repository.save(autor); }
    public void eliminar(Long id) { repository.deleteById(id); }
}