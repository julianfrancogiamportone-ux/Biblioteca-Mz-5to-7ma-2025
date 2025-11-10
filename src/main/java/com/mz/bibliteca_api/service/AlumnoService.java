package com.mz.bibliteca_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mz.bibliteca_api.entity.Alumno;
import com.mz.bibliteca_api.repository.AlumnoRepository;

@Service
class AlumnoService {

    private final AlumnoRepository repository;

    public AlumnoService(AlumnoRepository repository) {
        this.repository = repository;
    }

    public List<Alumno> listar() { return repository.findAll(); }
    public Alumno obtener(Long id) { return repository.findById(id).orElse(null); }
    public Alumno guardar(Alumno alumno) { return repository.save(alumno);}
}