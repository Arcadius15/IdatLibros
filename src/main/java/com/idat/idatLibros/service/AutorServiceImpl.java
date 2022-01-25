package com.idat.idatLibros.service;


import java.util.List;
import java.util.Optional;

import org.hibernate.PropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Propagation;
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
	public Autor registrar(Autor autor){
		return autorRepository.save(autor);
	}

	@Override
	@Transactional
	public Autor actualizar(Autor autor) {
		return autorRepository.save(autor);
	}

	@Override
	@Transactional
	public boolean eliminar(int id) {
		Optional<Autor> opt = autorRepository.findById(id);
		if (opt.isPresent()) {
			autorRepository.delete(opt.get());
			return true;
		}
		return false;
	}

	@Override
	@Transactional(readOnly = true)
	public Autor buscar(int id) {
		return autorRepository.findById(id).orElse(null);
	}

}
