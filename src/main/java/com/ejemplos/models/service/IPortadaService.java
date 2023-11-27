package com.ejemplos.models.service;

import java.util.List;

import com.ejemplos.models.entity.Portada;

public interface IPortadaService {
	
	public List<Portada> findAll();
	
	public void save(Portada portada);
	
	public Portada findOne(Integer id);
	
	public void delete(Integer id);
	
}
