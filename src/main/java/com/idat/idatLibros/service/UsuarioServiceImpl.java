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
		try {
			usr = usuarioRepository.save(usr);
		} catch (Exception e) {
			e.printStackTrace();
			return new Usuario();
		}
		return usr;
	}

	@Override
	@Transactional
	public Usuario actualizar(Usuario usr) {
		try {
			usr = usuarioRepository.save(usr);
		} catch (Exception e) {
			e.printStackTrace();
			return new Usuario();
		}
		return usr;
	}

	@Override
	@Transactional
	public boolean eliminar(int id) {
		try {
			usuarioRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario buscar(int id) {
		Usuario usr = null;
		try {
			Optional<Usuario> opt = usuarioRepository.findById(id);
			if (opt.isPresent()) {
				usr = opt.get();
			}
			else {
				throw new Exception("No Encontrado.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Usuario();
		}
		return usr;
	}

}
