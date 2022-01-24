package com.idat.idatLibros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.idatLibros.model.Autor;
import com.idat.idatLibros.service.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorService autorService;
	
	@GetMapping(value = "/listar")
	public List<Autor> listar(){
		return autorService.listar();
	}
	
	@PostMapping(value = "/registrar")
	public Autor registrar(@RequestBody Autor autor) {
		System.out.println(autor.getNombre() + autor.getApellido());
		Autor reg = autorService.registrar(autor);
		return reg;
	}
	
}
