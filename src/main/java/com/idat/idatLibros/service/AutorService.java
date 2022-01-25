package com.idat.idatLibros.service;

import java.util.List;

import org.hibernate.PropertyValueException;

import com.idat.idatLibros.model.Autor;

public interface AutorService {
	public List<Autor> listar();
	public Autor registrar(Autor autor) throws PropertyValueException;
	public Autor actualizar(Autor autor);
	public boolean eliminar(int id);
	public Autor buscar(int id);

}
