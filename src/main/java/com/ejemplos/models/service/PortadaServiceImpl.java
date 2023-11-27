package com.ejemplos.models.service;

import com.ejemplos.models.dao.IPortadaDao;
import com.ejemplos.models.entity.Portada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PortadaServiceImpl implements IPortadaService{

	@Autowired
	private IPortadaDao portadaDao;

	@Override
	@Transactional(readOnly=true)
	public List<Portada> findAll(){
		return (List<Portada>) portadaDao.findAll();
	}
	
	@Override
	@Transactional
	public void save (Portada portada) {
		System.out.print(portadaDao.save(portada));
	}
	
	@Override
	@Transactional(readOnly=true)
	public Portada findOne(Integer id) {
		return portadaDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		portadaDao.deleteById(id);
	}

}
