package com.idat.idatLibros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.idatLibros.model.Usuario;
import com.idat.idatLibros.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	@Override
	@Transactional
	public Usuario registrar(Usuario usr) {
		return usuarioRepository.save(usr);
	}

	@Override
	@Transactional
	public Usuario actualizar(Usuario usr) {
		return usuarioRepository.save(usr);
	}

	@Override
	@Transactional
	public boolean eliminar(int id) {
		Optional<Usuario> opt = usuarioRepository.findById(id);
		if (opt.isPresent()) {
			usuarioRepository.delete(opt.get());
			return true;
		}
		return false;
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario buscar(int id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario buscarCorreo(String correo) {
		Usuario usr = usuarioRepository.findUsuarioByCorreo(correo);
		return usr;
	}

}
