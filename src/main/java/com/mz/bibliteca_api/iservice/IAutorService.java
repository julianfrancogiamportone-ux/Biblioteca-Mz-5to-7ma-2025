package com.mz.bibliteca_api.iservice;

import java.util.List;
import java.util.Optional;

import com.mz.bibliteca_api.entity.Autor;

public interface IAutorService {
    public List<Autor> findAllAuthors();
    public Autor saveAuthor(Autor autor);
	public Optional<Autor> findAuthorById(Long id);
	public void deleteAuthor(Long id);
	public void deleteAuthor(Autor autor);
	public void deleteAllAuthors();
}
