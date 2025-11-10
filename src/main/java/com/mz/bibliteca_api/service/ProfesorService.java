package com.mz.bibliteca_api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.mz.bibliteca_api.repository.ProfesorRepository;

import com.mz.bibliteca_api.entity.Profesor;

@Service
class ProfesorService {

    private final ProfesorRepository repository;

    public ProfesorService(ProfesorRepository repository) {
        this.repository = repository;
    }

    public List<Profesor> listar() { return repository.findAll(); }
    public Profesor obtener(Long id) { return repository.findById(id).orElse(null); }
    public Profesor guardar(Profesor profesor) { return repository.save(profesor); }
    public void eliminar(Long id) { repository.deleteById(id); }
}