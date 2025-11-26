package com.mz.bibliteca_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mz.bibliteca_api.entity.Alumno;
import com.mz.bibliteca_api.entity.Usuario;
import com.mz.bibliteca_api.iservice.IAlumnoService;
import com.mz.bibliteca_api.iservice.IUsuarioService;

@RestController
@RequestMapping("/api/alumnos")
@CrossOrigin(origins = {"http://127.0.0.1", "https://127.0.0.1/", "http://localhost/", "https://localhost", "http://127.0.0.1:3000", "https://127.0.0.1:3000/", "http://localhost:3000/", "https://localhost:3000/"})
class AlumnoController {
    
    @Autowired
    private IAlumnoService aService;

    @Autowired
    private IUsuarioService uService;

    @GetMapping
    public List<Alumno> listar() { return aService.findAllAlumnos(); }

    @GetMapping("/{id}")
    public Alumno obtener(@PathVariable Long id) {
        final Optional<Alumno> resultado = aService.findAlumnosById(id);
        
        if (resultado.isPresent()) {
            return resultado.get();
        } else {
            return new Alumno();
        }
    }

    @GetMapping("/me")
    public Alumno getSelf() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Usuario usuario = uService.findUsuarioByUsername(user.getUsername());
        if (usuario != null) {
            return usuario.getAsAlumno();
        } else {
            return null;
        }
    }

    @PostMapping
    public Alumno crear(@RequestBody Alumno alumno) { return aService.saveAlumnos(alumno); }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        aService.deleteAlumnos(id);
    }
  }