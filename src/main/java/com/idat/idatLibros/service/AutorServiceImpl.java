package com.idat.idatLibros.service;

import java.util.List;


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
	public List<Autor> listar() {
		return autorRepository.findAll();
	}

	@Override
	@Transactional
	public Autor registrar(Autor autor) {
		Autor newautor = null;
		try {
			newautor = autor;
			autorRepository.save(autor);
		} catch (Exception e) {
			e.printStackTrace();
			newautor = new Autor();
		}
		return newautor;
	}

	@Override
	public Autor actualizar(Autor autor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Autor buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
