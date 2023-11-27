package com.ejemplos.models.service;

import java.util.List;

import com.ejemplos.models.entity.Cancion;

public interface ICancionService {
	
	public List<Cancion> findAll();
	
	public void save(Cancion cancion);
	
	public Cancion findOne(Integer id);
	
	public void delete(Integer id);
	
	public List<Cancion> ultimasCanciones();
	
	public List<Cancion> busqueda(String nombre);
	
	public Cancion getCancionFromNombre(String nombre);
	
	public Cancion esaCancionDeEseArtista(String nombre, String artista);
	
}
