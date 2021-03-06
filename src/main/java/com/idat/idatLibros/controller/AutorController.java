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

import com.idat.idatLibros.model.Autor;
import com.idat.idatLibros.service.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorService autorService;
	
	@GetMapping(value = "/listar")
	public ResponseEntity<List<Autor>>  listar(){
		return new ResponseEntity<List<Autor>>(autorService.listar(),HttpStatus.OK) ;
	}
	
	@GetMapping(value = "/buscar/{id}")
	public ResponseEntity<Autor>  buscar(@PathVariable(name = "id") int id){
		try {
			Autor autor = autorService.buscar(id);
			return new ResponseEntity<Autor>(autor,HttpStatus.OK) ;
		} catch (Exception e) {
			return new ResponseEntity<Autor>(new Autor(),HttpStatus.NOT_FOUND);
		}
	} 
	
	
	
	@PostMapping(value = "/registrar")
	public ResponseEntity<Autor>  registrar(@RequestBody Autor autor)throws Exception {
		try {
			Autor reg = autorService.registrar(autor);
			return new ResponseEntity<Autor>(reg,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Autor>(new Autor(),HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping(value = "/editar")
	public ResponseEntity<Autor> editar(@RequestBody Autor autor){
		try {
			Autor reg = autorService.actualizar(autor);
			return new ResponseEntity<Autor>(reg,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Autor>(new Autor(),HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping(value = "/eliminar/{id}")
	public ResponseEntity<Boolean> eliminar(@PathVariable(name = "id") int id){
		boolean response = autorService.eliminar(id);
		if (response) {
			return new ResponseEntity<Boolean>(response,HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(response,HttpStatus.NOT_FOUND);
	}
	
}
