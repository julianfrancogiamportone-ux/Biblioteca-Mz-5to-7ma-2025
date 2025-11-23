package com.mz.bibliteca_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mz.bibliteca_api.entity.Usuario;
import com.mz.bibliteca_api.iservice.IUsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/usuarios")
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
