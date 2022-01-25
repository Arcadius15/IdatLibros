package com.idat.idatLibros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.idatLibros.model.Libro;
import com.idat.idatLibros.service.LibroService;

@RestController
@RequestMapping("/libro")
public class LibroController {
	@Autowired
	private LibroService libroService;
	
	@GetMapping(value = "/listar")
	public ResponseEntity<List<Libro>>  listar(){
		return new ResponseEntity<List<Libro>>(libroService.listar(),HttpStatus.OK) ;
	}
	
	@GetMapping(value = "/buscar/{id}")
	public ResponseEntity<Libro>  buscar(@PathVariable(name = "id") int id){
		try {
			Libro lib = libroService.buscar(id);
			return new ResponseEntity<Libro>(lib,HttpStatus.OK) ;
		} catch (Exception e) {
			return new ResponseEntity<Libro>(new Libro(),HttpStatus.NOT_FOUND);
		}
	} 
	
	
	
	@PostMapping(value = "/registrar")
	public ResponseEntity<Libro>  registrar(@RequestBody Libro lib)throws Exception {
		try {
			Libro reg = libroService.registrar(lib);
			return new ResponseEntity<Libro>(reg,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Libro>(new Libro(),HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping(value = "/editar")
	public ResponseEntity<Libro> editar(@RequestBody Libro lib){
		try {
			Libro reg = libroService.actualizar(lib);
			return new ResponseEntity<Libro>(reg,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Libro>(new Libro(),HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping(value = "/eliminar/{id}")
	public ResponseEntity<Boolean> eliminar(@PathVariable(name = "id") int id){
		boolean response = libroService.eliminar(id);
		if (response) {
			return new ResponseEntity<Boolean>(response,HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(response,HttpStatus.NOT_FOUND);
	}
}
