package com.mz.bibliteca_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mz.bibliteca_api.repository.ProfesorRepository;

import com.mz.bibliteca_api.entity.Profesor;
import com.mz.bibliteca_api.iservice.IProfesorService;

@Service
class ProfesorService implements IProfesorService{
    @Autowired
    private ProfesorRepository repository;

    public ProfesorService(ProfesorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Profesor> findAllprofesor() {
        return repository.findAll();
    };

    @Override
    public Profesor saveProfesor(Profesor profesor) {
        return repository.save(profesor);
    };

	@Override
    public Optional<Profesor> findprofesorById(Long id) {
        return repository.findById(id);
    };

	@Override
    public void deleteProfesor(Long id) {
        repository.deleteById(id);
    };

	@Override
    public void deleteProfesor(Profesor profesor) {
        repository.delete(profesor);
    };

	@Override
    public void deleteAllprofesor() {
        repository.deleteAll();
    };
}