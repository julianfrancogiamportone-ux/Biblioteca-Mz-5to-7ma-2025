package com.mz.bibliteca_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mz.bibliteca_api.entity.Libro;
import com.mz.bibliteca_api.iservice.ILibroService;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin(origins = "*")
public class LibroController {
	
	@Autowired
	private ILibroService lService;
	
	@GetMapping
	public List<Libro> getAllLibros() {
		return lService.findAllBooks();
	}
	
	@GetMapping("/{id}")
	public Optional<Libro> getLibroById(@PathVariable Long id) {
		return lService.findBookById(id);
	}
	
	@PostMapping
	public Libro createLibro(@RequestBody Libro libro) {
		return lService.saveBook(libro);
	}
	
	@DeleteMapping("/{id}/delete")
	public void deleteLibro(@PathVariable Long id) {
		lService.deleteBook(id);
	}
	
	@DeleteMapping("/delete")
	public void deleteLibro(@RequestBody Libro libro) {
		lService.deleteBook(libro);
	}
	
	@DeleteMapping("/delete/all")
	public void deleteAllLibros() {
		lService.deleteAllBooks();
	}
}
