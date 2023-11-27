package com.ejemplos.models.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the img_artista database table.
 * 
 */
@Entity
@Table(name="img_artista")
@NamedQuery(name="ImgArtista.findAll", query="SELECT i FROM ImgArtista i")
public class ImgArtista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="url_imagen")
	private String urlImagen;

	//bi-directional one-to-one association to Artista
	@OneToOne(mappedBy="imgArtista")
	private Artista artista;

	public ImgArtista() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrlImagen() {
		return this.urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public Artista getArtista() {
		return this.artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	@Override
	public String toString() {
		return "ImgArtista [id=" + id + ", urlImagen=" + urlImagen + ", artista=" + artista + "]";
	}

}