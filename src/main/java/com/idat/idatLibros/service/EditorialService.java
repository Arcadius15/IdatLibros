package com.idat.idatLibros.service;

import java.util.List;

import com.idat.idatLibros.model.Editorial;

public interface EditorialService {
	public List<Editorial> listar();
	public Editorial registrar(Editorial edit);
	public Editorial actualizar(Editorial edit);
	public boolean eliminar(int id);
	public Editorial buscar(int id);

	
}
