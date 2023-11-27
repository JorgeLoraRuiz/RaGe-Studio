package com.ejemplos.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ejemplos.models.entity.Artista;

public interface IArtistaDao  extends CrudRepository<Artista, Integer>{
	
	@Query(value="SELECT a FROM Artista a WHERE a.nombre=:nombre")
	public Artista getArtistaByNombre(String nombre);
	
	@Query(value="SELECT a FROM Artista a ORDER BY a.nombre")
	public List<Artista> findAllSort();
	
	@Query(value="SELECT a FROM Artista a WHERE a.nombre LIKE CONCAT('%',:nombre,'%') ORDER BY a.nombre")
	public List<Artista> busqueda(String nombre);
	
}