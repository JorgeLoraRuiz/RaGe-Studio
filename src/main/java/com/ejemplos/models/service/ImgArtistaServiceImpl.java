package com.ejemplos.models.service;

import com.ejemplos.models.dao.IImgArtistaDao;
import com.ejemplos.models.entity.ImgArtista;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ImgArtistaServiceImpl implements IImgArtistaService{

	@Autowired
	private IImgArtistaDao imgArtistaDao;

	@Override
	@Transactional(readOnly=true)
	public List<ImgArtista> findAll(){
		return (List<ImgArtista>) imgArtistaDao.findAll();
	}
	
	@Override
	@Transactional
	public void save (ImgArtista imgArtista) {
		System.out.print(imgArtistaDao.save(imgArtista));
	}
	
	@Override
	@Transactional(readOnly=true)
	public ImgArtista findOne(Integer id) {
		return imgArtistaDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		imgArtistaDao.deleteById(id);
	}

}
