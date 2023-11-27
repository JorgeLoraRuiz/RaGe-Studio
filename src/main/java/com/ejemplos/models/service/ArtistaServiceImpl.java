package com.ejemplos.models.service;

import com.ejemplos.models.dao.IArtistaDao;
import com.ejemplos.models.entity.Artista;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArtistaServiceImpl implements IArtistaService{

	@Autowired
	private IArtistaDao artistaDao;

	@Override
	@Transactional(readOnly=true)
	public List<Artista> findAll(){
		return (List<Artista>) artistaDao.findAll();
	}
	
	@Override
	@Transactional
	public void save (Artista artista) {
		System.out.print(artistaDao.save(artista));
	}
	
	@Override
	@Transactional(readOnly=true)
	public Artista findOne(Integer id) {
		return artistaDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		artistaDao.deleteById(id);
	}

	@Override
	public Artista getArtistaByNombre(String nombre) {
		return artistaDao.getArtistaByNombre(nombre);
	}

	@Override
	public List<Artista> findAllSort() {
		return artistaDao.findAllSort();
	}

	@Override
	public List<Artista> busqueda(String nombre) {
		return artistaDao.busqueda(nombre);
	}

}
