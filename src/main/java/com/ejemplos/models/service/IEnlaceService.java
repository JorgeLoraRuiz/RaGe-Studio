package com.ejemplos.models.service;

import java.util.List;

import com.ejemplos.models.entity.Enlace;

public interface IEnlaceService {
	
	public List<Enlace> findAll();
	
	public void save(Enlace enlace);
	
	public Enlace findOne(Integer id);
	
	public void delete(Integer id);
	
	public Enlace getYTEmbed(Integer id);
	
	public Enlace getSpotifyEmbed(Integer id);
	
}
