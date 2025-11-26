package com.mz.bibliteca_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mz.bibliteca_api.entity.Curso;
import com.mz.bibliteca_api.entity.Usuario;
import com.mz.bibliteca_api.iservice.ICursoService;
import com.mz.bibliteca_api.iservice.IUsuarioService;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin(origins = {"http://127.0.0.1", "https://127.0.0.1/", "http://localhost/", "https://localhost", "http://127.0.0.1:3000", "https://127.0.0.1:3000/", "http://localhost:3000/", "https://localhost:3000/"})
public class CursoController {
	
	@Autowired
	private ICursoService cService;
	
	@GetMapping
	public List<Curso> getAllCursos() {
		return cService.findAllCursos();
	}
	
	@GetMapping("/{id}")
	public Optional<Curso> getCursoById(@PathVariable Long id) {
		return cService.findCursoById(id);
	}

	@Autowired
    private IUsuarioService uService;

	@GetMapping("/me")
	public Curso getSelf() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Usuario usuario = uService.findUsuarioByUsername(user.getUsername());
        if (usuario != null) {
            return usuario.getAsAlumno().getCurso();
        } else {
            return null;
        }
	}
	
	
	@PostMapping
	public Curso createCurso(@RequestBody Curso curso) {
		return cService.saveCurso(curso);
	}
	
	@DeleteMapping("/{id}/delete")
	public void deleteCurso(@PathVariable Long id) {
		cService.deleteCurso(id);
	}
	
	@DeleteMapping("/delete")
	public void deleteCurso(@RequestBody Curso curso) {
		cService.deleteCurso(curso);
	}
	
	@DeleteMapping("/delete/all")
	public void deleteAllCursos() {
		cService.deleteAllCursos();
	}
}
