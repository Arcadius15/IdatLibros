package com.idat.idatLibros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.idat.idatLibros.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query("SELECT u FROM Usuario u WHERE u.correo =  :correo")
	Usuario findUsuarioByCorreo (@Param("correo") String correo);
	

}
