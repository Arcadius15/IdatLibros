package com.idat.idatLibros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.idatLibros.model.Libro;
import com.idat.idatLibros.repository.LibroRepository;

@Service
public class LibroServiceImple implements LibroService{
	
	@Autowired
	private LibroRepository libroRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Libro> listar() {
		return libroRepository.findAll();
	}

	@Override
	@Transactional
	public Libro registrar(Libro lib) {
		return libroRepository.save(lib);
	}

	@Override
	@Transactional
	public Libro actualizar(Libro lib) {
		return libroRepository.save(lib);
	}

	@Override
	@Transactional
	public boolean eliminar(int id) {
		Optional<Libro> opt = libroRepository.findById(id);
		if (opt.isPresent()) {
			libroRepository.delete(opt.get());
			return true;
		}
		return false;
	}

	@Override
	@Transactional(readOnly = true)
	public Libro buscar(int id) {
		return libroRepository.findById(id).orElse(null);
	}

}
