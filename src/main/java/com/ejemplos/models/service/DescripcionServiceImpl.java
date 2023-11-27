package com.ejemplos.models.service;

import com.ejemplos.models.dao.IDescripcionDao;
import com.ejemplos.models.entity.Descripcion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DescripcionServiceImpl implements IDescripcionService{

	@Autowired
	private IDescripcionDao descripcionDao;

	@Override
	@Transactional(readOnly=true)
	public List<Descripcion> findAll(){
		return (List<Descripcion>) descripcionDao.findAll();
	}
	
	@Override
	@Transactional
	public void save (Descripcion descripcion) {
		System.out.print(descripcionDao.save(descripcion));
	}
	
	@Override
	@Transactional(readOnly=true)
	public Descripcion findOne(Integer id) {
		return descripcionDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		descripcionDao.deleteById(id);
	}

}
