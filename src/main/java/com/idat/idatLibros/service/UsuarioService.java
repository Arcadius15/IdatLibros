package com.idat.idatLibros.service;

import java.util.List;

import com.idat.idatLibros.model.Usuario;

public interface UsuarioService {
	public List<Usuario> listar();
	public Usuario registrar(Usuario usr);
	public Usuario actualizar(Usuario usr);
	public boolean eliminar(int id);
	public Usuario buscar(int id);

}
