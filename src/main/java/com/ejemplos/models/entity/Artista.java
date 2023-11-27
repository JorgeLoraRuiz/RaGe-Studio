package com.ejemplos.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the artista database table.
 * 
 */
@Entity
@NamedQuery(name="Artista.findAll", query="SELECT a FROM Artista a")
public class Artista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nombre;

	//bi-directional many-to-one association to Cancion
	@OneToMany(mappedBy="artista")
	private List<Cancion> canciones;

	//bi-directional one-to-one association to Descripcion
	@OneToOne
	@JoinColumn(name="id", referencedColumnName="id_artista")
	private Descripcion descripcion;

	//bi-directional one-to-one association to ImgArtista
	@OneToOne
	@JoinColumn(name="id", referencedColumnName="id_artista")
	private ImgArtista imgArtista;

	public Artista() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cancion> getCanciones() {
		return this.canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}

	public Cancion addCancion(Cancion cancion) {
		getCanciones().add(cancion);
		cancion.setArtista(this);

		return cancion;
	}

	public Cancion removeCancion(Cancion cancion) {
		getCanciones().remove(cancion);
		cancion.setArtista(null);

		return cancion;
	}

	public Descripcion getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(Descripcion descripcion) {
		this.descripcion = descripcion;
	}

	public ImgArtista getImgArtista() {
		return this.imgArtista;
	}

	public void setImgArtista(ImgArtista imgArtista) {
		this.imgArtista = imgArtista;
	}

	@Override
	public String toString() {
		return "Artista [id=" + id + ", nombre=" + nombre + "]";
	}

}