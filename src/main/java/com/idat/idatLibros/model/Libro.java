package com.idat.idatLibros.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro implements Serializable{

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
	private String descipcion;
	@Column
	private int paginas;
	@Column(columnDefinition = "bytea")
	private byte[] pdf;
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
	public String getDescipcion() {
		return descipcion;
	}
	public void setDescipcion(String descipcion) {
		this.descipcion = descipcion;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public byte[] getPdf() {
		return pdf;
	}
	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
	}
	public Libro() {
	}
	
	@ManyToOne
	@JoinColumn(name = "editorial_id",nullable = false,
		foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (editorial_id) references editorial(id)"))
	private Editorial editorial;
	
	@ManyToOne
	@JoinColumn(name = "autor_id",nullable = false,
		foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (autor_id) references autor(id)"))
	private Autor autor;
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	@ManyToMany(mappedBy = "libros_user")
	private Set<Usuario> usuario_libros;
	public Set<Usuario> getUsuario_libros() {
		return usuario_libros;
	}
	public void setUsuario_libros(Set<Usuario> usuario_libros) {
		this.usuario_libros = usuario_libros;
	}
	
	
	
	
}
