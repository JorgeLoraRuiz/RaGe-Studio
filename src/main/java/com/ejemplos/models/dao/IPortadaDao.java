package com.ejemplos.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ejemplos.models.entity.Portada;

public interface IPortadaDao  extends JpaRepository<Portada, Integer>{
	
}