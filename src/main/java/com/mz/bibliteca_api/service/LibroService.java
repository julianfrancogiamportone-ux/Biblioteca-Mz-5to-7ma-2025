package com.mz.bibliteca_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mz.bibliteca_api.entity.Libro;
import com.mz.bibliteca_api.iservice.ILibroService;
import com.mz.bibliteca_api.repository.LibroRepository;

@Service
public class LibroService implements ILibroService {
    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<Libro> findAllBooks() {
        return libroRepository.findAll();
    }

    @Override
    public Libro saveBook(Libro libro) {
        return libroRepository.save(libro);
    }
    
	@Override
	public Optional<Libro> findBookById(Long id) {
		return libroRepository.findById(id);
	};
	
	@Override
	public void deleteBook(Long id) {
		libroRepository.deleteById(id);
	}
	
	@Override
	public void deleteBook(Libro libro) {
		libroRepository.delete(libro);
	};
	
	@Override
	public void deleteAllBooks() {
		libroRepository.deleteAll();
	}
}