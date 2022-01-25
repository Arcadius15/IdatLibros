package com.idat.idatLibros.controller;

import java.util.List;
import java.util.Set;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.idat.idatLibros.model.Libro;
import com.idat.idatLibros.model.Usuario;
import com.idat.idatLibros.service.LibroService;
import com.idat.idatLibros.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private LibroService libroService;
	
	@GetMapping(value = "/listar")
	public ResponseEntity<List<Usuario>>  listar(){
		return new ResponseEntity<List<Usuario>>(usuarioService.listar(),HttpStatus.OK) ;
	}
	
	@GetMapping(value = "/buscar/{id}")
	public ResponseEntity<Usuario>  buscar(@PathVariable(name = "id") int id){
		try {
			Usuario usr = usuarioService.buscar(id);
			return new ResponseEntity<Usuario>(usr,HttpStatus.OK) ;
		} catch (Exception e) {
			return new ResponseEntity<Usuario>(new Usuario(),HttpStatus.NOT_FOUND);
		}
	} 
	
	
	
	@PostMapping(value = "/registrar")
	public ResponseEntity<Usuario>  registrar(@RequestBody Usuario lib)throws Exception {
		try {
			Usuario reg = usuarioService.registrar(lib);
			return new ResponseEntity<Usuario>(reg,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Usuario>(new Usuario(),HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/registrarLibro")
	public ResponseEntity<Usuario> registrarLibro(@RequestParam("idUser") int idUser,@RequestParam("idLibro") int idLibro){
		try {
			Usuario usr = usuarioService.buscar(idUser);
			Libro lib = libroService.buscar(idLibro);
			Set<Libro> user_libro = usr.getLibros_user();
			user_libro.add(lib);
			usr.setLibros_user(user_libro);
			usr = usuarioService.actualizar(usr);
			return new ResponseEntity<Usuario>(usr,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Usuario>(new Usuario(),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping(value = "/editar")
	public ResponseEntity<Usuario> editar(@RequestBody Usuario usr){
		try {
			Usuario reg = usuarioService.actualizar(usr);
			return new ResponseEntity<Usuario>(reg,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Usuario>(new Usuario(),HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping(value = "/eliminar/{id}")
	public ResponseEntity<Boolean> eliminar(@PathVariable(name = "id") int id){
		boolean response = usuarioService.eliminar(id);
		if (response) {
			return new ResponseEntity<Boolean>(response,HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(response,HttpStatus.NOT_FOUND);
	}

}
