package com.ejemplos.models.service;

import java.util.List;

import com.ejemplos.models.entity.Admin;

public interface IAdminService {
	
	public List<Admin> findAll();
	
	public void save(Admin admin);
	
	public Admin findOne(String nombre);
	
	public void delete(String nombres);
	
}
