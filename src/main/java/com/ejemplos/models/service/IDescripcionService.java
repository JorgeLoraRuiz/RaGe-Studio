package com.ejemplos.models.service;

import java.util.List;

import com.ejemplos.models.entity.Descripcion;

public interface IDescripcionService {
	
	public List<Descripcion> findAll();
	
	public void save(Descripcion descripcion);
	
	public Descripcion findOne(Integer id);
	
	public void delete(Integer id);
	
}
