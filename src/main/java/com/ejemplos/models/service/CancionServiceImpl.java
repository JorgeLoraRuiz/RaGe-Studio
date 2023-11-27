package com.ejemplos.models.service;

import com.ejemplos.models.dao.ICancionDao;
import com.ejemplos.models.entity.Cancion;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CancionServiceImpl implements ICancionService{

	@PersistenceContext
    private EntityManager entityManager;

	@Autowired
	private ICancionDao cancionDao;

	@Override
	@Transactional(readOnly=true)
	public List<Cancion> findAll(){
		return (List<Cancion>) cancionDao.findAll();
	}
	
	@Override
	@Transactional
	public void save (Cancion cancion) {
		System.out.print(cancionDao.save(cancion));
	}
	
	@Override
	@Transactional(readOnly=true)
	public Cancion findOne(Integer id) {
		return cancionDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		cancionDao.deleteById(id);
	}
	
	@Override
	public List<Cancion> ultimasCanciones() {
		return entityManager.createQuery("SELECT c FROM Cancion c ORDER BY c.fechaSalida DESC",
		          Cancion.class).setMaxResults(4).getResultList();
	}

	@Override
	public List<Cancion> busqueda(String nombre) {
		return cancionDao.busqueda(nombre);
	}

	@Override
	public Cancion getCancionFromNombre(String nombre) {
		return cancionDao.getCancionFromNombre(nombre);
	}

	@Override
	public Cancion esaCancionDeEseArtista(String nombre, String artista) {
		return cancionDao.esaCancionDeEseArtista(nombre, artista);
	}

}
