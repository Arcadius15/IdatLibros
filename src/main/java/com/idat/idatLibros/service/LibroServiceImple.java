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
		try {
			lib = libroRepository.save(lib);
		} catch (Exception e) {
			e.printStackTrace();
			return new Libro();
		}
		return lib;
	}

	@Override
	@Transactional
	public Libro actualizar(Libro lib) {
		try {
			lib = libroRepository.save(lib);
		} catch (Exception e) {
			e.printStackTrace();
			return new Libro();
		}
		return lib;
	}

	@Override
	@Transactional
	public boolean eliminar(int id) {
		try {
			libroRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public Libro buscar(int id) {
		Libro lib = null;
		try {
			Optional<Libro> opt = libroRepository.findById(id);
			if (opt.isPresent()) {
				lib = opt.get();
			}
			else {
				throw new Exception("No encontrado.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Libro();
		}
		return lib;
	}

}
