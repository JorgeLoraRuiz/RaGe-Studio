package com.ejemplos.models.auxiliares;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ejemplos.models.entity.*;

public class Consultas {
	
	String url = "jdbc:mysql://localhost:3306/rage_studio?serverTimezone=UTC";
	String usuario = "usuario";
	String contra = "usuario";
	
	public void guardarDescArtista(Artista newA, Descripcion newD) {
		
		try {
			Connection conexion = DriverManager.getConnection(url, usuario, contra);
			
			String save = "INSERT INTO descripcion (texto, id_artista) VALUES (?, ?)";
			PreparedStatement preparedStatement = conexion.prepareStatement(save);
			preparedStatement.setString(1, newD.getTexto());
			preparedStatement.setString(2, String.valueOf(newA.getId()));
			
			int filasAfectadas = preparedStatement.executeUpdate();
			
			if (filasAfectadas > 0) {
				System.out.println("Inserción exitosa");
			} else {
				System.out.println("Error al insertar la descripción del artista "+newA.getId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void guardarImgArtista(Artista newA, String urlImagen) {
		
		try {
			Connection conexion = DriverManager.getConnection(url, usuario, contra);
			
			String save = "INSERT INTO img_artista (url_imagen, id_artista) VALUES (?, ?)";
			PreparedStatement preparedStatement = conexion.prepareStatement(save);
			preparedStatement.setString(1, urlImagen);
			preparedStatement.setString(2, String.valueOf(newA.getId()));
			
			int filasAfectadas = preparedStatement.executeUpdate();
			
			if (filasAfectadas > 0) {
				System.out.println("Inserción exitosa");
			} else {
				System.out.println("Error al insertar la imagen del artista "+newA.getId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void guardarImgCancion(Cancion newC, String urlImagen) {
		
		try {
			Connection conexion = DriverManager.getConnection(url, usuario, contra);
			
			String save = "INSERT INTO portadas (url, id_cancion) VALUES (?, ?)";
			PreparedStatement preparedStatement = conexion.prepareStatement(save);
			preparedStatement.setString(1, urlImagen);
			preparedStatement.setString(2, String.valueOf(newC.getId()));
			
			int filasAfectadas = preparedStatement.executeUpdate();
			
			if (filasAfectadas > 0) {
				System.out.println("Inserción exitosa");
			} else {
				System.out.println("Error al insertar la imagen de la canción "+newC.getId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Descripcion getDescByArtista(Integer id) {
		
		try {
			Connection conexion = DriverManager.getConnection(url, usuario, contra);
			
			String get = "SELECT id, texto FROM descripcion WHERE id_artista = ?";
			PreparedStatement preparedStatement = conexion.prepareStatement(get);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			Descripcion d = new Descripcion();
			
			while (resultSet.next()) {
				Integer d1 = resultSet.getInt("id");
				String d2 = resultSet.getString("texto");
				d.setId(d1);
				d.setTexto(d2);
			}
			
			resultSet.close();
			preparedStatement.close();
			conexion.close();
			
			return d;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
}
