package com.idat.idatLibros.service;

import java.util.List;

import com.idat.idatLibros.model.Autor;

public interface AutorService {
	public List<Autor> listar();
	public Autor registrar(Autor autor);
	public Autor actualizar(Autor autor);
	public boolean eliminar(int id);
	public Autor buscar(int id);

}
