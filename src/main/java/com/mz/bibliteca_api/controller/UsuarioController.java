package com.mz.bibliteca_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mz.bibliteca_api.entity.Usuario;
import com.mz.bibliteca_api.iservice.IUsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = {"http://127.0.0.1", "https://127.0.0.1/", "http://localhost/", "https://localhost", "http://127.0.0.1:3000", "https://127.0.0.1:3000/", "http://localhost:3000/", "https://localhost:3000/"})
public class UsuarioController {

    @Autowired
    private IUsuarioService uService;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return uService.findAllUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario findUsuarioById(@PathVariable Long id) {
        return uService.findUsuarioById(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private class NotFoundException extends RuntimeException {}

    @PostMapping("/registro")
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        usuario.resetId();
        if (uService.findUsuarioByUsername(usuario.getUsername()) != null) {
            throw new NotFoundException();
        }
        return uService.saveUsuario(usuario);
    }
    
    @PostMapping
    public Usuario saveUsuario(@RequestBody Usuario usuario) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        return uService.saveUsuario(usuario);
    }
    
    @DeleteMapping
    public void deleteUsuario(@RequestBody Usuario usuario) {
        uService.deleteUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuarioById(@RequestParam Long id) {
        uService.deleteUsuarioById(id);
    }

    @DeleteMapping("/all")
    public void deleteUsuarios() {
        uService.deleteAllUsuarios();
    }
}
