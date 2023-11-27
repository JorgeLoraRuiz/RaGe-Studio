package com.ejemplos.models.service;

import com.ejemplos.models.dao.IAdminDao;
import com.ejemplos.models.entity.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminServiceImpl implements IAdminService{

	@Autowired
	private IAdminDao adminDao;

	@Override
	@Transactional(readOnly=true)
	public List<Admin> findAll(){
		return (List<Admin>) adminDao.findAll();
	}
	
	@Override
	@Transactional
	public void save (Admin admin) {
		System.out.print(adminDao.save(admin));
	}
	
	@Override
	@Transactional(readOnly=true)
	public Admin findOne(String nombre) {
		return adminDao.findById(nombre).orElse(null);
	}
	
	@Override
	@Transactional
	public void delete(String nombre) {
		adminDao.deleteById(nombre);
	}

}
