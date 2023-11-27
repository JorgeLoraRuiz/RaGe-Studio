package com.ejemplos.models.service;

import com.ejemplos.models.dao.IEnlaceDao;
import com.ejemplos.models.entity.Enlace;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnlaceServiceImpl implements IEnlaceService{

	@Autowired
	private IEnlaceDao enlaceDao;

	@Override
	@Transactional(readOnly=true)
	public List<Enlace> findAll(){
		return (List<Enlace>) enlaceDao.findAll();
	}
	
	@Override
	@Transactional
	public void save (Enlace enlace) {
		System.out.print(enlaceDao.save(enlace));
	}
	
	@Override
	@Transactional(readOnly=true)
	public Enlace findOne(Integer id) {
		return enlaceDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		enlaceDao.deleteById(id);
	}

	@Override
	public Enlace getYTEmbed(Integer id) {
		return enlaceDao.getYTEmbed(id);
	}

	@Override
	public Enlace getSpotifyEmbed(Integer id) {
		return enlaceDao.getSpotifyEmbed(id);
	}

}
