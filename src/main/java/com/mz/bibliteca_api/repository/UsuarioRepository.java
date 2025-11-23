package com.mz.bibliteca_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mz.bibliteca_api.entity.Usuario;
import java.util.List;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public List<Usuario> findByUsername(String username);
}
