package com.idat.idatLibros.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.idatLibros.model.Autor;
import com.idat.idatLibros.repository.AutorRepository;

@Service
public class AutorServiceImpl implements AutorService{
	
	@Autowired
	private AutorRepository autorRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Autor> listar() {
		return autorRepository.findAll();
	}

	@Override
	@Transactional
	public Autor registrar(Autor autor) {
		try {
			autor = autorRepository.save(autor);
		} catch (Exception e) {
			e.printStackTrace();
			return new Autor();
		}
		return autor;
	}

	@Override
	@Transactional
	public Autor actualizar(Autor autor) {
		try {
			autor = autorRepository.save(autor);
		} catch (Exception e) {
			e.printStackTrace();
			return new Autor();
		}
		return autor;
	}

	@Override
	@Transactional
	public boolean eliminar(int id) {
		try {
			autorRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public Autor buscar(int id) {
		Autor autor = null;
		try {
			Optional<Autor> opt = autorRepository.findById(id);
			if (opt.isPresent()) {
				autor = opt.get();
			}else {
				throw new Exception("No existe.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Autor();
		}
		return autor;
	}

}
