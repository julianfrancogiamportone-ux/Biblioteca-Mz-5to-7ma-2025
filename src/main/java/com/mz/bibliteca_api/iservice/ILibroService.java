package com.mz.bibliteca_api.iservice;

import java.util.List;
import java.util.Optional;

import com.mz.bibliteca_api.entity.Libro;

public interface ILibroService {
    public List<Libro> findAllBooks();
    public Libro saveBook(Libro libro);
	public Optional<Libro> findBookById(Long id);
	public void deleteBook(Long id);
	public void deleteBook(Libro libro);
	public void deleteAllBooks();
}