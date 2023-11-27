package com.ejemplos.models.service;

import java.util.List;

import com.ejemplos.models.entity.ImgArtista;

public interface IImgArtistaService {
	
	public List<ImgArtista> findAll();
	
	public void save(ImgArtista imgArtista);
	
	public ImgArtista findOne(Integer id);
	
	public void delete(Integer id);
	
}
