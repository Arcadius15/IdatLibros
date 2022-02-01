package com.idat.idatLibros.Request;

import com.idat.idatLibros.model.Libro;

public class RegLibro {

	private Libro libro;
	private String base64;
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public String getBase64() {
		return base64;
	}
	public void setBase64(String base64) {
		this.base64 = base64;
	}
	
	
}
