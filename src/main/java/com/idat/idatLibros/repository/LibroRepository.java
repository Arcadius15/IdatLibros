package com.idat.idatLibros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.idatLibros.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer>{

}
