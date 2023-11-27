package com.ejemplos.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplos.models.entity.ImgArtista;

public interface IImgArtistaDao  extends JpaRepository<ImgArtista, Integer>{
	
}