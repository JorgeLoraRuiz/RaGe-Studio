package com.ejemplos.models.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplos.models.entity.Admin;

public interface IAdminDao  extends JpaRepository<Admin, String>{
	
	
}