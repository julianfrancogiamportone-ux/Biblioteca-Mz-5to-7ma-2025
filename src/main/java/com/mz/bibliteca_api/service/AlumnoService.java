package com.mz.bibliteca_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mz.bibliteca_api.entity.Alumno;
import com.mz.bibliteca_api.iservice.IAlumnoService;
import com.mz.bibliteca_api.repository.AlumnoRepository;

@Service
class AlumnoService implements IAlumnoService{
    @Autowired
    private AlumnoRepository repository;

    @Override
    public List<Alumno> findAllAlumnos() {
        return repository.findAll();
    };

    @Override
    public Alumno saveAlumnos(Alumno alumno) {
        return repository.save(alumno);
    };

    @Override
	public Optional<Alumno> findAlumnosById(Long id) {
        return repository.findById(id);
    };
	
    @Override
    public void deleteAlumnos(Long id) {
        repository.deleteById(id);
    };
	
    @Override
    public void deleteAlumnos (Alumno alumno) {
        repository.delete(alumno);
    };
	
    @Override
    public void deleteAllAlumnos() {
        repository.deleteAll();
    };
}