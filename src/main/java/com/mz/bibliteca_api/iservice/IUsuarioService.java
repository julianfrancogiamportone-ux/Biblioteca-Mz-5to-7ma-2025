package com.mz.bibliteca_api.iservice;

import java.util.List;

import com.mz.bibliteca_api.entity.Usuario;

public interface IUsuarioService {
    public List<Usuario> findAllUsuarios();
	public Usuario findUsuarioById(Long id);
	public Usuario findUsuarioByUsername(String username);
    public Usuario saveUsuario(Usuario usuario);
	public void deleteUsuario(Usuario usuario);
	public void deleteUsuarioById(Long id);
	public void deleteAllUsuarios();
}
