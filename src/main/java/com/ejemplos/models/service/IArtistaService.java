package com.ejemplos.models.service;

import java.util.List;

import com.ejemplos.models.entity.Artista;

public interface IArtistaService {
	
	public List<Artista> findAll();
	
	public void save(Artista artista);
	
	public Artista findOne(Integer id);
	
	public void delete(Integer id);
	
	public Artista getArtistaByNombre(String nombre);
	
	public List<Artista> findAllSort();
	
	public List<Artista> busqueda(String nombre);
	
}
