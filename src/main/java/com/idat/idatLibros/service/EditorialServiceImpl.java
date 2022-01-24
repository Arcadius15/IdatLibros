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
		try {
			edit =editorialRepository.save(edit);
		} catch (Exception e) {
			e.printStackTrace();
			return new Editorial();
		}
		return edit;
	}

	@Override
	@Transactional
	public Editorial actualizar(Editorial edit) {
		try {
			edit = editorialRepository.save(edit);
		} catch (Exception e) {
			e.printStackTrace();
			return new Editorial();
		}
		return edit;
	}

	@Override
	@Transactional
	public boolean eliminar(int id) {
		try {
			editorialRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public Editorial buscar(int id) {
		Editorial edit = null;
		try {
			Optional<Editorial> opt = editorialRepository.findById(id);
			if (opt.isPresent()) {
				edit = opt.get();
			}
			else {
				throw new Exception("No encontrado.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			edit = new Editorial();
		}
		return edit;
	}

}
