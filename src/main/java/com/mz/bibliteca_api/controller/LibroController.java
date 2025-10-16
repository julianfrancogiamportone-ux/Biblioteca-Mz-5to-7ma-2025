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
	private ILibroService pService;
	
	@GetMapping
	public List<Libro> getAllLibros() {
		return pService.findAllBooks();
	}
	
	@GetMapping("/{id}")
	public Optional<Libro> getLibroById(@PathVariable Long id) {
		return pService.findBookById(id);
	}
	
	@PostMapping
	public Libro createLibro(@RequestBody Libro libro) {
		return pService.saveBook(libro);
	}
	
	@DeleteMapping("/{id}/delete")
	public void deleteLibro(@PathVariable Long id) {
		pService.deleteBook(id);
	}
	
	@DeleteMapping("/delete")
	public void deleteLibro(@RequestBody Libro libro) {
		pService.deleteBook(libro);
	}
	
	@DeleteMapping("/delete/all")
	public void deleteAllLibros() {
		pService.deleteAllBooks();
	}
}
