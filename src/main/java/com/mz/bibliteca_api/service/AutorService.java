package com.mz.bibliteca_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mz.bibliteca_api.entity.Autor;
import com.mz.bibliteca_api.iservice.IAutorService;
import com.mz.bibliteca_api.repository.AutorRepository;;

@Service
class AutorService implements IAutorService{
    @Autowired
    private AutorRepository repository;
    
    @Override
    public List<Autor> findAllAuthors() { return repository.findAll(); }
    @Override
    public Autor saveAuthor(Autor autor) { return repository.save(autor); }
    @Override
    public Optional<Autor> findAuthorById(Long id) { return repository.findById(id); }
    @Override
    public void deleteAuthorById(Long id) { repository.deleteById(id); }
    @Override
    public void deleteAuthor(Autor autor) { repository.delete(autor); }
    @Override
    public void deleteAllAuthors() { repository.deleteAll(); }
}