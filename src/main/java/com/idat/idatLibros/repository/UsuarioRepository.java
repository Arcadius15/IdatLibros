package com.idat.idatLibros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.idatLibros.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
