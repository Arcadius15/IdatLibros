package com.idat.idatLibros.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "autor")
public class Autor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private int libros;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getLibros() {
		return libros;
	}
	public void setLibros(int libros) {
		this.libros = libros;
	}
	public Autor() {
	}
	
	@OneToMany(mappedBy = "autor")
	private Collection<Libro> itemsLibro = new ArrayList<>();
	public Collection<Libro> getItemsLibro() {
		return itemsLibro;
	}
	public void setItemsLibro(Collection<Libro> itemsLibro) {
		this.itemsLibro = itemsLibro;
	}
	
	
	
	
}
