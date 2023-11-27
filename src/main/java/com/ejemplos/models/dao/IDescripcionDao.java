package com.ejemplos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ejemplos.models.entity.Descripcion;

public interface IDescripcionDao  extends CrudRepository<Descripcion, Integer>{
	
}