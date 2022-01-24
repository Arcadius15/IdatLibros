package com.idat.idatLibros.service;

import java.util.List;

import com.idat.idatLibros.model.Libro;

public interface LibroService {
	public List<Libro> listar();
	public Libro registrar(Libro lib);
	public Libro actualizar(Libro lib);
	public boolean eliminar(int id);
	public Libro buscar(int id);
}
