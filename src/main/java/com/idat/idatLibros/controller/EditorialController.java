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

import com.idat.idatLibros.model.Editorial;
import com.idat.idatLibros.service.EditorialService;

@RestController
@RequestMapping("/editorial")
public class EditorialController {
	
	@Autowired
	private EditorialService editorialService;
	
	@GetMapping(value = "/listar")
	public ResponseEntity<List<Editorial>>  listar(){
		return new ResponseEntity<List<Editorial>>(editorialService.listar(),HttpStatus.OK) ;
	}
	
	@GetMapping(value = "/buscar/{id}")
	public ResponseEntity<Editorial>  buscar(@PathVariable(name = "id") int id){
		try {
			Editorial edt = editorialService.buscar(id);
			return new ResponseEntity<Editorial>(edt,HttpStatus.OK) ;
		} catch (Exception e) {
			return new ResponseEntity<Editorial>(new Editorial(),HttpStatus.NOT_FOUND);
		}
	} 
	
	
	
	@PostMapping(value = "/registrar")
	public ResponseEntity<Editorial>  registrar(@RequestBody Editorial edt)throws Exception {
		try {
			Editorial reg = editorialService.registrar(edt);
			return new ResponseEntity<Editorial>(reg,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Editorial>(new Editorial(),HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping(value = "/editar")
	public ResponseEntity<Editorial> editar(@RequestBody Editorial edt){
		try {
			Editorial reg = editorialService.actualizar(edt);
			return new ResponseEntity<Editorial>(reg,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Editorial>(new Editorial(),HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping(value = "/eliminar/{id}")
	public ResponseEntity<Boolean> eliminar(@PathVariable(name = "id") int id){
		boolean response = editorialService.eliminar(id);
		if (response) {
			return new ResponseEntity<Boolean>(response,HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(response,HttpStatus.NOT_FOUND);
	}

}
