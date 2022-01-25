package com.idat.idatLibros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.idatLibros.model.Editorial;
import com.idat.idatLibros.repository.EditorialRepository;

@Service
public class EditorialServiceImpl implements EditorialService{
	
	@Autowired
	private EditorialRepository editorialRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Editorial> listar() {
		return editorialRepository.findAll();
	}

	@Override
	@Transactional
	public Editorial registrar(Editorial edit) {
		return editorialRepository.save(edit);
	}

	@Override
	@Transactional
	public Editorial actualizar(Editorial edit) {
		return editorialRepository.save(edit);
	}

	@Override
	@Transactional
	public boolean eliminar(int id) {
		Optional<Editorial> opt = editorialRepository.findById(id);
		if (opt.isPresent()) {
			editorialRepository.deleteById(id);
			return true;
		}
		return false;
		
	}

	@Override
	@Transactional(readOnly = true)
	public Editorial buscar(int id) {
		return editorialRepository.findById(id).orElse(null);
	}

}
