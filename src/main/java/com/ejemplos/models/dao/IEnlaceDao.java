package com.ejemplos.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ejemplos.models.entity.Enlace;

public interface IEnlaceDao  extends JpaRepository<Enlace, Integer>{
	
	@Query(value="SELECT e FROM Enlace e WHERE e.tienda.id=5 AND e.cancion.id=:id")
	public Enlace getYTEmbed(Integer id);
	
	@Query(value="SELECT e FROM Enlace e WHERE e.tienda.id=6 AND e.cancion.id=:id")
	public Enlace getSpotifyEmbed(Integer id);
	
}