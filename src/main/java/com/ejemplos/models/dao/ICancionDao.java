package com.ejemplos.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ejemplos.models.entity.Cancion;

public interface ICancionDao  extends JpaRepository<Cancion, Integer>{
	
	@Query(value="SELECT c FROM Cancion c WHERE c.nombre LIKE CONCAT('%',:nombre,'%') ORDER BY c.nombre")
	public List<Cancion> busqueda(String nombre);
	
	@Query(value="SELECT c FROM Cancion c WHERE c.nombre=:nombre")
	public Cancion getCancionFromNombre(String nombre);
	
	@Query(value="SELECT c FROM Cancion c WHERE c.nombre=:nombre AND c.artista.nombre=:artista")
	public Cancion esaCancionDeEseArtista(String nombre, String artista);
	
}