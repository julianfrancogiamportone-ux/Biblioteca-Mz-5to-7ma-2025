package com.mz.bibliteca_api.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mz.bibliteca_api.entity.Usuario;
import com.mz.bibliteca_api.iservice.IUsuarioService;
import com.mz.bibliteca_api.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    private UsuarioRepository uRepository;

    @Override
    public List<Usuario> findAllUsuarios() {
        return uRepository.findAll();
    }

    @Override
    public Usuario findUsuarioById(Long id) {
        Optional<Usuario> result = uRepository.findById(id);
        
        return result.orElse(new Usuario());
    }

    @Override
    public Usuario findUsuarioByUsername(String username) {
        try {
            return uRepository.findByUsername(username).getFirst();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return uRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        uRepository.delete(usuario);
    }

    @Override
    public void deleteUsuarioById(Long id) {
        uRepository.deleteById(id);
    }

    @Override
    public void deleteAllUsuarios() {
        uRepository.deleteAll();
    }
}
